import java.util.Scanner;

public class StringCharacterComparison {
    public static char[] getCharacters(String text) {
        char[] characters = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            characters[i] = text.charAt(i);
        }
        return characters;
    }

    public static boolean compareArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.next();

        char[] customArray = getCharacters(input);
        char[] builtInArray = input.toCharArray();

        boolean areEqual = compareArrays(customArray, builtInArray);

        System.out.println("Custom method result: " + new String(customArray));
        System.out.println("Built-in method result: " + new String(builtInArray));
        System.out.println("Are both results equal? " + areEqual);
        scanner.close();
    }
}