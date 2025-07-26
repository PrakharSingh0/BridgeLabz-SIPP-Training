import java.util.*;

public class VotingSystem {
    private static Map<String, Integer> voteCountMap = new HashMap<>();         // Fast vote lookup
    private static LinkedHashMap<String, Integer> voteOrderMap = new LinkedHashMap<>(); // Order of voting
    private static TreeMap<String, Integer> sortedResults = new TreeMap<>();    // Sorted results by candidate

    public static void castVote(String candidate) {
        // Update HashMap (total vote count)
        voteCountMap.put(candidate, voteCountMap.getOrDefault(candidate, 0) + 1);

        // Update LinkedHashMap (order-aware)
        voteOrderMap.put(candidate, voteOrderMap.getOrDefault(candidate, 0) + 1);

        // Update TreeMap (sorted by name)
        sortedResults.put(candidate, voteCountMap.get(candidate)); // sync with HashMap
    }

    public static void main(String[] args) {
        castVote("Alice");
        castVote("Bob");
        castVote("Alice");
        castVote("Charlie");
        castVote("Bob");

        System.out.println("🔍 Vote Count (HashMap - fast lookup):");
        System.out.println(voteCountMap);

        System.out.println("\n🕒 Vote Order (LinkedHashMap - insertion order):");
        System.out.println(voteOrderMap);

        System.out.println("\n📊 Sorted Results (TreeMap - alphabetical):");
        System.out.println(sortedResults);
    }
}