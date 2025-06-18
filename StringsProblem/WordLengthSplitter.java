import java.util.Scanner;

public class WordLengthSplitter {
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

    public static String[][] generateWordLengthArray(String[] words) {
        String[][] wordLengths = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            wordLengths[i][0] = words[i];
            wordLengths[i][1] = String.valueOf(words[i].length());
        }
        return wordLengths;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[] words = splitText(text);
        String[][] wordLengths = generateWordLengthArray(words);

        System.out.println("Word\tLength");
        for (String[] wordLength : wordLengths) {
            System.out.println(wordLength[0] + "\t" + wordLength[1]);
        }

        scanner.close();
    }
}