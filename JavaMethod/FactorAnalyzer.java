import java.util.Scanner;

public class FactorAnalyzer {
    public static int[] getFactors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) count++;
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) factors[index++] = i;
        return factors;
    }

    public static int sumOfFactors(int[] arr) {
        int sum = 0;
        for (int val : arr) sum += val;
        return sum;
    }

    public static long productOfFactors(int[] arr) {
        long prod = 1;
        for (int val : arr) prod *= val;
        return prod;
    }

    public static double sumOfSquares(int[] arr) {
        double sum = 0;
        for (int val : arr) sum += Math.pow(val, 2);
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = input.nextInt();
        int[] factors = getFactors(num);
        System.out.print("Factors: ");
        for (int f : factors) System.out.print(f + " ");
        System.out.println("\nSum: " + sumOfFactors(factors));
        System.out.println("Product: " + productOfFactors(factors));
        System.out.println("Sum of Squares: " + sumOfSquares(factors));
        input.close();
    }
}