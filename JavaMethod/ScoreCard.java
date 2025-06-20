import java.util.Random;

public class ScoreCard {
    public static int[][] generateScores(int students) {
        int[][] scores = new int[students][3];
        Random rand = new Random();
        for (int i = 0; i < students; i++) {
            scores[i][0] = 50 + rand.nextInt(50); // Physics
            scores[i][1] = 50 + rand.nextInt(50); // Chemistry
            scores[i][2] = 50 + rand.nextInt(50); // Math
        }
        return scores;
    }

    public static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double perc = (total / 300.0) * 100;
            results[i][0] = total;
            results[i][1] = Math.round(avg * 100.0) / 100.0;
            results[i][2] = Math.round(perc * 100.0) / 100.0;
        }
        return results;
    }

    public static void displayScorecard(int[][] scores, double[][] results) {
        System.out.println("Stud\tPhy\tChem\tMath\tTotal\tAvg\t%\n");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t%d\t%d\t%d\t%.0f\t%.2f\t%.2f\n", 
                i + 1, scores[i][0], scores[i][1], scores[i][2], 
                results[i][0], results[i][1], results[i][2]);
        }
    }

    public static void main(String[] args) {
        int[][] scores = generateScores(5);
        double[][] results = calculateResults(scores);
        displayScorecard(scores, results);
    }
}