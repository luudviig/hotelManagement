package hotelManagement;


import java.util.Scanner;

public class ViewMenuAdmin {

    private Scanner input = new Scanner(System.in);

    public void viewmenu (){

        System.out.println("------Menu-----");
        System.out.println("[1] View customer");
        System.out.println("[2] View room information");
        System.out.println("[3] View available room");
        System.out.println("[4] Add room");
        System.out.println("[5] Edit room information");
        System.out.println("[6] Remove room");
        System.out.println("[7] Add customer");
        System.out.println("[8] Remove customer");
        System.out.println("[9] Search booking");
        System.out.println("[10] Exit");

        int choice = input.nextInt();

        switch (choice){
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
            case 6:
                System.out.println("vänta på inlägg");
                break;
            case 7:
                System.out.println("vänta på inlägg");
                break;
            case 8:
                System.out.println("vänta på inlägg");
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


    }



}
