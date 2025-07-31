import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCounter {

    private static final String TEXT_FILE_NAME = "sample_text.txt";

    public static void main(String[] args) {
        // Create a dummy text file for demonstration
        createDummyTextFile(TEXT_FILE_NAME);

        Map<String, Integer> wordFrequencies = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(TEXT_FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into words using non-alphanumeric characters as delimiters
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (!word.trim().isEmpty()) { // Ensure word is not empty after trimming
                        wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }

        // Display total word count
        int totalWords = wordFrequencies.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println("Total words in the file: " + totalWords);

        // Display top 5 most frequently occurring words
        System.out.println("\nTop 5 most frequently occurring words:");
        wordFrequencies.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    private static void createDummyTextFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("Dummy text file already exists: " + filePath);
            return;
        }
        System.out.println("Creating dummy text file: " + filePath + "...");
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Java is a programming language. Java is widely used. " +
                         "Java is popular. Programming is fun. Language is key.");
        } catch (IOException e) {
            System.err.println("Error creating dummy text file: " + e.getMessage());
        }
    }
}
