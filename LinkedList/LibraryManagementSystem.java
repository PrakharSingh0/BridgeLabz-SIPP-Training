public class LibraryManagementSystem {

    class BookNode {
        String title, author, genre;
        int bookId;
        boolean isAvailable;
        BookNode prev, next;

        BookNode(String title, String author, String genre, int bookId, boolean isAvailable) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.bookId = bookId;
            this.isAvailable = isAvailable;
            this.prev = this.next = null;
        }
    }

    private BookNode head = null, tail = null;

    // Add at beginning
    void addAtBeginning(String title, String author, String genre, int id, boolean available) {
        BookNode newNode = new BookNode(title, author, genre, id, available);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add at end
    void addAtEnd(String title, String author, String genre, int id, boolean available) {
        BookNode newNode = new BookNode(title, author, genre, id, available);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add at position
    void addAtPosition(String title, String author, String genre, int id, boolean available, int pos) {
        if (pos <= 0 || head == null) {
            addAtBeginning(title, author, genre, id, available);
            return;
        }

        BookNode curr = head;
        for (int i = 1; i < pos && curr.next != null; i++) {
            curr = curr.next;
        }

        BookNode newNode = new BookNode(title, author, genre, id, available);
        newNode.next = curr.next;
        newNode.prev = curr;

        if (curr.next != null) curr.next.prev = newNode;
        curr.next = newNode;

        if (newNode.next == null) tail = newNode;
    }

    // Remove by Book ID
    void removeById(int id) {
        BookNode curr = head;
        while (curr != null && curr.bookId != id) {
            curr = curr.next;
        }
        if (curr == null) {
            System.out.println("Book not found with ID: " + id);
            return;
        }

        if (curr == head) head = curr.next;
        if (curr == tail) tail = curr.prev;
        if (curr.prev != null) curr.prev.next = curr.next;
        if (curr.next != null) curr.next.prev = curr.prev;

        System.out.println("Removed book: " + curr.title);
    }

    // Search by title
    void searchByTitle(String title) {
        BookNode curr = head;
        boolean found = false;
        while (curr != null) {
            if (curr.title.equalsIgnoreCase(title)) {
                printBook(curr);
                found = true;
            }
            curr = curr.next;
        }
        if (!found) System.out.println("No books found with title: " + title);
    }

    // Search by author
    void searchByAuthor(String author) {
        BookNode curr = head;
        boolean found = false;
        while (curr != null) {
            if (curr.author.equalsIgnoreCase(author)) {
                printBook(curr);
                found = true;
            }
            curr = curr.next;
        }
        if (!found) System.out.println("No books found by author: " + author);
    }

    // Update availability
    void updateAvailability(int id, boolean newStatus) {
        BookNode curr = head;
        while (curr != null) {
            if (curr.bookId == id) {
                curr.isAvailable = newStatus;
                System.out.println("Updated availability for book: " + curr.title);
                return;
            }
            curr = curr.next;
        }
        System.out.println("Book ID not found.");
    }

    // Display forward
    void displayForward() {
        System.out.println("Books in library (Forward):");
        BookNode curr = head;
        while (curr != null) {
            printBook(curr);
            curr = curr.next;
        }
    }

    // Display reverse
    void displayReverse() {
        System.out.println("Books in library (Reverse):");
        BookNode curr = tail;
        while (curr != null) {
            printBook(curr);
            curr = curr.prev;
        }
    }

    // Count total books
    int countBooks() {
        int count = 0;
        BookNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    // Print book details
    void printBook(BookNode b) {
        System.out.println("ID: " + b.bookId + ", Title: " + b.title + ", Author: " + b.author +
                ", Genre: " + b.genre + ", Available: " + (b.isAvailable ? "Yes" : "No"));
    }

    public static void main(String[] args) {
        LibraryManagementSystem lib = new LibraryManagementSystem();

        lib.addAtBeginning("1984", "Orwell", "Dystopian", 1, true);
        lib.addAtEnd("The Hobbit", "Tolkien", "Fantasy", 2, false);
        lib.addAtPosition("A Brief History of Time", "Hawking", "Science", 3, true, 1);

        lib.displayForward();
        System.out.println();

        lib.searchByAuthor("Tolkien");
        lib.searchByTitle("1984");

        lib.updateAvailability(2, true);
        lib.removeById(1);

        System.out.println();
        lib.displayReverse();

        System.out.println("\nTotal books in library: " + lib.countBooks());
    }
}