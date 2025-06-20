import java.util.Scanner;

public class BMICalculator {
    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightInMeters = data[i][1] / 100.0;
            data[i][2] = weight / (heightInMeters * heightInMeters);
        }
    }

    public static String[] classifyBMI(double[][] data) {
        String[] status = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];
            if (bmi < 18.5) status[i] = "Underweight";
            else if (bmi < 25) status[i] = "Normal";
            else if (bmi < 30) status[i] = "Overweight";
            else status[i] = "Obese";
        }
        return status;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] team = new double[10][3]; // weight, height, BMI
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for member " + (i + 1) + ": ");
            team[i][0] = input.nextDouble();
            System.out.print("Enter height (cm) for member " + (i + 1) + ": ");
            team[i][1] = input.nextDouble();
        }
        calculateBMI(team);
        String[] status = classifyBMI(team);

        System.out.println("\nMember\tWeight\tHeight\tBMI\t\tStatus");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d\t%.1f\t%.1f\t%.2f\t%s\n", i + 1, team[i][0], team[i][1], team[i][2], status[i]);
        }
        input.close();
    }
}