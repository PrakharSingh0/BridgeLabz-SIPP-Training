import java.util.Scanner;

public class SumComparison {
    public static int recursiveSum(int n) {
        return (n == 1) ? 1 : n + recursiveSum(n - 1);
    }

    public static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = input.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a positive natural number.");
        } else {
            int recSum = recursiveSum(n);
            int formula = formulaSum(n);
            System.out.println("Recursive Sum: " + recSum);
            System.out.println("Formula Sum: " + formula);
            System.out.println("Both results " + (recSum == formula ? "match!" : "do NOT match."));
        }
        input.close();
    }
}