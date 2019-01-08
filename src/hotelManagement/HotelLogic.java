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
                System.out.println("Room booked: " + (bookings.get(i).getHotelRoomToBook()+ 1));
                if (bookings.get(i).isCheckedIn()==true){
                    System.out.println("Checked in: yes");
                }
                else if(bookings.get(i).isCheckedIn()==false){
                    System.out.println("Checked in: no");
                }
                System.out.println();
            }
        }
    }

    public ArrayList<Customer> addOneCustomerToArrayList(ArrayList<Customer> arrayListCustomer) {
        for (int i = 0; i < 1; i++) {
            Customer customer = new Customer("1993-03-25-1234", "Josefin Johansson", "Stockholm", "0123456789",
                    "Josefin.katt@hotmail.com", 1);
            arrayListCustomer.add(customer);
        }
        return arrayListCustomer;
    }

    public ArrayList<Room> createArrayListOfRooms(ArrayList<Room> hotelRooms) {
        //adds rooms for floor 1-Ludde
        for (int i = 0; i < 3; i++) {
            Room room = new Room((i + 1), 1, false, 2000, "", 1);
            hotelRooms.add(room);
        }
        //adds rooms for floor 2-Ludde
        for (int i = 3; i < 6; i++) {
            Room room = new Room((i + 1), 2, true, 2500, "", 2);
            hotelRooms.add(room);
        }
        //adds rooms for floor 3-Ludde
        for (int i = 6; i < 9; i++) {
            Room room = new Room((i + 1), 2, true, 2700, "", 3);
            hotelRooms.add(room);
        }
        return hotelRooms;
    }

    public ArrayList<Customer> addCustomer(ArrayList<Customer> arraylistcustomer) {

        boolean a = true;
        boolean b = true;
        boolean c = true;
        boolean d = true;
        boolean e = true;
        String ssn = "";
        String phone = "";

        int accountNumber = createAccountnumber(arraylistcustomer);
        do {
            System.out.println("Account number: " + accountNumber);
            System.out.print("Name: ");
            String name = input.nextLine();
            while (a) {
                System.out.print("SSN (yyyy-mm-dd-xxxx): ");
                ssn = input.nextLine();
                if (!ssn.matches("[0-9]+[0-9]+[0-9]+[0-9]+[-]+[0-9]+[0-9]+[-]+[0-9]+[0-9]+[-]+[0-9]+[0-9]+[0-9]+[0-9]")) {
                    System.out.println("SSN has to be in yyyy-mm-dd-xxxx format..");
                }
                else if (ssn.matches("[0-9]+[0-9]+[0-9]+[0-9]+[-]+[0-9]+[0-9]+[-]+[0-9]+[0-9]+[-]+[0-9]+[0-9]+[0-9]+[0-9]")){
                    if (arraylistcustomer.size()==0){
                        a = false;
                    }
                    else if (arraylistcustomer.size() > 0) {
                        do {
                            for (int i = 0; i < arraylistcustomer.size(); i++) {
                                e = true;
                                if (arraylistcustomer.get(i).getSsn().contains(ssn)) {
                                    System.out.println("This ssn is already existing");
                                    e = false;
                                    break;
                                } else {
                                    a = false;
                                    e = false;
                                    break;

                                }
                            }

                        } while (e);
                    }
                }
            }
            System.out.print("Email: ");
            String email = input.nextLine();
            System.out.print("Address: ");
            String address = input.nextLine();
            while (d) {
                System.out.print("Phone number: ");
                phone = input.nextLine();
                if (!phone.matches("[0]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]")) {
                    System.out.println("Phone number has to be 10 digits and start with a 0..");
                } else {
                    d = false;
                }
            }
                    Customer customer = new Customer(ssn, name, address, phone, email, accountNumber);
                    arraylistcustomer.add(customer);

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
                System.out.println("Not possible to remove this customer since the customer already has booked a room..");
                break;
            } else if (arraylistcustomer.get(i).getAccountNumber() == accountNumber) {
                Customer customer = arraylistcustomer.get(i);
                arraylistcustomer.remove(customer);
            }
        }
        return arraylistcustomer;
    }

    //View room -abdifatah
    public void viewRoom(ArrayList<Room> hotelRooms, ArrayList<Booking> bookings) {
        for (int i = 0; i < hotelRooms.size(); i++) {
            System.out.println("HOTEL ROOM: " + hotelRooms.get(i).getRoomNumber());
            System.out.println("Amount of beds: " + hotelRooms.get(i).getNumberOfBeds());
            System.out.println("Price per night: " + hotelRooms.get(i).getPricePerNight());

            if (hotelRooms.get(i).isHasBalcony() == true) {
                System.out.println("Balcony: Yes");
            } else if (hotelRooms.get(i).isHasBalcony() == false) {
                System.out.println("Balcony: No");
            }
            if (hotelRooms.get(i).getIsBooked().length() >= 1) {
                System.out.print("Booked during date(s): ");
                for (int j = 0; j < bookings.size(); j++) {
                    System.out.print(hotelRooms.get(i).getIsBooked());
                    break;
                }
                System.out.println();
            } else if (hotelRooms.get(i).getIsBooked().length() < 1) {
                System.out.println("Booked during date(s): ");

            }
            System.out.println("Floor: " + hotelRooms.get(i).getFloor());
            System.out.println();
        }
    }

    public ArrayList<Room> removeRoom(ArrayList<Room> hotelRooms,ArrayList<Booking> bookings) {
        viewRoom(hotelRooms,bookings);

        System.out.println("Which room would you like to remove?");
        int roomnumber = (Integer.parseInt(input.nextLine())-1);
        for (int i = 0; i < hotelRooms.size(); i++) {
            if (hotelRooms.get(i).equals(hotelRooms.get(roomnumber)) && hotelRooms.get(i).getIsBooked().length() == 0) {
                hotelRooms.remove(roomnumber);
            }
        }
        for (int i = 0; i < hotelRooms.size(); i++) {
            if (hotelRooms.get(i).equals(hotelRooms.get(roomnumber)) && hotelRooms.get(i).getIsBooked().length() > 0) {
                System.out.println("The room is currently booked by a customer");
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
            Room room = new Room((hotelRooms.size() + 1), amountOfBeds, balcony, pricePerNight, "", floor);
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
                System.out.println("Enter your account number: ");
                accountNumber = Integer.parseInt(input.nextLine());
                if (accountNumber <= 0) {
                    System.out.println("please type in an account number greater than 0, and existing in system..");
                } else if (accountNumber > arrayListCustomer.size()) {
                    System.out.println("Account number does not exist..");
                }
                for (int i = 0; i < arrayListCustomer.size(); i++) {
                    if ((accountNumber > 0 && accountNumber <= arrayListCustomer.size() && arrayListCustomer.get(i).getAccountNumber() == accountNumber)) {
                        b = false;
                    }
                }
            } while (b);
            do {
                System.out.println("Which date would you like to book? 'yyyy-mm-dd' ");
                dateToBook = input.nextLine();
                if (!dateToBook.matches("[0-9]+[0-9]+[0-9]+[0-9]+[-]+[0-9]+[0-9]+[-]+[0-9]+[0-9]")) {
                    System.out.println("Please type in format yyyy-mm-dd");
                } else {
                    c = false;
                }
            } while (c);
            do {
                viewRoom(hotelRooms, bookings);
                System.out.println("Which room would you like to book? ");
                roomToBook = (Integer.parseInt(input.nextLine()) - 1);
                if (roomToBook >= hotelRooms.size() || roomToBook < 0) {
                    System.out.println("Input has to be greater than 0, not booked that date and existing in system..");
                } else if (roomToBook >= 0 && roomToBook <= hotelRooms.size() - 1) {
                    if (!hotelRooms.get(roomToBook).getIsBooked().contains(dateToBook)) {
                        hotelRooms.get(roomToBook).setDateBooking(dateToBook);
                        a = false;
                    } else if (hotelRooms.get(roomToBook).getIsBooked().contains(dateToBook)) {
                        System.out.println("This room is already booked this date..");
                    }
                }
            } while (a);

            Booking booking = new Booking(roomToBook, dateToBook, accountNumber,false);
            bookings.add(booking);

            d = false;
        } while (d);

        return bookings;
    }

    public void viewInfoAboutCustomer(ArrayList<Customer> arrayListCustomer, ArrayList<Booking> bookings, ArrayList<Booking> previousBookings) {
        System.out.println("Enter Account number you would like to see info about: ");
        int accountNumber = Integer.parseInt(input.nextLine());
        System.out.println("Customer information");
        for (int i = 0; i<arrayListCustomer.size();i++){
            if (arrayListCustomer.get(i).getAccountNumber()==accountNumber) {
                System.out.println("Account number: " + arrayListCustomer.get(i).getAccountNumber());
                System.out.println("Name: " + arrayListCustomer.get(i).getName());
                System.out.println("SSN: " + arrayListCustomer.get(i).getSsn());
                System.out.println("Address: " + arrayListCustomer.get(i).getAddress());
                System.out.println("Phone number: " + arrayListCustomer.get(i).getTelephoneNumber());
                System.out.println("Email: " + arrayListCustomer.get(i).getEmail());

            }
        }
        System.out.println();
        System.out.println("CURRENT BOOKING(S)");
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getAccountNumber() == accountNumber) {
                System.out.println("Account number: " + bookings.get(i).getAccountNumber());
                System.out.println("Hotel room booked: " + bookings.get(i).getHotelRoomToBook());
                System.out.println("Booked during date: " + bookings.get(i).getDateToBook());
                if (bookings.get(i).isCheckedIn()==true){
                    System.out.println("Checked in: yes");
                }
                else if(bookings.get(i).isCheckedIn()==false){
                    System.out.println("Checked in: no");
                }
            }
        }
        System.out.println();
        System.out.println("PREVIOUS BOOKING(S)");
        for (int i = 0; i<previousBookings.size();i++){
            if (previousBookings.get(i).getAccountNumber() == accountNumber) {
                System.out.println("Account number: " + previousBookings.get(i).getAccountNumber());
                System.out.println("Room that was booked: " + previousBookings.get(i).getHotelRoomToBook());
                System.out.println("Was booked the date: " + previousBookings.get(i).getDateToBook());
            }
        }
        System.out.println();
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
        } while (a);
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
                System.out.println("Which floor is the room located in? ");
                int newFloor = Integer.parseInt(input.nextLine());
                for (int i = 0; i < hotelRooms.size(); i++) {
                    if (hotelRooms.get(i).getRoomNumber() == roomNumber) {
                        hotelRooms.get(i).setFloor(newFloor);
                    }
                }
                break;
            default:
                System.out.println("Incorrect input, enter a number between 1-5 ");
                break;
        }
        return hotelRooms;
    }

    //metod för att ändra information om customer
    public ArrayList<Customer> editCustomInfo(ArrayList<Customer> customerArrayList) {
        boolean a = true;
        int accountinput;
        do {
            System.out.print("Enter account number: ");
            accountinput = Integer.parseInt(input.nextLine());
            for (int j=0;j < customerArrayList.size();j++) {
                if (customerArrayList.get(j).getAccountNumber() == accountinput) {
                    System.out.print("Which of the following information would you like to change? \n" +
                            "1) name \n" +
                            "2) address \n" +
                            "3) phonenumber \n" +
                            "4) email \n");
                    a = false;
                }
            }
        }while (a);
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    for (int i = 0; i < customerArrayList.size(); i++) {
                        if (customerArrayList.get(i).getAccountNumber() == accountinput) {
                            System.out.println("Current name: " + customerArrayList.get(i).getName());
                            System.out.print("New name: ");
                            String newname = input.nextLine();
                            customerArrayList.get(i).setName(newname);
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < customerArrayList.size(); i++) {
                        if (customerArrayList.get(i).getAccountNumber() == accountinput) {
                            System.out.println("Current address: " + customerArrayList.get(i).getAddress());
                            System.out.print("New address: ");
                            String newaddress = input.nextLine();
                            customerArrayList.get(i).setAddress(newaddress);
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < customerArrayList.size(); i++) {
                        if (customerArrayList.get(i).getAccountNumber() == accountinput) {
                            System.out.println("Current phonenumber: " + customerArrayList.get(i).getTelephoneNumber());
                            System.out.print("New phonenumber: ");
                            String newphonenumber = input.nextLine();
                            customerArrayList.get(i).setTelephoneNumber(newphonenumber);
                        }
                    }
                    break;
                case 4:
                    for (int i = 0; i < customerArrayList.size(); i++) {
                        if (customerArrayList.get(i).getAccountNumber() == accountinput) {
                            System.out.println("Current email: " + customerArrayList.get(i).getEmail());
                            System.out.print("New email: ");
                            String newemail = input.nextLine();
                            customerArrayList.get(i).setEmail(newemail);
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        return customerArrayList;
    }

    public ArrayList<Booking> editBookingInfo(ArrayList<Booking> bookingArrayList,ArrayList<Room> hotelRooms) {
        boolean a = true;
        int accountinput = 0;
        String bookingindex = "";
        String newdate;
        String counterj = "";
        while (a) {
            System.out.print("Enter account number: ");
            accountinput = Integer.parseInt(input.nextLine());
            for (int j = 0; j < bookingArrayList.size(); j++) {
                if (bookingArrayList.get(j).getAccountNumber() == accountinput) {
                    System.out.println("---Current bookings---");
                    for (int k = 0; k < bookingArrayList.size(); k++) {
                        if (bookingArrayList.get(k).getAccountNumber() == accountinput) {
                            System.out.println((k + 1) + ") " + "Date: " + bookingArrayList.get(k).getDateToBook() + " Room: " + (bookingArrayList.get(k).getHotelRoomToBook() + 1));
                            counterj += k;
                        }
                    }
                    a = false;
                }
                else {
                    System.out.println("This account doesn't exist");
                }
                break;
            }
        }
        System.out.println("Which booking would you like to change?");
        bookingindex = input.nextLine();
                if(counterj.contains(bookingindex)){
                    for (int m = 0; m < bookingArrayList.size(); m++) {
                        if (bookingArrayList.get(m).getAccountNumber() == accountinput) {
                            System.out.print("Which of the following information would you like to change? \n" +
                                    "1) room \n" +
                                    "2) date \n");
                            break;
                        }
                    }
                }
        int choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 1:
                boolean h = true;
                do {
                    for (int i = 0; i < bookingArrayList.size(); i++) {
                        if (bookingArrayList.get(i).getAccountNumber() == accountinput) {
                            System.out.print("New room: ");
                            int newroom = (Integer.parseInt(input.nextLine())-1);
                            if (bookingArrayList.get(i).getDateToBook().contains(hotelRooms.get(i).getIsBooked())) {
                                System.out.println("This room is already booked");
                            }
                            else if(!bookingArrayList.get(i).getDateToBook().contains(hotelRooms.get(i).getIsBooked()) && hotelRooms.contains(hotelRooms.get(newroom))) {
                                bookingArrayList.get(i).setHotelRoomToBook(newroom);
                                h = false;
                                break;
                            }
                        }
                    }
                }while (h);
                break;
            case 2:
                boolean g = true;
                do {
                    for (int i = 0; i < bookingArrayList.size(); i++) {
                        if (bookingArrayList.get(i).getAccountNumber() == accountinput) {
                            System.out.println("Current date: " + bookingArrayList.get(i).getDateToBook());
                            System.out.print("New date : ");
                            newdate = input.nextLine();
                            if (!newdate.matches("[0-9]+[0-9]+[0-9]+[0-9]+[-]+[0-9]+[0-9]+[-]+[0-9]+[0-9]")) {
                                System.out.println("Date has to be in yyyy-mm-dd format..");
                            }
                            else {
                                bookingArrayList.get(i).setDateToBook(newdate);
                                g = false;
                            }
                        }
                    }
                }while (g);
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
        return bookingArrayList;
    }


    //metod för att kolla alla tillgängliga rum
    public void availableRooms(ArrayList<Room> hotelrooms) {
        boolean a = true;
        while (a) {
            System.out.println("Which date would you like to see available room? ");
            String date = input.nextLine();
            if (!date.matches("[0-9]+[0-9]+[0-9]+[0-9]+[-]+[0-9]+[0-9]+[-]+[0-9]+[0-9]")) {
                System.out.println("Date has to be in yyyy-mm-dd format..");
            }else {
            for (int i = 0; i < hotelrooms.size(); i++) {
                if (!hotelrooms.get(i).getIsBooked().contains(date)) {
                    System.out.println("Room: " + hotelrooms.get(i).getRoomNumber());
                    a = false;
                }
                }
            }
        }
    }

    public void checkIn(ArrayList<Booking> bookings,ArrayList<Customer> customerArrayList) {
        int accountNumber;
        System.out.println("Enter your account number!");
        accountNumber = Integer.parseInt(input.nextLine());
        boolean stillInCheckInLoop = true;
        boolean printBookingCheckInText = true;
        for (int j = 0; j<customerArrayList.size(); j++) {
            if (customerArrayList.get(j).getAccountNumber()==accountNumber) {
                for (int i = 0; i < bookings.size(); i++) {
                    if (bookings.get(i).getAccountNumber() == accountNumber && bookings.get(i).isCheckedIn() == false) {
                        if (printBookingCheckInText) {
                            System.out.println("Which booking would you like to check in? ");
                            printBookingCheckInText = false;
                        }
                        System.out.println("[" + (i + 1) + "] " + "(date) " + bookings.get(i).getDateToBook() + " (room) " + bookings.get(i).getHotelRoomToBook());
                        stillInCheckInLoop = false;
                    }
                }
                if (!stillInCheckInLoop) {
                    System.out.print("Booking to check in: ");
                    int bookingToCheckIn = Integer.parseInt(input.nextLine());
                    bookings.get(bookingToCheckIn-1).setCheckedIn(true);
                }
            }
        }
        if (stillInCheckInLoop){
            System.out.println("Seems like the account number you have entered does not exist,\nor it does not have any bookings.\n ");
        }
    }

    public void checkOut(ArrayList<Booking> bookings, ArrayList<Customer> customerArrayList, ArrayList<Booking> previousBookings,ArrayList<Room> hotelRooms) {
        int accountNumber;
        System.out.println("Enter your account number!");
        accountNumber = Integer.parseInt(input.nextLine());
        boolean printBookingCheckInText = true;
        boolean stillInCheckOutLoop = true;
        for (int i=0; i<customerArrayList.size();i++){
            if (customerArrayList.get(i).getAccountNumber() == accountNumber){
                for (int j = 0; j<bookings.size(); j++){
                    if (bookings.get(j).getAccountNumber() == accountNumber && bookings.get(j).isCheckedIn() == true){
                        if (printBookingCheckInText) {
                            System.out.println("Which booking would you like to check out? ");
                            printBookingCheckInText = false;
                        }
                        System.out.println("[" + (j+1) + "] " + "(date) " + bookings.get(j).getDateToBook() + " (room) " + bookings.get(j).getHotelRoomToBook());
                        stillInCheckOutLoop = false;
                    }
                }
                if (!stillInCheckOutLoop){
                    System.out.print("Booking to check out: ");
                     int bookingToCheckOut = (Integer.parseInt(input.nextLine())-1);
                     int counter = 0;
                     do {
                        if (hotelRooms.get(counter).getIsBooked().contains(bookings.get(bookingToCheckOut).getDateToBook())){
                            String newIsBooked = hotelRooms.get(counter).getIsBooked().replace(bookings.get(bookingToCheckOut).getDateToBook()+", ", "");
                            hotelRooms.get(counter).setIsBooked(newIsBooked);
                            break;
                        }
                        else if (counter>hotelRooms.size()){
                            break;
                        }
                        else
                            counter++;
                    }while(true);
                     previousBookings.add(bookings.get((bookingToCheckOut)));
                     bookings.remove((bookingToCheckOut));
                }
            }
        }
        if (stillInCheckOutLoop){
            System.out.println("Seems like the account number you have entered does not exist,\nor it does not have any bookings.\n ");
        }
    }

    public void viewCurrentBookings(ArrayList<Booking> bookings) {
        if (bookings.size() > 0) {
            for (int i = 0; i < bookings.size(); i++) {
                System.out.println("Booking belongs to account: " + bookings.get(i).getAccountNumber());
                System.out.println("Booked date: " + bookings.get(i).getDateToBook());
                System.out.println("Room booked: " + (bookings.get(i).getHotelRoomToBook() + 1));
                if (bookings.get(i).isCheckedIn()==true){
                    System.out.println("Checked in: yes");
                }
                else if(bookings.get(i).isCheckedIn()==false){
                    System.out.println("Checked in: no");
                }
                System.out.println();
            }
        } else {
            System.out.println("No current bookings available");
        }
    }

    public void viewCurrentBookingsSpecificCustomer(ArrayList<Booking> bookings){
        boolean bookingOrNot = true;
        System.out.println("Enter account you would like to see bookings for: ");
        int accountNumber = Integer.parseInt(input.nextLine());
        if (bookings.size() > 0) {
            for (int i = 0; i < bookings.size(); i++) {
                if (bookings.get(i).getAccountNumber()==accountNumber) {
                    System.out.println("Account number: " + bookings.get(i).getAccountNumber());
                    System.out.println("Booked date: " + bookings.get(i).getDateToBook());
                    System.out.println("Room booked: " + (bookings.get(i).getHotelRoomToBook() + 1));
                    if (bookings.get(i).isCheckedIn()==true){
                        System.out.println("Checked in: yes");
                    }
                    else if(bookings.get(i).isCheckedIn()==false){
                        System.out.println("Checked in: no");
                    }
                    System.out.println();
                    bookingOrNot = false;
                }
            }
        }
        if (bookingOrNot){
            System.out.println("Seems like the account number you have entered does not exist,\nor it does not have any bookings.\n ");
        }
    }

    public void viewPreviousBookingsForSpecificCustomer(ArrayList<Booking> previousBookings){
        System.out.println("Enter account you would like to see previous bookings for: ");
        int accountNumber = Integer.parseInt(input.nextLine());
        boolean bookingOrNot = true;
        if (previousBookings.size() > 0) {
            for (int i = 0; i < previousBookings.size(); i++) {
                if (previousBookings.get(i).getAccountNumber()==accountNumber) {
                    System.out.println("Account number: " + previousBookings.get(i).getAccountNumber());
                    System.out.println("Booked date: " + previousBookings.get(i).getDateToBook());
                    System.out.println("Room that was booked: " + (previousBookings.get(i).getHotelRoomToBook() + 1));
                    System.out.println();
                    bookingOrNot = false;
                }
            }
        }
        if (bookingOrNot){
            System.out.println("Seems like the account number you have entered does not exist,\nor it does not have any bookings.\n ");
        }
    }

    public ArrayList<Booking> removeBooking(ArrayList<Booking> bookings, ArrayList<Customer> arraylistCustomer, ArrayList<Room> hotelRooms,ArrayList<Booking> previousBookings) {
        System.out.println("Enter account number: ");
        int accountNumber = Integer.parseInt(input.nextLine());
        boolean a = true;

        for (int i = 0; i < arraylistCustomer.size(); i++) {
            if (arraylistCustomer.get(i).getAccountNumber() == accountNumber) {
                for (int j = 0; j < bookings.size(); j++) {
                    if (bookings.get(j).getAccountNumber() == accountNumber) {
                        System.out.println("[" + (j + 1) + "] " + "(date) " + bookings.get(j).getDateToBook() + "(room) " + bookings.get(j).getHotelRoomToBook());
                        a = false;
                    }
                }
                if (!a) {
                    System.out.print("Booking to remove: ");
                    int bookingToRemove = (Integer.parseInt(input.nextLine())-1);
                    int counter = 0;
                    do {
                        if (hotelRooms.get(counter).getIsBooked().contains(bookings.get(bookingToRemove).getDateToBook())){
                            String newIsBooked = hotelRooms.get(counter).getIsBooked().replace(bookings.get(bookingToRemove).getDateToBook()+", ", "");
                            hotelRooms.get(counter).setIsBooked(newIsBooked);
                            break;
                        }
                        else if (counter>hotelRooms.size()){
                            break;
                        }
                        else
                            counter++;
                    }while(true);
                    previousBookings.add(bookings.get(bookingToRemove));
                    bookings.remove((bookingToRemove));
                    return bookings;
                }
            }
        }
        if (a) {
            System.out.println("Seems like the account number you have entered does not exist,\nor it does not have any bookings.\n ");
        }
        return bookings;
    }

    public int createAccountnumber(ArrayList<Customer> customerArrayList){
        int accountNumber = 1;

        for (int i = 0; i<customerArrayList.size(); i++){
            if (customerArrayList.get(i).getAccountNumber() == accountNumber){
                accountNumber++;
            }
            else {
                break;
            }
        }
        return accountNumber;
    }
}