package hotelManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelLogic {
    private Scanner input = new Scanner(System.in);

    public void searchBooking(ArrayList<Booking> bookings) {
        System.out.println("What date would you like to see bookings? ");
        String dateToSearchFor = input.nextLine();

        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getDateToBook().equals(dateToSearchFor)) {
                System.out.println("Booking belongs to account: " + bookings.get(i).getAccountNumber());
                System.out.println("Booked during: " + bookings.get(i).getDateToBook());
                System.out.println("Room booked: " + bookings.get(i).getHotelRoomToBook());
            }
        }
    }

    public ArrayList<Customer> addOneCustomerToArrayList(ArrayList<Customer> arrayListCustomer) {
        for (int i = 0; i < 1; i++) {
            Customer customer = new Customer("1993-03-25-1234", "Josefin Johansson", "Stockholm", "0123456789",
                    "Josefin.katt@hotmail.com", 1, "Josefin", "Josefin");
            arrayListCustomer.add(customer);
        }
        return arrayListCustomer;
    }

    public ArrayList<Room> createArrayListOfRooms(ArrayList<Room> hotelRooms) {
        //adds rooms for floor 1-Ludde
        for (int i = 0; i < 3; i++) {
            Room room = new Room((i + 1), 1, false, 2000, false, 1);
            hotelRooms.add(room);
        }
        //adds rooms for floor 2-Ludde
        for (int i = 3; i < 6; i++) {
            Room room = new Room((i + 1), 2, true, 2500, false, 2);
            hotelRooms.add(room);
        }
        //adds rooms for floor 3-Ludde
        for (int i = 6; i < 9; i++) {
            Room room = new Room((i + 1), 2, true, 2700, false, 3);
            hotelRooms.add(room);
        }
        return hotelRooms;
    }

    public ArrayList<Customer> addCustomer(ArrayList<Customer> arraylistcustomer) {

        boolean a = true;
        boolean b = true;
        boolean c = true;
        boolean d = true;
        String ssn = "";
        String phone = "";
        int accountNumber = 0;

        if (arraylistcustomer.size() == 0) {
            accountNumber = 1;
        } else if (arraylistcustomer.size() > 0) {
            accountNumber = (arraylistcustomer.get(arraylistcustomer.size() - 1).getAccountNumber()) + 1;
        }
        do {


            System.out.println("Account number: " + accountNumber);
            System.out.print("Name: ");
            String name = input.nextLine();
            while (a) {
                System.out.print("SSN (yyyy-mm-dd-xxxx): ");
                ssn = input.nextLine();
                if (!ssn.matches("[0-9]+[0-9]+[0-9]+[0-9]+[-]+[0-9]+[0-9]+[-]+[0-9]+[0-9]+[-]+[0-9]+[0-9]+[0-9]+[0-9]")) {
                    System.out.println("SSN has to be in yyyy-mm-dd-xxxx format..");
                } else {
                    if (arraylistcustomer.size() > 0) {
                        for (int i = 0; i < arraylistcustomer.size(); i++) {
                            if (arraylistcustomer.get(i).getSsn().contains(ssn)) {
                                System.out.println("This ssn is already registered in the system");
                            } else {
                                a = false;
                            }
                        }
                    } else {
                        a = false;
                    }
                }
            }
            System.out.print("Email: ");
            String email = input.nextLine();
            System.out.print("Address: ");
            String address = input.nextLine();
            while (d) {
                System.out.print("Phonenumber: ");
                phone = input.nextLine();
                if (!phone.matches("[0]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]")) {
                    System.out.println("Phone number has to be 10 digits and start with a 0..");
                } else {
                    d = false;
                }
            }
            System.out.print("Create Username: ");
            String username = input.nextLine();
            while (b) {
                System.out.print("Create Password: ");
                String password = input.nextLine();
                System.out.print("Confirm Password: ");
                String confirmpass = input.nextLine();
                if (password.equals(confirmpass)) {
                    password = confirmpass;
                    Customer customer = new Customer(ssn, name, address, phone, email, accountNumber, username, password);
                    arraylistcustomer.add(customer);
                    b = false;
                } else {
                    System.out.println("Password does not exist");
                }
            }
            c = false;
        } while (c);
        return arraylistcustomer;
    }

    public void viewCustomer(ArrayList<Customer> arraylistcustomer) {
        for (int i = 0; i < arraylistcustomer.size(); i++) {
            System.out.println("Account number: " + arraylistcustomer.get(i).getAccountNumber());
            System.out.println("Name: " + arraylistcustomer.get(i).getName());
            System.out.println("Social security number: " + arraylistcustomer.get(i).getSsn());
            System.out.println("Email: " + arraylistcustomer.get(i).getEmail());
            System.out.println("Address: " + arraylistcustomer.get(i).getAddress());
            System.out.println("Phone number: " + arraylistcustomer.get(i).getTelephoneNumber());
            System.out.println();
        }
    }

    public ArrayList<Customer> removeCustomer(ArrayList<Customer> arraylistcustomer, ArrayList<Booking> bookings) {
        System.out.println("Enter account number of person to remove: ");
        int accountNumber = Integer.parseInt(input.nextLine());
        for (int i = 0; i < arraylistcustomer.size(); i++) {
            if (bookings.size() > 1 && bookings.get(i).getAccountNumber() == accountNumber) {
                System.out.println("Not possible to remove this customer since the cusomter already has booked a room..");
            } else if (arraylistcustomer.get(i).getAccountNumber() == accountNumber) {
                arraylistcustomer.remove(i);
            }
        }
        return arraylistcustomer;
    }

    //View room -abdifatah
    public void viewRoom(ArrayList<Room> hotelRooms) {
        for (int i = 0; i < hotelRooms.size(); i++) {
            System.out.println("HOTEL ROOM: " + hotelRooms.get(i).getRoomNumber());
            System.out.println("Amount of beds: " + hotelRooms.get(i).getNumberOfBeds());
            System.out.println("Price per night: " + hotelRooms.get(i).getPricePerNight());

            if (hotelRooms.get(i).isHasBalcony() == true) {
                System.out.println("Balcony: Yes");
            } else if (hotelRooms.get(i).isHasBalcony() == false) {
                System.out.println("Balcony: No");
            }
            if (hotelRooms.get(i).isBooked() == true) {
                System.out.println("Already booked: Yes");
            } else if (hotelRooms.get(i).isBooked() == false) {
                System.out.println("Already booked: No");
            }
            System.out.println("Floor: " + hotelRooms.get(i).getFloor());
            System.out.println();
        }
    }

    public ArrayList<Room> removeRoom(ArrayList<Room> hotelRooms) {
        System.out.println("Which room would you like to remove?");
        int roomnumber = input.nextInt();
        for (int i = 0; i < hotelRooms.size(); i++) {
            if (hotelRooms.get(i).equals(hotelRooms.get(roomnumber - 1))) {
                hotelRooms.remove(i);
            }
        }
        return hotelRooms;
    }

    public ArrayList<Room> addRoom(ArrayList<Room> hotelRooms) {
        System.out.println("How many would you like to add?");
        int userinout = Integer.parseInt(input.nextLine());
        for (int i = 0; i < userinout; i++) {
            System.out.println("How many beds does the room have? ");
            int amountOfBeds = Integer.parseInt(input.nextLine());
            System.out.println("Does the room has a balcony? yes/no ");
            String balconyinput = input.nextLine();
            boolean balcony = false;
            if (balconyinput.equals("yes")) {
                balcony = true;

            } else if (balconyinput.equals("no")) {
                balcony = false;
            }
            System.out.println("What is the price of the room? ");
            int pricePerNight = Integer.parseInt(input.nextLine());
            System.out.println("Which floor?");
            int floor = Integer.parseInt(input.nextLine());
            Room room = new Room(hotelRooms.size() + 1, amountOfBeds, balcony, pricePerNight, false, floor);
            hotelRooms.add(room);
        }
        return hotelRooms;
    }

    //metod för att boka rum till customer -Ludde
    public ArrayList<Booking> makeBooking(ArrayList<Booking> bookings, ArrayList<Customer> arrayListCustomer, ArrayList<Room> hotelRooms) {

        boolean a = true;
        boolean b = true;
        boolean c = true;
        boolean d = true;
        do {
            int roomToBook;
            int accountNumber;
            String dateToBook;
            do {
                System.out.println("Which room would you like to book? ");
                roomToBook = Integer.parseInt(input.nextLine()) - 1;
                if (roomToBook >= hotelRooms.size()) {
                    System.out.println("Input has to be greater than 0, not booked and existing in system..");
                } else if (roomToBook >= 1 && roomToBook <= hotelRooms.size() - 1) {
                    if (roomToBook <= 0 || hotelRooms.get(roomToBook).isBooked()) {
                        System.out.println("Input has to be greater than 0, not booked and existing in system..");
                    } else if (roomToBook >= 1 && roomToBook <= hotelRooms.size() + 1 && !hotelRooms.get(roomToBook).isBooked()) {
                        a = false;
                    }
                }

            } while (a);
            do {
                System.out.println("Enter your account number: ");
                accountNumber = Integer.parseInt(input.nextLine());
                if (accountNumber <= 0) {
                    System.out.println("please type in an account number greater than 0, and existing in system..");
                } else if (accountNumber > arrayListCustomer.size()) {
                    System.out.println("Account number does not exist..");
                } else {
                    b = false;
                }
            } while (b);
            do {
                System.out.println("Which date would you like to book? 'yyyy-mm-dd' ");
                dateToBook = input.nextLine();
                if (dateToBook.length() != 10) {
                    System.out.println("Please type in foramt yyyy-mm-dd");
                } else {
                    c = false;
                }

                Booking booking = new Booking(roomToBook, dateToBook, accountNumber);
                bookings.add(booking);
            } while (c);
            d = false;
        } while (d);

        return bookings;
    }

    //metod för att kolla alla rum som är bokade
    public void viewBookings (ArrayList < Booking > bookings) {
        for (int i = 0; i < bookings.size(); i++) {
            System.out.println("Hotel room: " + (bookings.get(i).getHotelRoomToBook() + 1));
            System.out.println("Booked by account: " + bookings.get(i).getAccountNumber());
            System.out.println("Booked during " + bookings.get(i).getDateToBook());
        }
    }

    public void viewInfoAboutCustomer (ArrayList < Customer > arrayListCustomer, ArrayList < Booking > bookings){
        System.out.println("Enter Account number you would like to see info about: ");
        int customerToSee = Integer.parseInt(input.nextLine());
        System.out.println("***Current Booking(s)***");
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getAccountNumber() == customerToSee) {
                System.out.println("Account number: " + bookings.get(i).getAccountNumber());
                System.out.println("Hotel room booked: " + bookings.get(i).getHotelRoomToBook());
                System.out.println("Booked during date: " + bookings.get(i).getDateToBook());
            }
        }
        System.out.println("...Previous Booking...");
        int prevBooking;
        for (int i = 0; i < bookings.size(); i++) {
            prevBooking = bookings.size();
            System.out.println(prevBooking);
        }
    }

    // redigera info om rum - Kristian
    public ArrayList<Room> editRoom(ArrayList<Room> hotelRooms) {
        boolean a = true;
        int roomNumber;
        boolean found = false;
        do {
            System.out.print("Enter the room number you want to edit: ");
            roomNumber = Integer.parseInt(input.nextLine());
            for (int j = 0; j < hotelRooms.size(); j++) {
                if (hotelRooms.get(j).getRoomNumber() == roomNumber) {
                    found = true;
                }
            }
            if (found) {
                PrintMenus.menuForEditRoomInfo();
                a = false;

            } else {
                System.out.println("Room doesn't exist");
            }
        }while (a);
            int answer = Integer.parseInt(input.nextLine());
            switch (answer) {
                case 1:
                    System.out.println("Which number would you like the room to get? ");
                    int newRoomNumber = Integer.parseInt(input.nextLine());
                    for (int i = 0; i < hotelRooms.size(); i++) {
                        if (hotelRooms.get(i).getRoomNumber() == roomNumber) {
                            hotelRooms.get(i).setRoomNumber(newRoomNumber);
                        }
                    }
                    break;
                case 2:
                    System.out.println("How many beds are there in this room? ");
                    int newNumberOfBeds = Integer.parseInt(input.nextLine());
                    for (int i = 0; i < hotelRooms.size(); i++) {
                        if (hotelRooms.get(i).getRoomNumber() == roomNumber) {
                            hotelRooms.get(i).setNumberOfBeds(newNumberOfBeds);
                        }
                    }
                    break;
                case 3:
                    System.out.println("What will the price per night be?");
                    int newPricePerNight = Integer.parseInt(input.nextLine());
                    for (int i = 0; i < hotelRooms.size(); i++) {
                        if (hotelRooms.get(i).getRoomNumber() == roomNumber) {
                            hotelRooms.get(i).setPricePerNight(newPricePerNight);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Does the room have a balcony?(yes/no) ");
                    String balconychoice = input.nextLine();
                    boolean newHasBalcony = false;
                    if (balconychoice.equals("yes")) {
                        newHasBalcony = true;

                    } else if (balconychoice.equals("no")) {
                        newHasBalcony = false;
                    }
                    for (int i = 0; i < hotelRooms.size(); i++) {
                        if (hotelRooms.get(i).getRoomNumber() == roomNumber) {
                            hotelRooms.get(i).setHasBalcony(newHasBalcony);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Is the room booked or not?(yes/no)");
                    String bookedchoice = input.nextLine();
                    boolean newIsBooked = false;
                    if (bookedchoice.equals("yes")) {
                        newIsBooked = true;

                    } else if (bookedchoice.equals("no")) {
                        newIsBooked = false;
                    }
                    for (int i = 0; i < hotelRooms.size(); i++) {
                        if (hotelRooms.get(i).getRoomNumber() == roomNumber) {
                            hotelRooms.get(i).setBooked(newIsBooked);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Which floor is the room located in? ");
                    int newFloor = Integer.parseInt(input.nextLine());
                    for (int i = 0; i < hotelRooms.size(); i++) {
                        if (hotelRooms.get(i).getRoomNumber() == roomNumber) {
                            hotelRooms.get(i).setFloor(newFloor);
                        }
                    }
                    break;
                default:
                    System.out.println("Incorrect input, enter a number between 1-6 ");
                    break;
        }
        return hotelRooms;
    }

    //metod för att ändra information om customer
    public ArrayList<Customer> editCustomInfo(ArrayList<Customer> customerArrayList) {
        System.out.print("Which of the following information would you like to change? \n" +
                "1) name \n" +
                "2) address \n" +
                "3) phonenumber \n" +
                "4) email \n" +
                "5) username \n" +
                "6) password \n");
        int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    for (int i = 0; i < customerArrayList.size(); i++) {
                        System.out.println("Current name: " + customerArrayList.get(i).getName());
                        System.out.print("New name: ");
                        String newname = input.nextLine();
                        customerArrayList.get(i).setName(newname);
                    }
                    break;
                case 2:
                    for (int i = 0; i < customerArrayList.size(); i++) {
                        System.out.println("Current address: " + customerArrayList.get(i).getAddress());
                        System.out.print("New address: ");
                        String newaddress = input.nextLine();
                        customerArrayList.get(i).setName(newaddress);
                    }
                    break;
                case 3:
                    for (int i = 0; i < customerArrayList.size(); i++) {
                        System.out.println("Current phonenumber: " + customerArrayList.get(i).getTelephoneNumber());
                        System.out.print("New phonenumber: ");
                        String newphonenumber = input.nextLine();
                        customerArrayList.get(i).setName(newphonenumber);
                    }
                    break;
                case 4:
                    for (int i = 0; i < customerArrayList.size(); i++) {
                        System.out.println("Current email: " + customerArrayList.get(i).getEmail());
                        System.out.print("New email: ");
                        String newemail = input.nextLine();
                        customerArrayList.get(i).setName(newemail);
                    }
                    break;
                case 5:
                    for (int i = 0; i < customerArrayList.size(); i++) {
                        System.out.println("Current username: " + customerArrayList.get(i).getUsername());
                        System.out.print("New username: ");
                        String newusername = input.nextLine();
                        System.out.println("Confirm new username: ");
                        String confirmnewusername = input.nextLine();
                        if (newusername.equals(confirmnewusername)) {
                            customerArrayList.get(i).setName(newusername);
                        } else {
                            System.out.println("Username doesn't match!");
                        }
                    }
                    break;
                case 6:
                    for (int i = 0; i < customerArrayList.size(); i++) {
                        System.out.println("Current password: " + customerArrayList.get(i).getPassword());
                        System.out.println("New password: ");
                        String newpassword = input.nextLine();
                        System.out.println("Confirm new password: ");
                        String confirmnewpassword = input.nextLine();
                        if (newpassword.equals(confirmnewpassword)) {
                            customerArrayList.get(i).setName(newpassword);
                        } else {
                            System.out.println("Username doesn't match!");
                        }
                        customerArrayList.get(i).setName(newpassword);
                    }
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        return customerArrayList;
    }


    //metod för att kolla alla tillgängliga rum
    public void availableRooms(ArrayList<Room> hotelrooms) {
        System.out.println("All the available rooms: ");
        for (int i = 0; i < hotelrooms.size(); i++) {
            if (hotelrooms.get(i).isBooked() == false) {
                System.out.println("Room: " + hotelrooms.get(i).getRoomNumber());
            }
        }
    }



    public void checkIn(ArrayList<Booking> bookings) {
        int accountNumber;

        System.out.println("Enter your account number!");
        accountNumber = input.nextInt();
        if (accountNumber >= 0) {
            for (int j = 0; j < bookings.size(); j++) {
                if (bookings.get(j).getAccountNumber() == accountNumber) {
                    System.out.println("You are successfully checked-in this date: " + bookings.get(j).getDateToBook());
                }
            }
        }
    }

    public void checkOut(ArrayList<Booking> bookings) {
        int accountNumber;
        System.out.println("Enter your account number!");
        accountNumber = input.nextInt();

        if (accountNumber >= 0) {
            for (int i = 0; i < bookings.size(); i++) {
                if (bookings.get(i).getAccountNumber() == accountNumber) {
                    System.out.println("You are successfully checked-out: " + bookings.remove(i).getDateToBook());

                }
            }
        }
    }
}

