import java.util.Scanner;

class Circle {
    double radius;

    void inputDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Radius: ");
        radius = scanner.nextDouble();
    }

    double getArea() {
        return Math.PI * radius * radius;
    }

    double getCircumference() {
        return 2 * Math.PI * radius;
    }

    void displayDetails() {
        System.out.println("\nCircle Details:");
        System.out.println("Area: " + getArea());
        System.out.println("Circumference: " + getCircumference());
    }

    public static void main(String[] args) {
        Circle c = new Circle();
        c.inputDetails();
        c.displayDetails();
    }
}