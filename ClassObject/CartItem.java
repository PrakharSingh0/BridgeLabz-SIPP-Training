import java.util.Scanner;

class CartItem {
    String itemName;
    double price;
    int quantity;

    void addItem() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Item Name: ");
        itemName = sc.nextLine();
        System.out.print("Enter Price: ");
        price = sc.nextDouble();
        System.out.print("Enter Quantity: ");
        quantity = sc.nextInt();
    }

    void removeItem() {
        System.out.println("Removing item: " + itemName);
        itemName = "";
        price = 0;
        quantity = 0;
    }

    void displayTotalCost() {
        System.out.println("\nCart Summary:");
        System.out.println("Item: " + itemName);
        System.out.println("Price per unit: ₹" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: ₹" + (price * quantity));
    }

    public static void main(String[] args) {
        CartItem cart = new CartItem();
        cart.addItem();
        cart.displayTotalCost();
        cart.removeItem();
    }
}