package hotelManagement;

import java.util.Scanner;

public class ViewMenuCustom {

    private Scanner input = new Scanner(System.in);

    public void viewmenucustom(){

        System.out.println("------Menu-----");
        System.out.println("[1] View available room");
        System.out.println("[2] View booking history");
        System.out.println("[3] Make new booking");
        System.out.println("[4] Edit information");
        System.out.println("[5] Exit");

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("vänta på inlägg");
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
            default:
                System.out.println("Enter a number");
                break;
        }
    }
}
