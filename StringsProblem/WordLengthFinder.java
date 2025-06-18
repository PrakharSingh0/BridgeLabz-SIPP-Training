import java.util.Scanner;

public class WordLengthFinder {
    public static String[] splitText(String text) {
        int count = 1; // At least one word
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
        words[index] = text.substring(start); // Last word

        return words;
    }

    public static int findLength(String word) {
        int length = 0;
        try {
            while (word.charAt(length) != '\0') length++;
        } catch (StringIndexOutOfBoundsException e) {
            return length;
        }
        return length;
    }

    public static String[][] generateWordLengthArray(String[] words) {
        String[][] wordLengths = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            wordLengths[i][0] = words[i];
            wordLengths[i][1] = String.valueOf(findLength(words[i]));
        }
        return wordLengths;
    }

    public static String[] findShortestLongest(String[][] wordLengths) {
        String shortest = wordLengths[0][0], longest = wordLengths[0][0];

        for (String[] wordLength : wordLengths) {
            if (findLength(wordLength[0]) < findLength(shortest)) {
                shortest = wordLength[0];
            }
            if (findLength(wordLength[0]) > findLength(longest)) {
                longest = wordLength[0];
            }
        }
        return new String[]{shortest, longest};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[] words = splitText(text);
        String[][] wordLengths = generateWordLengthArray(words);
        String[] shortestLongest = findShortestLongest(wordLengths);

        System.out.println("Shortest word: " + shortestLongest[0]);
        System.out.println("Longest word: " + shortestLongest[1]);

        scanner.close();
    }
}