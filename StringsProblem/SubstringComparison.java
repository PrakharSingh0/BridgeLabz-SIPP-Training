import java.util.Scanner;

public class SubstringComparison {
    public static String createSubstring(String text, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(text.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.next();
        System.out.print("Enter start index: ");
        int start = scanner.nextInt();
        System.out.print("Enter end index: ");
        int end = scanner.nextInt();

        String customSubstring = createSubstring(text, start, end);
        String builtInSubstring = text.substring(start, end);

        System.out.println("Custom substring: " + customSubstring);
        System.out.println("Built-in substring: " + builtInSubstring);
        System.out.println("Are both substrings equal? " + customSubstring.equals(builtInSubstring));

        scanner.close();
    }
}