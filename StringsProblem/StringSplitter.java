import java.util.Scanner;

public class StringSplitter {
    public static String[] splitText(String text) {
        int count = 1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') count++;
        }

        String[] words = new String[count];
        int start = 0, index = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                words[index++] = text.substring(start, i);
                start = i + 1;
            }
        }
        words[index] = text.substring(start);

        return words;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[] customSplit = splitText(text);
        String[] builtInSplit = text.split(" ");

        System.out.println("Custom split method result: " + String.join(", ", customSplit));
        System.out.println("Built-in split method result: " + String.join(", ", builtInSplit));
        System.out.println("Are both results equal? " + (String.join("", customSplit).equals(String.join("", builtInSplit))));

        scanner.close();
    }
}