package hotelManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    Scanner input = new Scanner(System.in);
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
                    a = false;
                    break;
                default:
                    System.out.println("Incorrect input, enter a number between 1-10");
                    break;
            }
        } while (a);

    }

}
