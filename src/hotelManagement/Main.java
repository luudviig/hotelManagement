package hotelManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Main getMethod = new Main();

        //plats för variabler
        boolean a = true;
        ArrayList<Customer> arrayListCustomer = new ArrayList<>();
        HotelLogic hotelLogic = new HotelLogic();
        ArrayList<Room> hotelRooms = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();

        //kallar på metod som skapar alla rum.
        hotelRooms = hotelLogic.createArrayListOfRooms(hotelRooms);

    }
}
