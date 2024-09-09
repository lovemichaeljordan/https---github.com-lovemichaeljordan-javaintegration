package lu.ics.se;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import lu.ics.se.models.Guest;
import lu.ics.se.models.Room;

public class PrimaryController {
    @FXML
    private Button fetchGuestsButton;

    @FXML
    private Button fetchRoomsButton;

    @FXML
    private Button clearGuestsButton;

    @FXML
    private Button clearRoomsButton;

    @FXML
    private ListView<String> guestsListView;

    @FXML
    private ListView<String> roomsListView;

    private final String baseUrl = "http://localhost:5253/api";
    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    @FXML
    private void initialize() {
        fetchGuestsButton.setOnAction(event -> fetchGuests());
        fetchRoomsButton.setOnAction(event -> fetchRooms());
        clearGuestsButton.setOnAction(event -> clearGuests());
        clearRoomsButton.setOnAction(event -> clearRooms());
    }

    private void fetchGuests() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/guests"))
                .GET()
                .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(body -> gson.fromJson(body, Guest[].class))
                .thenAccept(guests -> Platform.runLater(() -> {
                    guestsListView.getItems().clear();
                    List<Guest> guestList = Arrays.asList(guests);
                    for (Guest guest : guestList) {
                        guestsListView.getItems().add("Name: " + guest.getName() +
                                                      "\nEmail: " + guest.getEmail() +
                                                      "\nPhone: " + guest.getPhone() +
                                                      "\nAddress: " + guest.getAddress());
                    }
                }))
                .exceptionally(e -> {
                    e.printStackTrace();
                    return null;
                });
    }

    private void fetchRooms() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/rooms"))
                .GET()
                .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(body -> gson.fromJson(body, Room[].class))
                .thenAccept(rooms -> Platform.runLater(() -> {
                    roomsListView.getItems().clear();
                    List<Room> roomList = Arrays.asList(rooms);
                    for (Room room : roomList) {
                        roomsListView.getItems().add("Room " + room.getRoomNumber() +
                                                     "\nType: " + room.getType() +
                                                     "\nPrice: $" + room.getPricePerNight() +
                                                     "\nStatus: " + (room.isOccupied() ? "Occupied" : "Available"));
                    }
                }))
                .exceptionally(e -> {
                    e.printStackTrace();
                    return null;
                });
    }

    private void clearGuests() {
        guestsListView.getItems().clear();
    }

    private void clearRooms() {
        roomsListView.getItems().clear();
    }
}
