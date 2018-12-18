package hotelManagement;

import java.io.Serializable;

public class Booking implements Serializable {
    private int hotelRoomToBook;
    private String dateToBook;
    private int accountNumber;


    public Booking(int hotelRoomToBook,String dateToBook, int accountNumber) {
        this.hotelRoomToBook = hotelRoomToBook;
        this.dateToBook = dateToBook;
        this.accountNumber = accountNumber;
    }

    public int getHotelRoomToBook() {
        return hotelRoomToBook;
    }

    public void setHotelRoomToBook(int hotelRoomToBook) {
        this.hotelRoomToBook = hotelRoomToBook;
    }

    public String getDateToBook() {
        return dateToBook;
    }

    public void setDateToBook(String dateToBook) {
        this.dateToBook = dateToBook;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
