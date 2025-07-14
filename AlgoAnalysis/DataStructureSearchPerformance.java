import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class DataStructureSearchPerformance {

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 100000, 1000000};
        Random random = new Random();

        System.out.println("Data Structure Search Performance Comparison");
        System.out.println("--------------------------------------------");

        for (int N : datasetSizes) {
            // Prepare data
            Integer[] data = new Integer[N];
            for (int i = 0; i < N; i++) {
                data[i] = random.nextInt(N * 2);
            }
            Integer target = data[random.nextInt(N)]; // Pick a target that exists

            System.out.printf("Dataset Size (N): %,d%n", N);

            // Array Search Measurement
            long startTimeArray = System.nanoTime();
            boolean foundArray = false;
            for (int i = 0; i < N; i++) {
                if (data[i].equals(target)) {
                    foundArray = true;
                    break;
                }
            }
            long endTimeArray = System.nanoTime();
            long durationArray = (endTimeArray - startTimeArray) / 1_000_000; // milliseconds
            System.out.printf("  Array Search (O(N)) Time: %d ms%n", durationArray);

            // HashSet Search Measurement
            HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(data));
            long startTimeHashSet = System.nanoTime();
            boolean foundHashSet = hashSet.contains(target);
            long endTimeHashSet = System.nanoTime();
            long durationHashSet = (endTimeHashSet - startTimeHashSet) / 1_000_000; // milliseconds
            System.out.printf("  HashSet Search (O(1)) Time: %d ms%n", durationHashSet);

            // TreeSet Search Measurement
            TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(data));
            long startTimeTreeSet = System.nanoTime();
            boolean foundTreeSet = treeSet.contains(target);
            long endTimeTreeSet = System.nanoTime();
            long durationTreeSet = (endTimeTreeSet - startTimeTreeSet) / 1_000_000; // milliseconds
            System.out.printf("  TreeSet Search (O(log N)) Time: %d ms%n", durationTreeSet);
            System.out.println();
        }

        System.out.println("Expected Result: HashSet is fastest for lookups but requires extra memory.");
        System.out.println("TreeSet maintains order but is slightly slower than HashSet.");
    }
}