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
                     System.out.println("Which number would you like the room to get? ");
                     int newRoomNumber = Integer.parseInt(input.nextLine());
                     for (int j = 0; j < hotelRooms.size(); j++) {
                         if (hotelRooms.get(j).getRoomNumber() == answer) {
                             hotelRooms.get(j).setRoomNumber(newRoomNumber);
                         }
                     }
                     break;
                 case 2:
                     System.out.println("How many beds are there in this room? ");
                     int newNumberOfBeds = Integer.parseInt(input.nextLine());
                     for (int b = 0; b < hotelRooms.size(); b++){
                         if (hotelRooms.get(b).getRoomNumber() == answer) {
                             hotelRooms.get(b).setNumberOfBeds(newNumberOfBeds);
                         }
                     }
                     break;
                 case 3:
                     System.out.println("Does the room have balcony? ");
                     boolean newHasBalcony = input.nextBoolean();
                     for (int B = 0; B < hotelRooms.size(); B++){
                         if (hotelRooms.get(B).getRoomNumber() == answer) {
                             hotelRooms.get(B).setHasBalcony(newHasBalcony);}}
                     break;
                 case 4:
                     System.out.println("What will the price per night be?");
                     int newPricePerNight = Integer.parseInt(input.nextLine());
                     for (int p = 0; p < hotelRooms.size() ; p++){
                         if (hotelRooms.get(p).getRoomNumber() == answer) {
                             hotelRooms.get(p).setPricePerNight(newPricePerNight);
                         }
                     }
                     break;
                 case 5:
                     System.out.println("Is the room booked or not? ");
                     boolean newIsBooked = input.nextBoolean();
                     for (int l = 0; l < hotelRooms.size(); l++){
                         if (hotelRooms.get(l).getRoomNumber() == answer) {
                             hotelRooms.get(l).setBooked(newIsBooked);
                         }
                     }
                     break;
                 case 6:
                     System.out.println("Which floor is the room located in? ");
                     int newFloor = Integer.parseInt(input.nextLine());
                     for (int n = 0; n < hotelRooms.size() ; n++){
                         if (hotelRooms.get(n).getRoomNumber() == answer) {
                             hotelRooms.get(n).setFloor(newFloor);
                         }
                     }
                     break;
                 default:
                     System.out.println("Incorrect input, enter a number between 1-6 ");
                     break;
             }

         }

     }
     return hotelRooms;
 }
 }
