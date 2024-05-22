package Week2;
import java.io.*;
import java.util.*;

public class ReadingAndWriting {


    public static void main(String[] args){


        String fileName = "practice.csv";


        //BufferedWriter and Reader are able to read and write data in chunks, which is more effecient
        //The FileWriter and Reader can only read and write data one byte at a time, one line at a time
        try(BufferedWriter w1 = new BufferedWriter(new FileWriter(fileName))){

            //this is where the code you'd like to execute should
            w1.write("First Name, Last Name, Employee ID");
            w1.newLine();

            w1.write("John, Wick, 1");
            w1.newLine();

            w1.write("Jason, Bourne, 2");
            w1.newLine();

            w1.write("Denzel, Washington, 3");
            w1.newLine();

        }
        catch(IOException e){

            e.printStackTrace();
            //code to handle any sort of issues in the try block
        }

        readFromExcelSheet(fileName);

    }


    public static void readFromExcelSheet(String fileName){

        // fileName = "test.csv";

        try(Scanner input = new Scanner(new File(fileName))){

            System.out.println("Currently reading your file....");

            while(input.hasNextLine()){

                String line = input.nextLine();
                System.out.println(line);

            }


        }
        catch(IOException e){

            e.printStackTrace();
        }
       

    }


    
}
