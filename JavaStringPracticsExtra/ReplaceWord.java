public class ReplaceWord {
    public static void main(String[] args) {
        String sentence = "Write code every day to get better";
        String result = sentence.replaceAll("\\bcode\\b", "Java");
        System.out.println("Replaced sentence: " + result);
    }
}