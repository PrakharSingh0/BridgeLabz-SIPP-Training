// Abstract class
abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;

    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public abstract int getLoanDuration();

    public void getItemDetails() {
        System.out.println("ID: " + itemId + ", Title: " + title + ", Author: " + author);
    }

    public int getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
}

// Interface
interface Reservable {
    void reserveItem(String memberName);
    boolean checkAvailability();
}

// Book class
class Book extends LibraryItem implements Reservable {
    private boolean isAvailable = true;

    public Book(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 21; // 3 weeks
    }

    @Override
    public void reserveItem(String memberName) {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(memberName + " reserved book: " + getTitle());
        } else {
            System.out.println("Book is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}

// Magazine class
class Magazine extends LibraryItem implements Reservable {
    private boolean isAvailable = true;

    public Magazine(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 1 week
    }

    @Override
    public void reserveItem(String memberName) {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(memberName + " reserved magazine: " + getTitle());
        } else {
            System.out.println("Magazine not available.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}

// DVD class
class DVD extends LibraryItem implements Reservable {
    private boolean isAvailable = true;

    public DVD(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 5; // 5 days
    }

    @Override
    public void reserveItem(String memberName) {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(memberName + " reserved DVD: " + getTitle());
        } else {
            System.out.println("DVD is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}

// Driver class
public class LibrarySystemss {
    public static void main(String[] args) {
        LibraryItem[] items = {
            new Book(101, "Java Essentials", "Sunil Sharma"),
            new Magazine(102, "Tech Monthly", "Editorial Board"),
            new DVD(103, "Inception", "Christopher Nolan")
        };

        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable r) {
                r.reserveItem("Prakhar");
                System.out.println("Available: " + r.checkAvailability());
            }
            System.out.println("----------------------------------");
        }
    }
}