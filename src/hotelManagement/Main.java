package hotelManagement;

import java.lang.reflect.Array;
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


        do {
            PrintMenus.viewmenu();
            int choice = Integer.parseInt(getMethod.input.nextLine());

            switch (choice) {
                case 1:
                    getMethod.viewCustomer(arrayListCustomer);
                    break;
                case 2:
                    System.out.println("vänta på inlägg");
                    break;
                case 3:
                    System.out.println("vänta på inlägg");
                    break;
                case 4:
                    System.out.println("vänta på inlägg");
                    break;
                case 5:
                    System.out.println("vänta på inlägg");
                    break;
                case 6:
                    System.out.println("vänta på inlägg");
                    break;
                case 7:
                    arrayListCustomer = getMethod.listofcustomer(arrayListCustomer);
                    break;
                case 8:
                    arrayListCustomer = getMethod.removeCustomer(arrayListCustomer);
                    break;
                case 9:
                    System.out.println("vänta på inlägg");
                    break;
                case 10:
                    System.out.println("vänta på inlägg");
                    break;
                default:
                    System.out.println("Enter a number");
                    break;
            }
        } while (a);

    }

    private ArrayList<Customer> listofcustomer(ArrayList<Customer> arraylistcustomer){

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

        Customer customer = new Customer(ssn,name,address,phone,email);

        arraylistcustomer.add(customer);

        return arraylistcustomer;
    }

    private void viewCustomer(ArrayList<Customer> arraylistcustomer){
        for(int i=0; i< arraylistcustomer.size();i++){
            System.out.println("Name: " + arraylistcustomer.get(i).getName());
            System.out.println("Email: " + arraylistcustomer.get(i).getEmail());
            System.out.println("Social security number: " + arraylistcustomer.get(i).getSsn());
            System.out.println("Phone number: " + arraylistcustomer.get(i).getTelephoneNumber());
            System.out.println("Address: " + arraylistcustomer.get(i).getAddress());
            System.out.println();
        }
    }

    private ArrayList<Customer> removeCustomer(ArrayList<Customer> arraylistcustomer){
        System.out.println("Enter your SSN: ");
        String ssn = input.nextLine();
        for (int i = 0; i<arraylistcustomer.size(); i++){
            if (arraylistcustomer.get(i).getSsn().contains(ssn)){
                arraylistcustomer.remove(i);
            }
        }
        return arraylistcustomer;
    }
//    private Room[] makeBooking(Room room, Room[] hotelRooms,int roomToBook) {
//
//    }

}
