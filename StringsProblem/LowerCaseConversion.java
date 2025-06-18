import java.util.Scanner;

public class LowerCaseConversion {
    public static String convertToLowerCase(String text) {
        StringBuilder sb = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                sb.append((char) (ch + 32));
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

        String manualLowerCase = convertToLowerCase(text);
        String builtInLowerCase = text.toLowerCase();

        System.out.println("Manual lowercase conversion: " + manualLowerCase);
        System.out.println("Built-in lowercase conversion: " + builtInLowerCase);
        System.out.println("Are both conversions equal? " + manualLowerCase.equals(builtInLowerCase));

        scanner.close();
    }
}