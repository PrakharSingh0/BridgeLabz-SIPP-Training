import java.util.Scanner;

class Book {
    String title;
    String author;
    double price;

    void inputDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Title: ");
        title = scanner.nextLine();
        System.out.print("Enter Author: ");
        author = scanner.nextLine();
        System.out.print("Enter Price: ");
        price = scanner.nextDouble();
    }

    void displayDetails() {
        System.out.println("\nBook Details:");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        Book b = new Book();
        b.inputDetails();
        b.displayDetails();
    }
}