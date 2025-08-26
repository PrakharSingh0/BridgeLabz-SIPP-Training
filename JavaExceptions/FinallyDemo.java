import java.util.Scanner;

public class FinallyDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter first integer: ");
            int num1 = scanner.nextInt();
            
            System.out.print("Enter second integer: ");
            int num2 = scanner.nextInt();
            
            int result = num1 / num2;
            System.out.println("Result: " + result);
            
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        } catch (Exception e) {
            System.out.println("Invalid input!");
        } finally {
            System.out.println("Operation completed");
            scanner.close();
        }
    }
}