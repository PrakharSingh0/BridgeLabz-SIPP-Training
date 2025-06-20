import java.util.Random;

public class HeightAnalysis {
    public static int[] generateHeights(int players) {
        int[] heights = new int[players];
        Random rand = new Random();
        for (int i = 0; i < players; i++) {
            heights[i] = 150 + rand.nextInt(101); // 150–250 cm
        }
        return heights;
    }

    public static int sum(int[] arr) {
        int total = 0;
        for (int n : arr) total += n;
        return total;
    }

    public static int min(int[] arr) {
        int min = arr[0];
        for (int n : arr) if (n < min) min = n;
        return min;
    }

    public static int max(int[] arr) {
        int max = arr[0];
        for (int n : arr) if (n > max) max = n;
        return max;
    }

    public static void main(String[] args) {
        int[] heights = generateHeights(11);
        int total = sum(heights);
        double mean = total / 11.0;
        System.out.print("Heights: ");
        for (int h : heights) System.out.print(h + " ");
        System.out.println("\nMean height: " + mean + " cm");
        System.out.println("Shortest: " + min(heights) + " cm");
        System.out.println("Tallest: " + max(heights) + " cm");
    }
}