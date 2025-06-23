import java.util.Scanner;

class Item {
    int itemCode;
    String itemName;
    double price;

    void inputDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Item Code: ");
        itemCode = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter Item Name: ");
        itemName = scanner.nextLine();
        System.out.print("Enter Price: ");
        price = scanner.nextDouble();
    }

    void displayDetails(int quantity) {
        System.out.println("\nItem Details:");
        System.out.println("Code: " + itemCode);
        System.out.println("Name: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Total Cost for " + quantity + " units: " + (price * quantity));
    }

    public static void main(String[] args) {
        Item item = new Item();
        Scanner scanner = new Scanner(System.in);
        item.inputDetails();
        System.out.print("Enter quantity: ");
        int qty = scanner.nextInt();
        item.displayDetails(qty);
    }
}