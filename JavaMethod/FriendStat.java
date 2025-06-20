import java.util.Scanner;

public class FriendStat {
    public static int findYoungestIndex(int[] ages) {
        int minIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[minIndex]) minIndex = i;
        }
        return minIndex;
    }

    public static int findTallestIndex(double[] heights) {
        int maxIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[maxIndex]) maxIndex = i;
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            ages[i] = input.nextInt();
            System.out.print("Enter height of " + names[i] + ": ");
            heights[i] = input.nextDouble();
        }

        int youngest = findYoungestIndex(ages);
        int tallest = findTallestIndex(heights);

        System.out.println("The youngest friend is " + names[youngest]);
        System.out.println("The tallest friend is " + names[tallest]);
        input.close();
    }
}