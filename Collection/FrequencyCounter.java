import java.util.*;

public class FrequencyCounter {
    public static Map<String, Integer> countFrequency(List<String> items) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String item : items) {
            freqMap.put(item, freqMap.getOrDefault(item, 0) + 1);
        }
        return freqMap;
    }

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange");
        Map<String, Integer> frequency = countFrequency(fruits);
        System.out.println("Frequency: " + frequency);
    }
}