import java.util.Scanner;

public class Q18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter value of a: ");
        int a = scanner.nextInt();
        System.out.print("Enter value of b: ");
        int b = scanner.nextInt();
        System.out.print("Enter value of c: ");
        int c = scanner.nextInt();

        System.out.println("Results of Integer Operations:");
        System.out.println("a + b * c = " + (a + b * c));
        System.out.println("a * b + c = " + (a * b + c));
        System.out.println("c + a / b = " + (c + a / b));
        System.out.println("a % b + c = " + (a % b + c));

        scanner.close();
    }
}