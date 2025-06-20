import java.util.Scanner;

public class NaturalNumberSum {
    public static int calculateSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = input.nextInt();
        int total = calculateSum(n);
        System.out.println("The sum of the first " + n + " natural numbers is " + total);
        input.close();
    }
}