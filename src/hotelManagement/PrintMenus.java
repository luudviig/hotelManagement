package hotelManagement;

public class PrintMenus {
    public static void viewMenuCustom() {

        System.out.println("------Menu-----");
        System.out.println("[1] View available room");
        System.out.println("[2] View booking history");
        System.out.println("[3] Make new booking");
        System.out.println("[4] Edit information");
        System.out.println("[5] Exit");
    }

    public static void viewMenu() {
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
        System.out.println("[10] Add booking");
        System.out.println("[11] View booking");
        System.out.println("[12]" );
    }

    public static void viewMenuEmployeer(){
        System.out.println();
    }

    public static void menuForEditRoomInfo(){
        System.out.println("------Menu-----");
        System.out.println("[1] Edit room number");
        System.out.println("[2] Edit number of beds");
        System.out.println("[3] Edit balcony");
        System.out.println("[4] Edit price per night");
        System.out.println("[5] Edit is booked");
        System.out.println("[6] Edit floor number");

    }

}

