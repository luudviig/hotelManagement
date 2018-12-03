package hotelManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Main getMethod = new Main();

        //plats för variabler
        boolean a = true;
        ArrayList<Customer> arrayListCustomer = new ArrayList<>();

        //Detta är en array som består av flera obejkt(Room)-Ludde
        Room[] hotelRooms = new Room[100];

        //Skapar en loop som lägger till objekt(Room), första våningen-Ludde
        for (int i = 0; i < 25; i++) {
            Room room1 = new Room(i + 1, 2, false, 2000, false, 1);
            hotelRooms[i] = room1;
        }
        //Skapar en loop som lägger till objekt(Room), andra våningen-Ludde
        for (int i = 25; i < 50; i++) {
            Room room2 = new Room(i + 1, 2, true, 2500, false, 2);
            hotelRooms[i] = room2;
        }
        //Skapar en loop som lägger till objekt(Room), tredje våningen-Ludde
        for (int i = 49; i < 100; i++) {
            Room room3 = new Room(i + 1, 2, true, 3000, false, 3);
            hotelRooms[i] = room3;
        }

        //skapar en loop som loopar tills man "exitar"-Ludde
        do {
            PrintMenus.viewmenu();
            int choice = Integer.parseInt(getMethod.input.nextLine());
            switch (choice) {
                case 1:
                    getMethod.viewCustomer(arrayListCustomer);
                    break;
                case 2:
                    getMethod.viewRoom(hotelRooms);
                    break;
                case 3:
                    break;
                case 4:
                    hotelRooms = getMethod.makeBooking(hotelRooms);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    arrayListCustomer = getMethod.listOfCustomer(arrayListCustomer);
                    break;
                case 8:
                    arrayListCustomer = getMethod.removeCustomer(arrayListCustomer);
                    break;
                case 9:
                    break;
                case 10:
                    a = false;
                    break;
                default:
                    System.out.println("Incorrect input, enter a number between 1-10");
                    break;
            }
        } while (a);

    }
    //Metod för att boka ett specifikt rum-Ludde
    private Room[] makeBooking(Room[] hotelRooms) {
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

    private ArrayList<Customer> listOfCustomer(ArrayList<Customer> arraylistcustomer) {
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

    private void viewCustomer(ArrayList<Customer> arraylistcustomer) {
        for (int i = 0; i < arraylistcustomer.size(); i++) {
            System.out.println("Name: " + arraylistcustomer.get(i).getName());
            System.out.println("Email: " + arraylistcustomer.get(i).getEmail());
            System.out.println("Social security number: " + arraylistcustomer.get(i).getSsn());
            System.out.println("Phone number: " + arraylistcustomer.get(i).getTelephoneNumber());
            System.out.println("Address: " + arraylistcustomer.get(i).getAddress());
            System.out.println();
        }
    }

    private ArrayList<Customer> removeCustomer(ArrayList<Customer> arraylistcustomer) {
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
    private void viewRoom(Room[] hotelRooms) {
        for (int i = 0; i < hotelRooms.length; i++) {
            System.out.println("Hotel room: " + hotelRooms[i].getRoomNumber());
            System.out.println("Amount of beds: " + hotelRooms[i].getNumberOfBeds());
            System.out.println("Price per night: " + hotelRooms[i].getPricePerNight());
            System.out.println("Balcony: " + hotelRooms[i].isHasBalcony());
            System.out.println("Booked: " + hotelRooms[i].isBooked());
            System.out.println("Floor: " + hotelRooms[i].getFloor());
            System.out.println();
        }
    }
}
