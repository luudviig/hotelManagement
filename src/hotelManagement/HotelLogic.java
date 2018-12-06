package hotelManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelLogic {
    private Scanner input = new Scanner(System.in);

    //Metod för att boka ett specifikt rum-Ludde
    public Room[] makeBooking(Room[] hotelRooms) {
        for (int i = 0; i < hotelRooms.length; i++) {
            if (hotelRooms[i].isBooked() == false) {
                System.out.println("Hotel room: " + hotelRooms[i].getRoomNumber());
                System.out.println("Amount of beds: " + hotelRooms[i].getNumberOfBeds());
                System.out.println("Price per night: " + hotelRooms[i].getPricePerNight());
                System.out.println("Balcony: " + hotelRooms[i].isHasBalcony());
                System.out.println("Booked: " + hotelRooms[i].isBooked());
                System.out.println("Floor: " + hotelRooms[i].getFloor());
                System.out.println();
            }

        }
        System.out.println("Which room would you like to book? ");
        int roomToBook = Integer.parseInt(input.nextLine());
        for (int i = 0; i < hotelRooms.length; i++) {
            if (hotelRooms[i].getRoomNumber() == roomToBook && hotelRooms[i].isBooked()==false) {
                hotelRooms[i].setBooked(true);
            }
            else if (hotelRooms[i].isBooked()==true){
                System.out.println("This room is already booked.. try again.");
            }
        }
        return hotelRooms;
    }

    public ArrayList<Customer> addCustomer(ArrayList<Customer> arraylistcustomer) {
        System.out.println("Name: ");
        String name = input.nextLine();
        System.out.println("SSN: ");
        String ssn = input.nextLine();
        System.out.println("Address: ");
        String address = input.nextLine();
        System.out.println("Email: ");
        String email = input.nextLine();
        System.out.println("Phonenumber: ");
        String phone = input.nextLine();

        Customer customer = new Customer(ssn, name, address, phone, email);
        arraylistcustomer.add(customer);



        return arraylistcustomer;
    }

    public void viewCustomer(ArrayList<Customer> arraylistcustomer) {
        for (int i = 0; i < arraylistcustomer.size(); i++) {
            System.out.println("Name: " + arraylistcustomer.get(i).getName());
            System.out.println("Email: " + arraylistcustomer.get(i).getEmail());
            System.out.println("Social security number: " + arraylistcustomer.get(i).getSsn());
            System.out.println("Phone number: " + arraylistcustomer.get(i).getTelephoneNumber());
            System.out.println("Address: " + arraylistcustomer.get(i).getAddress());
            System.out.println();
        }
    }

    public ArrayList<Customer> removeCustomer(ArrayList<Customer> arraylistcustomer) {
        System.out.println("Enter persons SSN: ");
        String ssn = input.nextLine();
        for (int i = 0; i < arraylistcustomer.size(); i++) {
            if (arraylistcustomer.get(i).getSsn().contains(ssn)) {
                arraylistcustomer.remove(i);
            }
        }
        return arraylistcustomer;
    }

    //View room -abdifatah
    public void viewRoom(ArrayList<Room> hotelRooms) {
        for (int i = 0; i < hotelRooms.size(); i++) {
            System.out.println("Hotel room: " + hotelRooms.get(i).getRoomNumber());
            System.out.println("Amount of beds: " + hotelRooms.get(i).getNumberOfBeds());
            System.out.println("Price per night: " + hotelRooms.get(i).getPricePerNight());
            System.out.println("Balcony: " + hotelRooms.get(i).isHasBalcony());
            System.out.println("Booked: " + hotelRooms.get(i).isBooked());
            System.out.println("Floor: " + hotelRooms.get(i).getFloor());
            System.out.println();
        }
    }
}



















// redigera info om rum - Kristian
public ArrayList<Room> editRoom(ArrayList<Room> hotelRooms) {
    System.out.println("Enter the room number you want to edit: ");
    int roomNumber = Integer.parseInt(input.nextLine());
    for (int i = 0; i < hotelRooms.size(); i++) {
        if (hotelRooms.get(i).getRoomNumber() == roomNumber) {
            PrintMenus.menuForEditRoomInfo();
            int answer = Integer.parseInt(input.nextLine());
            switch (answer) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Incorrect input, enter a number between 1-6");
                    break;
            }

        }

    }
}
