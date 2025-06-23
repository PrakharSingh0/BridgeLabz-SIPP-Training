public class CompareStrings {
    public static void main(String[] args) {
        String s1 = "apple", s2 = "banana";
        int len = Math.min(s1.length(), s2.length());
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                System.out.println((s1.charAt(i) < s2.charAt(i)) ? s1 + " comes before " + s2 : s2 + " comes before " + s1);
                return;
            }
        }
        System.out.println((s1.length() < s2.length()) ? s1 + " comes before " + s2 : s2 + " comes before " + s1);
    }
}