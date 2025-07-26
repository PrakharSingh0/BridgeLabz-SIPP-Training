import java.util.*;
import java.util.regex.*;

public class WordFrequency {
    public static Map<String, Integer> countWords(String text) {
        Map<String, Integer> freqMap = new HashMap<>();
        text = text.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "");
        for (String word : text.split("\\s+")) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        return freqMap;
    }

    public static void main(String[] args) {
        String input = "Hello world, hello Java!";
        System.out.println("Frequency: " + countWords(input));
    }
}