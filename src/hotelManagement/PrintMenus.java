package hotelManagement;

public class PrintMenus {
    public static void printByeMessage(){
        System.out.println("Have a good day! ");
    }

    public static void printMenu() {
        System.out.println("----Login Menu----");
        System.out.println("[1] Employee ");
        System.out.println("[2] Customer ");
        System.out.println("[3] Exit program");
    }

    public static void viewMenuCustomer() {
        System.out.println("------Menu----");
        System.out.println("[1] View available room");
        System.out.println("[2] View booking history");
        System.out.println("[3] Make new booking");
        System.out.println("[4] Edit information");
        System.out.println("[5] Exit");
    }

    //Employeee menus!!-Ludde
    public static void viewMenuEmployeer1() {
        System.out.println("----Menu----");
        System.out.println("[1] View customer specifications");
        System.out.println("[2] View room specifications");
        System.out.println("[3] View booking specifications");
        System.out.println("[4] Exit");
    }

    public static void viewMenuEmployerOption1() {
        System.out.println("[1] View customers ");
        System.out.println("[2] Add customer ");
        System.out.println("[3] Remove customer");
        System.out.println("[4] Edit customer information");
        System.out.println("[5] View current bookings for specific customer");
        System.out.println("[6] View history of all bookings for a specific customer");
        System.out.println("[7] Back");
    }

    public static void menuForEditRoomInfo(){
        System.out.println("------Menu-----");
        System.out.println("[1] Edit room number");
        System.out.println("[2] Edit number of beds");
        System.out.println("[3] Edit price per night");
        System.out.println("[4] Edit balcony");
        System.out.println("[5] Edit is booked");
        System.out.println("[6] Edit floor number");

    }


    public static void viewMenuEmployerOption2() {
        System.out.println("[1] View rooms");
        System.out.println("[2] View available rooms");
        System.out.println("[3] Add room");
        System.out.println("[4] Remove room");
        System.out.println("[5] Edit room information");
        System.out.println("[6] Back");
    }

    public static void viewMenuEmployerOption3() {
        System.out.println("[1] View bookings");
        System.out.println("[2] Add booking");
        System.out.println("[3] Remove booking");
        System.out.println("[4] Search booking");
        System.out.println("[5] Edit booking information");
        System.out.println("[6] check in customer");
        System.out.println("[7] check out customer");
        System.out.println("[8] Back");
    }

}

