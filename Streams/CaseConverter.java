import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class CaseConverter {

    public static void main(String[] args) {
        String sourceFilePath = "source_case.txt";
        String destinationFilePath = "destination_lowercase.txt";

      
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine(); // Write a new line character
            }
            System.out.println("File content converted to lowercase and written to " + destinationFilePath);

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }


}