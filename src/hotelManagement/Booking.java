package hotelManagement;

import java.io.Serializable;

public class Booking implements Serializable {

    private int hotelRoomToBook;
    private String dateToBook;
    private int accountNumber;
    boolean checkedIn;

    public Booking(int hotelRoomToBook,String dateToBook, int accountNumber, boolean checkedIn) {
        this.hotelRoomToBook = hotelRoomToBook;
        this.dateToBook = dateToBook;
        this.accountNumber = accountNumber;
        this.checkedIn = checkedIn;
    }

    public int getHotelRoomToBook() {
        return hotelRoomToBook;
    }

    public void setHotelRoomToBook(int hotelRoomToBook) {
        this.hotelRoomToBook = hotelRoomToBook;
    }

    public String getDateToBook() { return dateToBook; }

    public void setDateToBook(String dateToBook) {
        this.dateToBook = dateToBook;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }
}
