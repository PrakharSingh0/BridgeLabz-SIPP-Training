import java.util.Scanner;

public class StringIndexExceptionExample {
    public static void generateException(String text) {
        System.out.println(text.charAt(text.length())); // This will throw exception
    }

    public static void handleException(String text) {
        try {
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException handled: " + e.getMessage());
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