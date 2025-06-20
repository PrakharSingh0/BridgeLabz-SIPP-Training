import java.util.Scanner;

public class NumberAnalyzer {
    public static boolean isPositive(int n) {
        return n >= 0;
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static int compare(int a, int b) {
        return a > b ? 1 : (a == b ? 0 : -1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }

        for (int num : numbers) {
            if (isPositive(num)) {
                System.out.println(num + " is positive and " + (isEven(num) ? "even." : "odd."));
            } else {
                System.out.println(num + " is negative.");
            }
        }

        int result = compare(numbers[0], numbers[4]);
        System.out.println("First and last comparison: " +
            (result == 1 ? "First is greater." : result == 0 ? "Both are equal." : "Last is greater."));
        input.close();
    }
}