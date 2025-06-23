import java.util.Scanner;

class PalindromeChecker {
    String text;

    void inputText() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        text = sc.nextLine();
    }

    boolean isPalindrome() {
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }

    void displayResult() {
        System.out.println("\"" + text + "\" is " + (isPalindrome() ? "" : "not ") + "a palindrome.");
    }

    public static void main(String[] args) {
        PalindromeChecker pc = new PalindromeChecker();
        pc.inputText();
        pc.displayResult();
    }
}