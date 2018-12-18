package hotelManagement;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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

    public void addRecord(Booking booking){
        {
            x.format("Account number: %d, Room booked: %d, Booked the date: %s", booking.getAccountNumber(),
                    (booking.getHotelRoomToBook()+1), booking.getDateToBook() + "\n");
        }
    }

    public void closeFile(){
        x.close();
    }
}
