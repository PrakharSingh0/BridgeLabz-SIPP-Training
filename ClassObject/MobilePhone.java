import java.util.Scanner;

class MobilePhone {
    String brand;
    String model;
    double price;

    void inputDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Brand: ");
        brand = scanner.nextLine();
        System.out.print("Enter Model: ");
        model = scanner.nextLine();
        System.out.print("Enter Price: ");
        price = scanner.nextDouble();
    }

    void displayDetails() {
        System.out.println("\nPhone Details:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        MobilePhone phone = new MobilePhone();
        phone.inputDetails();
        phone.displayDetails();
    }
}