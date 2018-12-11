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

        //skapar en loop som loopar tills man "exitar"-Ludde
        do {
            PrintMenus.viewMenu();
            int choice = Integer.parseInt(getMethod.input.nextLine());
            switch (choice) {
                case 1:
                    hotelLogic.viewCustomer(arrayListCustomer);
                    break;
                case 2:
                    hotelLogic.viewRoom(hotelRooms);
                    break;
                case 3:
                    break;
                case 4:
                    hotelRooms = hotelLogic.addRoom(hotelRooms);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    arrayListCustomer = hotelLogic.addCustomer(arrayListCustomer);
                    break;
                case 8:
                    arrayListCustomer = hotelLogic.removeCustomer(arrayListCustomer, bookings);
                    break;
                case 9:
                    hotelLogic.viewBookings(bookings);
                    break;
                case 10:
                    bookings = hotelLogic.makeBooking(bookings, arrayListCustomer, hotelRooms);
                    break;
                case 11:
                    hotelLogic.viewBookings(bookings);
                    break;
                case 12:
                    hotelLogic.viewInfoAboutCustomer(arrayListCustomer);
                    break;
                default:
                    System.out.println("Incorrect input, enter a number between 1-10");
                    break;
            }
        } while (a);
    }
}
