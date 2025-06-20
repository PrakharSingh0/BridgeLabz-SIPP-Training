import java.util.Scanner;

public class AthleteRun {
    public static int calculateRounds(double a, double b, double c) {
        double perimeter = a + b + c;
        return (int)(5000 / perimeter);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter side 1 (in meters): ");
        double side1 = input.nextDouble();
        System.out.print("Enter side 2: ");
        double side2 = input.nextDouble();
        System.out.print("Enter side 3: ");
        double side3 = input.nextDouble();

        int rounds = calculateRounds(side1, side2, side3);
        System.out.println("Rounds needed to complete 5 km: " + rounds);
        input.close();
    }
}