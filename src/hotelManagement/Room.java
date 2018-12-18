package hotelManagement;

public class Room {
    private int roomNumber;
    private int numberOfBeds;
    private boolean hasBalcony;
    private double pricePerNight;
    private String isBooked;
    private int floor;

    public Room(int roomNumber, int numberOfBeds, boolean hasBalcony, double pricePerNight, String isBooked, int floor) {
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.hasBalcony = hasBalcony;
        this.pricePerNight = pricePerNight;
        this.isBooked = isBooked;
        this.floor = floor;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getFloor() { return floor; }

    public void setFloor(int floor){this.floor = floor;}

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public boolean isHasBalcony() {
        return hasBalcony;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    public String getIsBooked() { return isBooked; }

    public void setIsBooked(String isBooked) { this.isBooked = isBooked; }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setDateBooking(String dateToBook){
        isBooked += dateToBook + ", ";
    }
}


