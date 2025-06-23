public class MostFrequentChar {
    public static void main(String[] args) {
        String str = "success";
        int[] freq = new int[256];
        for (char c : str.toCharArray()) {
            freq[c]++;
        }
        char result = ' ';
        int max = 0;
        for (char c : str.toCharArray()) {
            if (freq[c] > max) {
                max = freq[c];
                result = c;
            }
        }
        System.out.println("Most frequent character: " + result);
    }
}