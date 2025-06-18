import java.util.Scanner;

public class VowelConsonantCounter {
    public static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return "aeiou".indexOf(ch) != -1;
    }

    public static int[] countVowelsConsonants(String text) {
        int vowels = 0, consonants = 0;

        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                if (isVowel(ch)) vowels++;
                else consonants++;
            }
        }

        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        int[] counts = countVowelsConsonants(text);
        System.out.println("Vowels: " + counts[0]);
        System.out.println("Consonants: " + counts[1]);

        scanner.close();
    }
}