import java.util.*;

public class ZeroSumSubarrays {

    static List<int[]> findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> sumIndices = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        int sum = 0;
        sumIndices.put(0, new ArrayList<>(Arrays.asList(-1)));

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sumIndices.containsKey(sum)) {
                for (int index : sumIndices.get(sum)) {
                    result.add(new int[]{index + 1, i});
                }
            }
            sumIndices.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 3, 1, 3, 1, -4};
        List<int[]> subarrays = findZeroSumSubarrays(arr);
        for (int[] sub : subarrays)
            System.out.println("Zero-sum from " + sub[0] + " to " + sub[1]);
    }
}