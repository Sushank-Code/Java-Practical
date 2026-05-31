import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ques14 {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("Output/student.txt");
            writer.write("Name: Sushank\n");
            writer.write("Class: Bsc.CSIT\n");
            writer.close();

            FileReader reader = new FileReader("Output/student.txt");
            int ch;

            System.out.println("Data from file:");
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
