public class BubbleSortStudentMarks {
    public static void bubbleSort(int[] marks) {
        boolean swapped;
        for (int i = 0; i < marks.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < marks.length - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] marks = {78, 55, 89, 92, 61};
        bubbleSort(marks);
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
    }
}