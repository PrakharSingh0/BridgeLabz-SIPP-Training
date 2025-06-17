import java.util.Scanner;

public class IntOperations {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter value for a: ");
        int a = input.nextInt();
        System.out.print("Enter value for b: ");
        int b = input.nextInt();
        System.out.print("Enter value for c: ");
        int c = input.nextInt();
        System.out.println("The results of Int Operations are: ");
        System.out.println("a + b * c = " + (a + b * c));
        System.out.println("a * b + c = " + (a * b + c));
        System.out.println("c + a / b = " + (c + a / b));
        System.out.println("a % b + c = " + (a % b + c));
        input.close();
    }
}