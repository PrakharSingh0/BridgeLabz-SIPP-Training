import java.util.Scanner;

public class IllegalArgumentExample {
    public static void generateException(String text, int start, int end) {
        System.out.println(text.substring(end, start)); // This will throw exception
    }

    public static void handleException(String text, int start, int end) {
        try {
            System.out.println(text.substring(end, start));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException handled: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.next();
        System.out.print("Enter start index: ");
        int start = scanner.nextInt();
        System.out.print("Enter end index: ");
        int end = scanner.nextInt();

        generateException(text, start, end);
        handleException(text, start, end);

        scanner.close();
    }
}