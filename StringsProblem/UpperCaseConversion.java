import java.util.Scanner;

public class UpperCaseConversion {
    public static String convertToUpperCase(String text) {
        StringBuilder sb = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                sb.append((char) (ch - 32));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String manualUpperCase = convertToUpperCase(text);
        String builtInUpperCase = text.toUpperCase();

        System.out.println("Manual uppercase conversion: " + manualUpperCase);
        System.out.println("Built-in uppercase conversion: " + builtInUpperCase);
        System.out.println("Are both conversions equal? " + manualUpperCase.equals(builtInUpperCase));

        scanner.close();
    }
}