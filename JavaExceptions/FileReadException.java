import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadException {
    public static void main(String[] args) {
        String fileName = "D:\\BridgeLabz-SIPP-Training\\JavaExceptions\\data.txt";
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            System.out.println("File contents:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}