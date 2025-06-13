import java.util.Scanner;

public class Q15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter value of a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter value of b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter value of c: ");
        double c = scanner.nextDouble();
        System.out.println("Results of Double Operations:");
        System.out.println("a + b * c = " + (a + b * c));
        System.out.println("a * b + c = " + (a * b + c));
        System.out.println("c + a / b = " + (c + a / b));
        System.out.println("a % b + c = " + (a % b + c));
        scanner.close();
    }
}