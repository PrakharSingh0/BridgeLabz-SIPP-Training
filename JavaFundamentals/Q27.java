import java.util.Scanner;

public class Q27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of side 1 in meters: ");
        double side1 = scanner.nextDouble();
        System.out.print("Enter the length of side 2 in meters: ");
        double side2 = scanner.nextDouble();
        System.out.print("Enter the length of side 3 in meters: ");
        double side3 = scanner.nextDouble();

        double perimeter = side1 + side2 + side3;

        double totalDistance = 5000;

        double rounds = totalDistance / perimeter;

        System.out.println("The total number of rounds the athlete must run is " + Math.ceil(rounds) + " to complete a 5 km run.");

        scanner.close();
    }
}