package hotelManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelLogic {
    private Scanner input = new Scanner(System.in);

    public void searchBooking(ArrayList<Booking> bookings) {
        System.out.println("What date would you like to see bookings? ");
        String dateToSearchFor = input.nextLine();

                for (int i = 0; i < bookings.size(); i++) {
                    if (bookings.get(i).getDateToBook() == dateToSearchFor) {

                        System.out.println("Booking belons to account: " + bookings.get(i).getAccountNumber());
                        System.out.println("Booked during: " + bookings.get(i).getDateToBook());
                        System.out.println("Room booked: " + bookings.get(i).getHotelRoomToBook());
                    }
                }
    }

    public ArrayList<Room> createArrayListOfRooms(ArrayList<Room> hotelRooms) {
        //adds rooms for floor 1-Ludde
        for (int i = 0; i < 3; i++) {
            Room room = new Room((i + 1), 1, false, 2000, false, 1);
            hotelRooms.add(room);
        }
        //adds rooms for floor 2-Ludde
        for (int i = 3; i < 6; i++) {
            Room room = new Room((i + 1), 2, true, 2500, false, 2);
            hotelRooms.add(room);
        }
        //adds rooms for floor 3-Ludde
        for (int i = 6; i < 9; i++) {
            Room room = new Room((i + 1), 2, true, 2700, false, 3);
            hotelRooms.add(room);
        }
        return hotelRooms;
    }

    public ArrayList<Customer> addCustomer(ArrayList<Customer> arraylistcustomer) {
        int accountNumber = (arraylistcustomer.size()+1);
                    System.out.println("Account number: " + accountNumber);
                    System.out.println("Name: ");
                    String name = input.nextLine();
                    System.out.println("SSN: ");
                    String ssn = input.nextLine();
                    System.out.println("Email: ");
                    String email = input.nextLine();
                    System.out.println("Address: ");
                    String address = input.nextLine();
                    System.out.println("Phonenumber: ");
                    String phone = input.nextLine();
                    Customer customer = new Customer(ssn, name, address, phone, email, accountNumber);
                    arraylistcustomer.add(customer);
        return arraylistcustomer;
    }

    public void viewCustomer(ArrayList<Customer> arraylistcustomer) {
        for (int i = 0; i < arraylistcustomer.size(); i++) {
            System.out.println("Account number: " + arraylistcustomer.get(i).getAccountNumber());
            System.out.println("Name: " + arraylistcustomer.get(i).getName());
            System.out.println("Social security number: " + arraylistcustomer.get(i).getSsn());
            System.out.println("Email: " + arraylistcustomer.get(i).getEmail());
            System.out.println("Address: " + arraylistcustomer.get(i).getAddress());
            System.out.println("Phone number: " + arraylistcustomer.get(i).getTelephoneNumber());
            System.out.println();
        }
    }

    public ArrayList<Customer> removeCustomer(ArrayList<Customer> arraylistcustomer, ArrayList<Booking> bookings) {
        System.out.println("Enter account number of person to remove: ");
        int accountNumber = Integer.parseInt(input.nextLine());
        for (int i = 0; i < arraylistcustomer.size(); i++) {
            if (bookings.get(i).getAccountNumber() == accountNumber) {
                System.out.println("Not possible to remove this customer since the cusomter already has booked a room..");
                arraylistcustomer = arraylistcustomer;
            } else if (arraylistcustomer.get(i).getAccountNumber() == accountNumber) {
                arraylistcustomer.remove(i);
            }
        }
        return arraylistcustomer;
    }

    //View room -abdifatah
    public void viewRoom(ArrayList<Room> hotelRooms) {
        for (int i = 0; i < hotelRooms.size(); i++) {
            System.out.println("HOTEL ROOM: " + hotelRooms.get(i).getRoomNumber());
            System.out.println("Amount of beds: " + hotelRooms.get(i).getNumberOfBeds());
            System.out.println("Price per night: " + hotelRooms.get(i).getPricePerNight());

            if (hotelRooms.get(i).isHasBalcony()) {
                System.out.println("Balcony: Yes");
            } else if (!hotelRooms.get(i).isHasBalcony()) {
                System.out.println("Balcony: No");
            }
            if (hotelRooms.get(i).isBooked()) {
                System.out.println("Already booked: Yes");
            } else if (!hotelRooms.get(i).isBooked()) {

                if (hotelRooms.get(i).isHasBalcony() == true) {
                    System.out.println("Balcony: Yes");
                } else if (hotelRooms.get(i).isHasBalcony() == false) {
                    System.out.println("Balcony: No");
                }
                if (hotelRooms.get(i).isBooked() == true) {
                    System.out.println("Already booked: Yes");
                } else if (hotelRooms.get(i).isBooked() == false) {

                    System.out.println("Already booked: No");
                }
                System.out.println("Floor: " + hotelRooms.get(i).getFloor());
                System.out.println();
            }
        }
    }


    public ArrayList<Room> addRoom(ArrayList<Room> hotelRooms) {
        System.out.println("How many would you like to add?");
        int userinout = input.nextInt();
        for (int i = 9; i < userinout + 9; i++) {
            System.out.println("How many beds does the room have? ");
            int amountOfBeds = input.nextInt();
            System.out.println("Does the room has a balcony? true/false ");
            Boolean balcony = input.nextBoolean();
            System.out.println("What is the price of the room? ");
            int pricePerNigth = input.nextInt();
            System.out.println("Which floor?");
            int floor = input.nextInt();
            Room room = new Room(i + 1, amountOfBeds, balcony, pricePerNigth, false, floor);
            hotelRooms.add(room);
        }
        return hotelRooms;
    }

    //metod för att boka rum till customer -Ludde
    public ArrayList<Booking> makeBooking(ArrayList<Booking> bookings, ArrayList<Customer> arrayListCustomer, ArrayList<Room> hotelRooms) {
        System.out.println("Which room would you like to book? ");
        int roomToBook = Integer.parseInt(input.nextLine())-1;
        System.out.println("Enter your account number: ");
        int accountNumber = Integer.parseInt(input.nextLine());
        System.out.println("Which date would you like to book? 'XXXX-XX-XX' ");
        String dateToBook = input.nextLine();

        for (int i = 0; i < arrayListCustomer.size(); i++) {
            if (accountNumber <= 0) {
                System.out.println("Error, please type in an account number greater than 0..");
            }
            else if (arrayListCustomer.get(i).getAccountNumber() == accountNumber && !hotelRooms.get(roomToBook).isBooked()){
                Booking booking = new Booking(roomToBook,dateToBook,accountNumber);
                bookings.add(booking);
                hotelRooms.get(roomToBook).setBooked(true);
            }
            else if(hotelRooms.get(roomToBook).isBooked()){

            } else if (arrayListCustomer.get(i).getAccountNumber() == accountNumber && hotelRooms.get(roomToBook - 1).isBooked() == false) {
                Booking booking = new Booking(roomToBook - 1, dateToBook, accountNumber);
                bookings.add(booking);
                hotelRooms.get(roomToBook - 1).setBooked(true);
            } else if (hotelRooms.get(roomToBook).isBooked() == true) {

                System.out.println("The room you wish to book is already taken..");
            } else if (arrayListCustomer.get(i).getAccountNumber() == 0) {
                System.out.println("No such account number in the system..");
            }
        }
        return bookings;
    }

    //metod för att kolla alla rum som är bokade-Ludde
    public void viewBookings(ArrayList<Booking> bookings) {
        for (int i = 0; i < bookings.size(); i++) {
            System.out.println("Hotel room: " + (bookings.get(i).getHotelRoomToBook() + 1));
            System.out.println("Booked by account: " + bookings.get(i).getAccountNumber());
            System.out.println("Booked during " + bookings.get(i).getDateToBook());
        }
    }




    public void viewInfoAboutCustomer(ArrayList<Customer>arrayListCustomer,ArrayList<Booking> bookings){
        System.out.println("Enter Account number you would like to see info about: ");
        int customerToSee = Integer.parseInt(input.nextLine());

        System.out.println("***Current Booking(s)***");
        for (int i= 0; i<bookings.size();i++){
            if (bookings.get(i).getAccountNumber()==customerToSee){
                System.out.println("Account number: " + bookings.get(i).getAccountNumber());
                System.out.println("Hotel room booked: " + bookings.get(i).getHotelRoomToBook());
                System.out.println("Booked during date: " + bookings.get(i).getDateToBook());
            }
        }
    }
}
