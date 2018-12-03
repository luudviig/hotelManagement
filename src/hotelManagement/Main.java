package hotelManagement;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Main getMethod = new Main();

        //Detta är en array som består av flera obejkt(Room)-Ludde
        Room[] hotelRooms = new Room[100];

        //Skapar en loop som lägger till objekt(Room), första våningen-Ludde
        for (int i = 0; i<25; i++){
            Room room1 = new Room(i+1,2,false,2000,false,1);
            hotelRooms[i] = room1;
        }
        //Skapar en loop som lägger till objekt(Room), andra våningen-Ludde
        for (int i = 25; i<50; i++){
            Room room2 = new Room(i+1,2,true,2500,false,2);
            hotelRooms[i] = room2;
        }
        //Skapar en loop som lägger till objekt(Room), tredje våningen-Ludde
        for (int i = 49; i<100; i++){
            Room room3 = new Room(i+1,2,true,3000,false,3);
            hotelRooms[i] = room3;
        }

        //Ett sätt för att se vad som finns i array(hotelRooms).
//        for (int i = 0; i<hotelRooms.length; i++){
//            System.out.println("Room number: " + hotelRooms[i].getRoomNumber());
//            System.out.println("Number of beds: " + hotelRooms[i].getNumberOfBeds());
//            System.out.println("Price per night: " + hotelRooms[i].getPricePerNight());
//            System.out.println("Booked: " + hotelRooms[i].isBooked());
//            System.out.println("Balcony: " + hotelRooms[i].isHasBalcony());
//            System.out.println();
//        }




    }

//    private Room[] makeBooking(Room room, Room[] hotelRooms,int roomToBook) {
//
//    }
}
