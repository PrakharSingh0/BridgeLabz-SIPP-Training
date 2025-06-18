import java.util.Random;

public class StudentScoreCalculator {
    public static int[][] generateScores(int students) {
        int[][] scores = new int[students][3];
        Random rand = new Random();

        for (int i = 0; i < students; i++) {
            scores[i][0] = rand.nextInt(100); // Physics
            scores[i][1] = rand.nextInt(100); // Chemistry
            scores[i][2] = rand.nextInt(100); // Math
        }
        return scores;
    }

    public static String calculateGrade(double percentage) {
        if (percentage >= 90) return "A";
        else if (percentage >= 80) return "B";
        else if (percentage >= 70) return "C";
        else if (percentage >= 60) return "D";
        else return "F";
    }

    public static void main(String[] args) {
        int students = 5; // Adjust as needed
        int[][] scores = generateScores(students);

        System.out.println("Student\tPhysics\tChemistry\tMath\tTotal\tPercentage\tGrade");
        for (int i = 0; i < students; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double percentage = total / 3.0;
            String grade = calculateGrade(percentage);

            System.out.println((i + 1) + "\t" + scores[i][0] + "\t" + scores[i][1] + "\t" + scores[i][2] + "\t" + total + "\t" + Math.round(percentage) + "%\t" + grade);
        }
    }
}