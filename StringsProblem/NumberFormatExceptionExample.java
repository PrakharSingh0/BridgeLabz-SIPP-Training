import java.util.Scanner;

public class NumberFormatExceptionExample {
    public static void generateException(String text) {
        int num = Integer.parseInt(text); // This will throw exception
        System.out.println("Parsed number: " + num);
    }

    public static void handleException(String text) {
        try {
            int num = Integer.parseInt(text);
            System.out.println("Parsed number: " + num);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException handled: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.next();

        generateException(text);
        handleException(text);

        scanner.close();
    }
}