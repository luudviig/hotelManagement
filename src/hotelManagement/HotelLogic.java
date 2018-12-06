package hotelManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelLogic {
    private Scanner input = new Scanner(System.in);


    public ArrayList<Customer> addCustomer(ArrayList<Customer> arraylistcustomer) {

            System.out.println("Enter account number: ");
            int accountNumber = Integer.parseInt(input.nextLine());
            for (int i=0; i<arraylistcustomer.size();i++) {
                if (arraylistcustomer.get(i).getAccountNumber()==accountNumber){
                    System.out.println("This account number is already taken.. ");
                }
                else if (arraylistcustomer.get(i).getAccountNumber()!=accountNumber){
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
                }
            }
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
            if (bookings.get(i).getAccountNumber() == accountNumber){
                System.out.println("Not possible to remove this customer since the cusomter already has booked a room..");
                arraylistcustomer=arraylistcustomer;
            }
            else if (arraylistcustomer.get(i).getAccountNumber() == accountNumber) {
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
            System.out.println("Balcony: " + hotelRooms.get(i).isHasBalcony());
            System.out.println("Booked: " + hotelRooms.get(i).isBooked());
            System.out.println("Floor: " + hotelRooms.get(i).getFloor());
            System.out.println();
        }
    }













































































































    //metod för att boka rum till customer -Ludde
    public ArrayList<Booking> makeBooking(ArrayList<Booking> bookings,ArrayList<Customer> arrayListCustomer, ArrayList<Room> hotelRooms){
        System.out.println("Which room would you like to book? ");
        int roomToBook = Integer.parseInt(input.nextLine());
        System.out.println("Enter your account number: ");
        int accountNumber = Integer.parseInt(input.nextLine());
        System.out.println("Which date would you like to book? 'XXXX-XX-XX' ");
        String dateToBook = input.nextLine();

        for (int i= 0; i<arrayListCustomer.size();i++){
            if (accountNumber<=0){
                System.out.println("Error, please type in an account number greater than 0..");
            }
            else if (arrayListCustomer.get(i).getAccountNumber() == accountNumber && hotelRooms.get(roomToBook-1).isBooked() ==false){
                Booking booking = new Booking(roomToBook-1,dateToBook,accountNumber);
                bookings.add(booking);
                hotelRooms.get(roomToBook-1).setBooked(true);
            }
            else if(hotelRooms.get(roomToBook-1).isBooked()==true){
                System.out.println("The room you wish to book is already taken..");
            }
            else if(arrayListCustomer.get(i).getAccountNumber()==0){
                System.out.println("No such account number in the system..");
            }
        }
        return bookings;
    }

    //metod för att kolla alla rum som är bokade
    public void viewBookings(ArrayList<Booking> bookings){
        for (int i = 0; i<bookings.size(); i++){
            System.out.println("Hotel room: " + (bookings.get(i).getHotelRoomToBook()+1));
            System.out.println("Booked by account: " + bookings.get(i).getAccountNumber());
            System.out.println("Booked during " + bookings.get(i).getDateToBook());
        }
    }
}
