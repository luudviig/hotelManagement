package hotelManagement;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Main getMethod = new Main();

        //plats för variabler
        boolean a = true;
        boolean b = true;
        boolean c = true;
        CreateFile createFile = new CreateFile();
        ReadFile readFile = new ReadFile();
        ArrayList<Customer> arrayListCustomer = new ArrayList<>();
        HotelLogic hotelLogic = new HotelLogic();
        ArrayList<Room> hotelRooms = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();
        ArrayList<Booking> previousBookings = new ArrayList<>();

        //kallar på metod som skapar alla rum.
        hotelRooms = hotelLogic.createArrayListOfRooms(hotelRooms);
        //Kallar på metod som skapar en customer.
        arrayListCustomer = hotelLogic.addOneCustomerToArrayList(arrayListCustomer);

        //skapar en loop som loopar tills man "exitar"-Ludde
        do {
            try {
                PrintMenus.printMenu();
                int answer = Integer.parseInt(input.nextLine());
                b = true;
                switch (answer) {
                    case 1:
                        do {
                            try {
                                c = true;
                                PrintMenus.viewMenuEmployeer1();
                                int choise1 = Integer.parseInt(input.nextLine());
                                if (choise1 == 1) {
                                    do {
                                        try {
                                            PrintMenus.viewMenuEmployerOption1();
                                            int choise2 = Integer.parseInt(input.nextLine());
                                            if (choise2 == 1) {
                                                hotelLogic.viewCustomer(arrayListCustomer);
                                            } else if (choise2 == 2) {
                                                arrayListCustomer = hotelLogic.addCustomer(arrayListCustomer);
                                            } else if (choise2 == 3) {
                                                arrayListCustomer = hotelLogic.removeCustomer(arrayListCustomer, bookings);
                                            } else if (choise2 == 4) {
                                                arrayListCustomer = hotelLogic.editCustomInfo(arrayListCustomer);
                                            } else if (choise2 == 5) {
                                            hotelLogic.viewCurrentBookingsSpecificCustomer(bookings);
                                            } else if (choise2 == 6) {
                                                hotelLogic.viewPreviousBookingsForSpecificCustomer(previousBookings);
                                            } else if (choise2 == 7) {
                                                hotelLogic.viewInfoAboutCustomer(arrayListCustomer, bookings, previousBookings);
                                            } else if (choise2 == 8) {
                                                c = false;
                                            } else {
                                                System.out.println("Incorrect input..");
                                            }
                                        } catch (Exception e) {
                                            System.out.println("Incorrect input..");
                                        }
                                    } while (c);
                                } else if (choise1 == 2) {
                                    do {
                                        try {
                                            PrintMenus.viewMenuEmployerOption2();
                                            int choise4 = Integer.parseInt(input.nextLine());
                                            if (choise4 == 1) {
                                                hotelLogic.viewRoom(hotelRooms, bookings);
                                            } else if (choise4 == 2) {
                                                hotelLogic.availableRooms(hotelRooms);
                                            } else if (choise4 == 3) {
                                                hotelRooms = hotelLogic.addRoom(hotelRooms);
                                            } else if (choise4 == 4) {
                                                hotelRooms = hotelLogic.removeRoom(hotelRooms,bookings);
                                            } else if (choise4 == 5) {
                                                hotelRooms = hotelLogic.editRoom(hotelRooms);
                                            } else if (choise4 == 6) {
                                                c = false;
                                            } else {
                                                System.out.println("Incorrect input..");
                                            }
                                        } catch (Exception e) {
                                            System.out.println("Incorrect input..");
                                        }
                                    } while (c);
                                } else if (choise1 == 3) {
                                    do {
                                        try {
                                            PrintMenus.viewMenuEmployerOption3();
                                            int choise2 = Integer.parseInt(input.nextLine());
                                            if (choise2 == 1) {
                                                readFile.openFile();
                                                readFile.readFile();
                                                readFile.closeFile();
                                            } else if (choise2 == 2) {
                                                hotelLogic.viewCurrentBookings(bookings);
                                            } else if (choise2 == 3) {
                                                bookings = hotelLogic.makeBooking(bookings, arrayListCustomer, hotelRooms);
                                                createFile.openFile();
                                                createFile.addRecord(bookings.get(bookings.size() - 1));
                                                createFile.closeFile();
                                            } else if (choise2 == 4) {
                                                hotelLogic.removeBooking(bookings, arrayListCustomer, hotelRooms, previousBookings);
                                            } else if (choise2 == 5) {
                                                hotelLogic.searchBooking(bookings);
                                            } else if (choise2 == 6) {
                                                hotelLogic.editBookingInfo(bookings,hotelRooms,arrayListCustomer);
                                            } else if (choise2 == 7) {
                                                hotelLogic.checkIn(bookings,arrayListCustomer);
                                            } else if (choise2 == 8) {
                                                hotelLogic.checkOut(bookings,arrayListCustomer,previousBookings,hotelRooms);
                                            } else if (choise2 == 9) {
                                                c = false;
                                            } else {
                                                System.out.println("Incorrect input..");
                                            }
                                        } catch (Exception e) {
                                        System.out.println("Incorrect input..");
                                    }
                                    } while (c);
                                } else if (choise1 == 4) {
                                    b = false;
                                } else {
                                    System.out.println("Incorrect input..");
                                }
                            } catch (Exception e) {
                                System.out.println("Incorrect input..");
                            }
                        } while (b);
                        break;
                    case 2:
                        PrintMenus.printByeMessage();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Incorrect input..");
                }
            } catch (Exception e) {
                System.out.println("Incorrect input..");
            }
        } while (a);
    }
}



