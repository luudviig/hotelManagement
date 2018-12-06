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
        //adds rooms for floor 1-Ludde
        for (int i = 0; i<3; i++){
            Room room = new Room((i+1),1,false,2000,false,1);
            hotelRooms.add(room);
        }
        //adds rooms for floor 2-Ludde
        for (int i = 3; i<6; i++){
            Room room = new Room((i+1),2,true,2500,false,2);
            hotelRooms.add(room);
        }
        //adds rooms for floor 3-Ludde
        for (int i = 6; i<9; i++){
            Room room = new Room((i+1),2,true,2700,false,3);
            hotelRooms.add(room);
        }


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
                    arrayListCustomer = hotelLogic.removeCustomer(arrayListCustomer);
                    break;
                case 9:
                    break;
                case 10:

                    System.out.println("Hopefully, you had a great time with as! Bye");
                    System.exit(0);

                    a = false;

                    break;
                default:
                    System.out.println("Incorrect input, enter a number between 1-10");
                    break;
            }
        } while (a);

    }


    private ArrayList<Customer> listofcustomer(ArrayList<Customer> arraylistcustomer) {

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
        System.out.println("Enter your SSN: ");
        String ssn = input.nextLine();
        for (int i = 0; i < arraylistcustomer.size(); i++) {
            if (arraylistcustomer.get(i).getSsn().contains(ssn)) {
                arraylistcustomer.remove(i);
                break;
            }
        }
        return arraylistcustomer;
    }
//    private Room[] makeBooking(Room room, Room[] hotelRooms,int roomToBook) {
//
//    }


    //View room -abdifatah
    private void viewRoom(Room[] hotelRooms) {
        for (int i = 0; i < hotelRooms.length; i++) {
            System.out.println("Room number: " + hotelRooms[i].getRoomNumber());
            System.out.println("Number of beds: " + hotelRooms[i].getNumberOfBeds());
            System.out.println("Price per night: " + hotelRooms[i].getPricePerNight());
            System.out.println("Booked: " + hotelRooms[i].isBooked());
            System.out.println("Balcony: " + hotelRooms[i].isHasBalcony());
            System.out.println();
        }
    }

}
