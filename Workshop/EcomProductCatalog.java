import java.util.ArrayList;
import java.util.List;

class Product {
    String name;
    String category;
    double price;
    int stock;

    Product(String name, String category, double price, int stock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }
}

public class EcomProductCatalog {
    List<Product> products = new ArrayList<>();

    void addProduct(String name, String category, double price, int stock) {
        products.add(new Product(name, category, price, stock));
    }

    List<Product> searchByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.name.toLowerCase().contains(name.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }

    List<Product> searchByCategory(String category) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.category.toLowerCase().contains(category.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }

    void updateStock(String productName, int newStock) {
        for (Product p : products) {
            if (p.name.equalsIgnoreCase(productName)) {
                if (newStock < 0) {
                    System.out.println("Stock cannot be negative.");
                    return;
                }
                if (newStock > 1000) {
                    System.out.println("Stock exceeds maximum limit of 1000.");
                    return;
                }
                p.stock = newStock;
                System.out.println("Stock updated for " + productName);
                return;
            }
        }
        System.out.println("Product not found: " + productName);
    }

    void printReport(boolean ascending) {
        // Create a new sorted list to avoid modifying original
        List<Product> sortedProducts = new ArrayList<>(products);
        
        // Use Collections.sort with a custom comparator
        java.util.Collections.sort(sortedProducts, new java.util.Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                if (ascending) {
                    return Double.compare(p1.price, p2.price);
                } else {
                    return Double.compare(p2.price, p1.price);
                }
            }
        });

        // Print the report header
        System.out.println("\nProduct Catalog Report");
        System.out.println("Sorted by price: " + (ascending ? "Low to High" : "High to Low"));
        System.out.println("----------------------------------------");
        
        // Print each product with formatted output
        String format = "%-20s $%8.2f   Stock: %d";
        for (Product p : sortedProducts) {
            System.out.println(String.format(format, p.name, p.price, p.stock));
        }
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        EcomProductCatalog catalog = new EcomProductCatalog();

        catalog.addProduct("Laptop", "Electronics", 999.99, 50);
        catalog.addProduct("Smartphone", "Electronics", 599.99, 100);
        catalog.addProduct("Headphones", "Accessories", 99.99, 200);

        System.out.println("Search by category 'Electronics':");
        List<Product> electronics = catalog.searchByCategory("Electronics");
        for (Product p : electronics) {
            System.out.println(p.name + " - $" + p.price);
        }

        catalog.updateStock("Laptop", 45);
        catalog.updateStock("Laptop", -5);
        catalog.updateStock("NonExistent", 10);

        catalog.printReport(true);
        catalog.printReport(false);
    }
}

//8. E-commerce Product Catalog
//Scenario: Develop a program for managing an e-commerce product catalog. Each product has
//a name, category, price, and stock quantity. Implement:
//● A List to store the products as objects.
//● Methods to:
//○ Add a new product.
//○ Search for products by name or category.
//○ Update the stock of a product. Throw an exception if the stock is negative or
//exceeds a maximum limit.
//● Generate a report of all products sorted by price (ascending or descending).
//● Handle cases where a user tries to update or access a product that doesn't exist.
