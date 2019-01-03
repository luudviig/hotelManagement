package hotelManagement;

import java.io.File;
import java.util.Scanner;

public class ReadFile {

    private Scanner x;

    public void openFile(){
        try{
            x=new Scanner(new File("allBookings.txt"));
        }
        catch (Exception ex){
            System.out.println("There was opening the file to read..");
        }
    }

    public void readFile (){
        try { while (x.hasNext()) {
            System.out.print(x.nextLine()+ "\n");
        }
        }catch (Exception ex){
            System.out.println("There was an error reading the file..");
        }
    }

    public void closeFile(){
        x.close();
    }


}
