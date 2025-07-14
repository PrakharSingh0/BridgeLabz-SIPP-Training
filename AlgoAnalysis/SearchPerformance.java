import java.util.Arrays;
import java.util.Random;

public class SearchPerformance {

    // Linear Search Implementation
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Target found at index i
            }
        }
        return -1; // Target not found
    }

    // Binary Search Implementation
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid; // Target found at mid
            } else if (arr[mid] < target) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000, 1000000};
        Random random = new Random();

        System.out.println("Search Performance Comparison (Linear vs Binary Search)");
        System.out.println("------------------------------------------------------");

        for (int N : datasetSizes) {
            int[] data = new int[N];
            for (int i = 0; i < N; i++) {
                data[i] = random.nextInt(N * 2); // Populate with random data
            }
            Arrays.sort(data); // Binary search requires sorted data

            int target = data[random.nextInt(N)]; // Pick a target that exists

            // Linear Search Measurement
            long startTimeLinear = System.nanoTime();
            linearSearch(data, target);
            long endTimeLinear = System.nanoTime();
            long durationLinear = (endTimeLinear - startTimeLinear) / 1_000_000; // milliseconds

            // Binary Search Measurement
            long startTimeBinary = System.nanoTime();
            binarySearch(data, target);
            long endTimeBinary = System.nanoTime();
            long durationBinary = (endTimeBinary - startTimeBinary) / 1_000_000; // milliseconds

            System.out.printf("Dataset Size (N): %,d%n", N);
            System.out.printf("  Linear Search Time: %d ms%n", durationLinear);
            System.out.printf("  Binary Search Time: %d ms%n", durationBinary);
            System.out.println();
        }

        System.out.println("Expected Result: Binary Search performs much better for large datasets, provided data is sorted.");
    }
}