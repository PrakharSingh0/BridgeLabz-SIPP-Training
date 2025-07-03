// Abstract Class
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: ₹" + price + ", Qty: " + quantity);
    }

    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
}

// Interface
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

// VegItem
class VegItem extends FoodItem implements Discountable {
    public VegItem(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity(); // no surcharge
    }

    @Override
    public double applyDiscount() {
        return 0.10 * calculateTotalPrice(); // 10% discount
    }

    @Override
    public String getDiscountDetails() {
        return "Veg Discount: 10%";
    }
}

// NonVegItem
class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + 30; // ₹30 surcharge
    }

    @Override
    public double applyDiscount() {
        return 0.05 * calculateTotalPrice(); // 5% discount
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg Discount: 5%";
    }
}

// Driver Class
public class FoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem[] order = {
            new VegItem("Paneer Tikka", 180, 2),
            new NonVegItem("Chicken Biryani", 250, 1)
        };

        for (FoodItem item : order) {
            item.getItemDetails();
            double gross = item.calculateTotalPrice();

            if (item instanceof Discountable d) {
                double discount = d.applyDiscount();
                double finalPrice = gross - discount;
                System.out.println("Gross Price: ₹" + gross);
                System.out.println("Discount: ₹" + discount);
                System.out.println(d.getDiscountDetails());
                System.out.println("Final Price: ₹" + finalPrice);
            }

            System.out.println("------------------------------");
        }
    }
}