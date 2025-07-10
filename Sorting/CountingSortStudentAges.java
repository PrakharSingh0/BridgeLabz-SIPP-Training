public class CountingSortStudentAges {
    public static void countingSort(int[] ages, int maxAge) {
        int[] count = new int[maxAge + 1];

        for (int age : ages) count[age]++;
        int index = 0;
        for (int i = 0; i <= maxAge; i++) {
            while (count[i]-- > 0) {
                ages[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] ages = {12, 14, 13, 12, 15, 11, 14};
        countingSort(ages, 18);
        for (int age : ages) {
            System.out.print(age + " ");
        }
    }
}