// Abstract class
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public abstract double calculateDiscount();

    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }
}

// Interface
interface Taxable {
    double calculateTax();
    void getTaxDetails();
}

// Electronics class
class Electronics extends Product implements Taxable {
    public Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.1; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% GST
    }

    @Override
    public void getTaxDetails() {
        System.out.println("Electronics GST: 18%");
    }
}

// Clothing class
class Clothing extends Product implements Taxable {
    public Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.2; // 20% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.12; // 12% GST
    }

    @Override
    public void getTaxDetails() {
        System.out.println("Clothing GST: 12%");
    }
}

// Groceries (no tax)
class Groceries extends Product {
    public Groceries(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}

// Main class
public class ECommercePlatform {
    public static void main(String[] args) {
        Product[] cart = {
            new Electronics(101, "Laptop", 50000),
            new Clothing(102, "T-Shirt", 1000),
            new Groceries(103, "Rice", 800)
        };

        for (Product p : cart) {
            double tax = (p instanceof Taxable t) ? t.calculateTax() : 0;
            double discount = p.calculateDiscount();
            double finalPrice = p.getPrice() + tax - discount;

            System.out.println("Product: " + p.getName());
            System.out.println("Original Price: ₹" + p.getPrice());
            System.out.println("Discount: ₹" + discount);
            System.out.println("Tax: ₹" + tax);
            System.out.println("Final Price: ₹" + finalPrice);
            if (p instanceof Taxable t) t.getTaxDetails();
            System.out.println();
        }
    }
}