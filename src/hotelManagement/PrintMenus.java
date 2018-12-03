package hotelManagement;

import java.util.Scanner;

public class PrintMenus {

    private Scanner input = new Scanner(System.in);

    public static void viewmenucustom() {

        System.out.println("------Menu-----");
        System.out.println("[1] View available room");
        System.out.println("[2] View booking history");
        System.out.println("[3] Make new booking");
        System.out.println("[4] Edit information");
        System.out.println("[5] Exit");


    }

    public static void viewmenu() {

        System.out.println("------Menu-----");
        System.out.println("[1] View customer");
        System.out.println("[2] View rooms");
        System.out.println("[3] View available room");
        System.out.println("[4] Add room");
        System.out.println("[5] Edit room information");
        System.out.println("[6] Remove room");
        System.out.println("[7] Add customer");
        System.out.println("[8] Remove customer");
        System.out.println("[9] Search booking");
        System.out.println("[10] Exit");
    }

}

