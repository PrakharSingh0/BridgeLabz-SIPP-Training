import java.util.Scanner;

public class WindChillCalculator {
    public static double calculateWindChill(double temperature, double windSpeed) {
        return 35.74 + 0.6215 * temperature 
               - 35.75 * Math.pow(windSpeed, 0.16) 
               + 0.4275 * temperature * Math.pow(windSpeed, 0.16);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter temperature in Fahrenheit: ");
        double temp = input.nextDouble();
        System.out.print("Enter wind speed in mph: ");
        double wind = input.nextDouble();
        double result = calculateWindChill(temp, wind);
        System.out.println("The wind chill temperature is " + result + "°F");
        input.close();
    }
}