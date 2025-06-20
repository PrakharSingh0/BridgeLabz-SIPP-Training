import java.util.Scanner;

public class SimpleInterestCalculator {
    public static double calculateSI(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Principal: ");
        double p = input.nextDouble();
        System.out.print("Enter Rate (%): ");
        double r = input.nextDouble();
        System.out.print("Enter Time (years): ");
        double t = input.nextDouble();
        double si = calculateSI(p, r, t);
        System.out.println("The Simple Interest is " + si + " for Principal " + p + ", Rate of Interest " + r + "% and Time " + t + " years.");
        input.close();
    }
}