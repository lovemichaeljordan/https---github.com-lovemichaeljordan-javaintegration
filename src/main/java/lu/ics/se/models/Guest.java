package lu.ics.se.models;

public class Guest {
    private int guestId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private int roomID;
    private Room room;

    public Guest() {
        // Default constructor for Gson
    }

    public Guest(int guestId, String name, String email, String phone, String address, int roomID) {
        this.guestId = guestId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.roomID = roomID;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return name + " (" + email + ")";
    }
}
