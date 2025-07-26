import java.util.*;

public class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>();
    private LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();

    public void addProduct(String name, double price) {
        productPrices.put(name, price);
    }

    public void addToCart(String name, int quantity) {
        if (!productPrices.containsKey(name)) {
            System.out.println("❌ Product not found: " + name);
            return;
        }
        cart.put(name, cart.getOrDefault(name, 0) + quantity);
    }

    public void viewCartInOrder() {
        System.out.println("🛒 Cart (Insertion Order):");
        for (String item : cart.keySet()) {
            System.out.printf("%s × %d @ ₹%.2f each\n", item, cart.get(item), productPrices.get(item));
        }
    }

    public void viewCartSortedByPrice() {
        System.out.println("\n💲 Cart (Sorted by Price):");
        TreeMap<Double, List<String>> sortedMap = new TreeMap<>();
        for (String item : cart.keySet()) {
            double price = productPrices.get(item);
            sortedMap.computeIfAbsent(price, k -> new ArrayList<>()).add(item);
        }

        for (Map.Entry<Double, List<String>> entry : sortedMap.entrySet()) {
            for (String item : entry.getValue()) {
                System.out.printf("%s × %d @ ₹%.2f\n", item, cart.get(item), entry.getKey());
            }
        }
    }

    public void viewTotal() {
        double total = 0;
        for (String item : cart.keySet()) {
            total += productPrices.get(item) * cart.get(item);
        }
        System.out.printf("\n🧾 Total Amount: ₹%.2f\n", total);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Pen", 10.0);
        cart.addProduct("Notebook", 40.0);
        cart.addProduct("Pencil", 5.0);
        cart.addProduct("Eraser", 3.0);
        cart.addProduct("Marker", 25.0);

        cart.addToCart("Pencil", 3);
        cart.addToCart("Notebook", 2);
        cart.addToCart("Eraser", 5);
        cart.addToCart("Pen", 4);
        cart.addToCart("Marker", 1);

        cart.viewCartInOrder();
        cart.viewCartSortedByPrice();
        cart.viewTotal();
    }
}