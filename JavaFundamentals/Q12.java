import java.util.Scanner;

public class Q12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter base in cm: ");
        double base = scanner.nextDouble();
        System.out.print("Enter height in cm: ");
        double height = scanner.nextDouble();

        double areaCm = 0.5 * base * height;
        double areaInches = areaCm / (2.54 * 2.54);

        System.out.println("The Area of the triangle in sq in is " + areaInches + " and sq cm is " + areaCm);

        scanner.close();
    }
}