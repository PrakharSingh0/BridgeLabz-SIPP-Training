import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

public class LargeFileErrorReader {

    private static final String LARGE_FILE_NAME = "large_log_file.txt";

    public static void main(String[] args) {
        // Create a dummy large log file for demonstration
        createDummyLargeLogFile(LARGE_FILE_NAME, 100000); // Create a file with 100,000 lines

        System.out.println("Reading large file line by line for 'error'...");
        long startTime = System.nanoTime();

        try (BufferedReader reader = new BufferedReader(new FileReader(LARGE_FILE_NAME))) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                // Case-insensitive search for "error"
                if (line.toLowerCase().contains("error")) {
                    System.out.println("Line " + lineNumber + ": " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000; // milliseconds
        System.out.println("\nFinished reading file. Time taken: " + duration + " ms.");
    }

    private static void createDummyLargeLogFile(String filePath, int numLines) {
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("Dummy large log file already exists: " + filePath);
            return;
        }
        System.out.println("Creating dummy large log file: " + filePath + " with " + numLines + " lines...");
        try (FileWriter writer = new FileWriter(filePath)) {
            for (int i = 1; i <= numLines; i++) {
                if (i % 100 == 0) {
                    writer.write("This is an ERROR message on line " + i + ".\n");
                } else if (i % 50 == 0) {
                    writer.write("Warning: Something happened on line " + i + ".\n");
                } else {
                    writer.write("Info: This is a normal log entry on line " + i + ".\n");
                }
            }
            System.out.println("Dummy large log file created.");
        } catch (IOException e) {
            System.err.println("Error creating dummy log file: " + e.getMessage());
        }
    }
}
