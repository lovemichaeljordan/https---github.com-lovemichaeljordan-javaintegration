package lu.ics.se.models;


public class Room {
    private int roomID;
    private int roomNumber;
    private String type;
    private double pricePerNight;
    private boolean isOccupied;

    public Room(int roomID, int roomNumber, String type, double pricePerNight, boolean isOccupied) {
        this.roomID = roomID;
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.isOccupied = isOccupied;
    }

    //getter and setters, fix it for me
    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}

