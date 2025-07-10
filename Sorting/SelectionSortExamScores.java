public class SelectionSortExamScores {
    public static void selectionSort(int[] scores) {
        for (int i = 0; i < scores.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < scores.length; j++) {
                if (scores[j] < scores[minIndex]) minIndex = j;
            }
            int temp = scores[minIndex]; scores[minIndex] = scores[i]; scores[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] scores = {83, 72, 94, 65, 88};
        selectionSort(scores);
        for (int score : scores) {
            System.out.print(score + " ");
        }
    }
}