import java.util.Scanner;

public class Q26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter from city: ");
        String fromCity = scanner.next();
        System.out.print("Enter via city: ");
        String viaCity = scanner.next();
        System.out.print("Enter destination city: ");
        String toCity = scanner.next();
        System.out.print("Enter distance from " + fromCity + " to " + viaCity + " in miles: ");
        double fromToVia = scanner.nextDouble();
        System.out.print("Enter distance from " + viaCity + " to " + toCity + " in miles: ");
        double viaToFinalCity = scanner.nextDouble();
        System.out.print("Enter time taken from " + fromCity + " to " + viaCity + " in minutes: ");
        double timeFromToVia = scanner.nextDouble();
        System.out.print("Enter time taken from " + viaCity + " to " + toCity + " in minutes: ");
        double timeViaToFinalCity = scanner.nextDouble();

        double totalDistanceKm = (fromToVia + viaToFinalCity) * 1.60934;
        double totalTimeMinutes = timeFromToVia + timeViaToFinalCity;

        System.out.println("The total distance traveled by " + name + " from " + fromCity + " to " + toCity + " via " + viaCity + " is " + totalDistanceKm + " km and the total time taken is " + totalTimeMinutes + " minutes.");

        scanner.close();
    }
}