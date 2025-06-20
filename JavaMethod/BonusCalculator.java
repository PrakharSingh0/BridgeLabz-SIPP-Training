import java.util.Random;

public class BonusCalculator {
    public static int[][] generateSalariesAndService(int employees) {
        int[][] data = new int[employees][2];
        Random rand = new Random();
        for (int i = 0; i < employees; i++) {
            data[i][0] = 10000 + rand.nextInt(90000); // Salary
            data[i][1] = rand.nextInt(11);            // Years of service
        }
        return data;
    }

    public static double[][] calculateBonusAndNewSalary(int[][] data) {
        double[][] result = new double[data.length][2]; // bonus, new salary
        for (int i = 0; i < data.length; i++) {
            double bonusRate = data[i][1] > 5 ? 0.05 : 0.02;
            double bonus = data[i][0] * bonusRate;
            result[i][0] = bonus;
            result[i][1] = data[i][0] + bonus;
        }
        return result;
    }

    public static void displaySummary(int[][] data, double[][] result) {
        double totalOld = 0, totalNew = 0, totalBonus = 0;
        System.out.println("Emp\tSalary\tYears\tBonus\tNew Salary");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d\t%d\t%d\t%.2f\t%.2f\n", i + 1, data[i][0], data[i][1], result[i][0], result[i][1]);
            totalOld += data[i][0];
            totalNew += result[i][1];
            totalBonus += result[i][0];
        }
        System.out.println("\nTotal Old Salary: " + totalOld);
        System.out.println("Total New Salary: " + totalNew);
        System.out.println("Total Bonus Paid: " + totalBonus);
    }

    public static void main(String[] args) {
        int[][] employees = generateSalariesAndService(10);
        double[][] bonuses = calculateBonusAndNewSalary(employees);
        displaySummary(employees, bonuses);
    }
}