import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileReadingEfficiency {

    private static final String TEST_FILE_NAME = "test_large_file.txt";

    // Helper to create a dummy large file
    public static void createLargeFile(long sizeMB) throws IOException {
        long sizeBytes = sizeMB * 1024 * 1024;
        try (FileOutputStream fos = new FileOutputStream(TEST_FILE_NAME)) {
            byte[] data = "This is a test line for file reading efficiency comparison.\n".getBytes(StandardCharsets.UTF_8);
            long bytesWritten = 0;
            while (bytesWritten < sizeBytes) {
                fos.write(data);
                bytesWritten += data.length;
            }
        }
    }

    public static void main(String[] args) {
        long[] fileSizesMB = {1, 10}; // Reduced from 100MB, 500MB for practical execution

        System.out.println("File Reading Efficiency Comparison");
        System.out.println("----------------------------------");

        for (long sizeMB : fileSizesMB) {
            try {
                createLargeFile(sizeMB);
                System.out.printf("File Size: %,d MB%n", sizeMB);

                // FileReader Measurement
                long startTimeFileReader = System.nanoTime();
                try (FileReader fr = new FileReader(TEST_FILE_NAME)) {
                    int charRead;
                    while ((charRead = fr.read()) != -1) {
                        // Read character by character
                    }
                }
                long endTimeFileReader = System.nanoTime();
                long durationFileReader = (endTimeFileReader - startTimeFileReader) / 1_000_000; // milliseconds
                System.out.printf("  FileReader Time: %d ms%n", durationFileReader);

                // InputStreamReader Measurement (with BufferedReader for efficiency)
                long startTimeInputStreamReader = System.nanoTime();
                try (InputStreamReader isr = new InputStreamReader(new FileInputStream(TEST_FILE_NAME), StandardCharsets.UTF_8);
                     BufferedReader br = new BufferedReader(isr)) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        // Read line by line
                    }
                }
                long endTimeInputStreamReader = System.nanoTime();
                long durationInputStreamReader = (endTimeInputStreamReader - startTimeInputStreamReader) / 1_000_000; // milliseconds
                System.out.printf("  InputStreamReader Time: %d ms%n", durationInputStreamReader);
                System.out.println();

                // Clean up the created file
                new File(TEST_FILE_NAME).delete();

            } catch (IOException e) {
                System.err.println("Error during file operations: " + e.getMessage());
            }
        }

        System.out.println("Expected Result: InputStreamReader is more efficient for large files. FileReader is preferable for text-based data.");
    }
}