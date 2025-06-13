import java.util.Scanner;

public class Q17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the unit price of the item: ");
        double unitPrice = scanner.nextDouble();
        System.out.print("Enter the quantity to be bought: ");
        int quantity = scanner.nextInt();

        double totalPrice = unitPrice * quantity;

        System.out.println("The total purchase price is INR " + totalPrice + " if the quantity " + quantity + " and the unit price is INR " + unitPrice);

        scanner.close();
    }
}