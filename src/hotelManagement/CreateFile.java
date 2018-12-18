package hotelManagement;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Formatter;

public class CreateFile {

    private Formatter x;

    public void openFile(){
        try {
            Path path = Paths.get("allBookings.txt");
            BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardOpenOption.APPEND);
            x = new Formatter(bufferedWriter);
        }
        catch (Exception ex){
            System.out.println("There was an error while opening the file..");
        }
    }

    public void addRecords(ArrayList<Booking> bookings){
        for (int i=0; i<bookings.size();i++) {
            x.format("Account number: %d, Room booked: %d, Booked the date: %s", bookings.get(i).getAccountNumber(),
                    (bookings.get(i).getHotelRoomToBook()+1), bookings.get(i).getDateToBook() + "\n");
        }
    }

    public void closeFile(){
        x.close();
    }
}
