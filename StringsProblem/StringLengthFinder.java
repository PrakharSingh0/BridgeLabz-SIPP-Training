import java.util.Scanner;

public class StringLengthFinder {
    public static int findLength(String text) {
        int count = 0;
        try {
            while (text.charAt(count) != '\0') count++;
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.next();

        int customLength = findLength(text);
        int builtInLength = text.length();

        System.out.println("Custom method length: " + customLength);
        System.out.println("Built-in method length: " + builtInLength);
        scanner.close();
    }
}