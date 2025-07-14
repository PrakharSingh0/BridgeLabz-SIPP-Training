import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithmComparison {

    // Bubble Sort Implementation
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort Implementation
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // Quick Sort Implementation
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000};
        Random random = new Random();

        System.out.println("Sorting Algorithm Performance Comparison");
        System.out.println("----------------------------------------");

        for (int N : datasetSizes) {
            int[] originalData = new int[N];
            for (int i = 0; i < N; i++) {
                originalData[i] = random.nextInt(N * 10);
            }

            System.out.printf("Dataset Size (N): %,d%n", N);

            // Bubble Sort Measurement
            int[] dataBubble = Arrays.copyOf(originalData, N);
            long startTimeBubble = System.nanoTime();
            bubbleSort(dataBubble);
            long endTimeBubble = System.nanoTime();
            long durationBubble = (endTimeBubble - startTimeBubble) / 1_000_000; // milliseconds
            System.out.printf("  Bubble Sort Time: %d ms%n", durationBubble);

            // Merge Sort Measurement
            int[] dataMerge = Arrays.copyOf(originalData, N);
            long startTimeMerge = System.nanoTime();
            mergeSort(dataMerge);
            long endTimeMerge = System.nanoTime();
            long durationMerge = (endTimeMerge - startTimeMerge) / 1_000_000; // milliseconds
            System.out.printf("  Merge Sort Time: %d ms%n", durationMerge);

            // Quick Sort Measurement
            int[] dataQuick = Arrays.copyOf(originalData, N);
            long startTimeQuick = System.nanoTime();
            quickSort(dataQuick, 0, dataQuick.length - 1);
            long endTimeQuick = System.nanoTime();
            long durationQuick = (endTimeQuick - startTimeQuick) / 1_000_000; // milliseconds
            System.out.printf("  Quick Sort Time: %d ms%n", durationQuick);
            System.out.println();
        }

        System.out.println("Expected Result: Bubble Sort is impractical for large datasets. Merge Sort & Quick Sort perform well.");
    }
}