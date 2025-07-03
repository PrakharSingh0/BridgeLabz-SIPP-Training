public class MovieManagementSystem {

    // Node class
    class MovieNode {
        String title, director;
        int year;
        double rating;
        MovieNode next, prev;

        MovieNode(String title, String director, int year, double rating) {
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
            this.next = this.prev = null;
        }
    }

    // Doubly linked list pointers
    MovieNode head = null, tail = null;

    // Add movie at beginning
    void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newMovie = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add movie at end
    void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newMovie = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add movie at a given position
    void addAtPosition(String title, String director, int year, double rating, int pos) {
        if (pos <= 0 || head == null) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        MovieNode curr = head;
        for (int i = 1; i < pos && curr.next != null; i++) {
            curr = curr.next;
        }

        MovieNode newMovie = new MovieNode(title, director, year, rating);
        newMovie.next = curr.next;
        newMovie.prev = curr;

        if (curr.next != null) curr.next.prev = newMovie;
        curr.next = newMovie;

        if (newMovie.next == null) tail = newMovie;
    }

    // Remove movie by title
    void removeByTitle(String title) {
        MovieNode curr = head;
        while (curr != null && !curr.title.equalsIgnoreCase(title)) {
            curr = curr.next;
        }

        if (curr == null) {
            System.out.println(" Movie not found: " + title);
            return;
        }

        if (curr == head) head = curr.next;
        if (curr == tail) tail = curr.prev;
        if (curr.prev != null) curr.prev.next = curr.next;
        if (curr.next != null) curr.next.prev = curr.prev;

        System.out.println(" Movie removed: " + title);
    }

    // Search by director
    void searchByDirector(String director) {
        MovieNode curr = head;
        boolean found = false;
        while (curr != null) {
            if (curr.director.equalsIgnoreCase(director)) {
                printMovie(curr);
                found = true;
            }
            curr = curr.next;
        }
        if (!found) System.out.println("No movies found for director: " + director);
    }

    // Search by rating
    void searchByRating(double rating) {
        MovieNode curr = head;
        boolean found = false;
        while (curr != null) {
            if (curr.rating == rating) {
                printMovie(curr);
                found = true;
            }
            curr = curr.next;
        }
        if (!found) System.out.println("No movies found with rating: " + rating);
    }

    // Display forward
    void displayForward() {
        System.out.println("Movies (Forward):");
        MovieNode curr = head;
        if (curr == null) {
            System.out.println("List is empty.");
            return;
        }
        while (curr != null) {
            printMovie(curr);
            curr = curr.next;
        }
    }

    // Display reverse
    void displayReverse() {
        System.out.println("Movies (Reverse):");
        MovieNode curr = tail;
        if (curr == null) {
            System.out.println("List is empty.");
            return;
        }
        while (curr != null) {
            printMovie(curr);
            curr = curr.prev;
        }
    }

    // Update movie rating by title
    void updateRating(String title, double newRating) {
        MovieNode curr = head;
        while (curr != null) {
            if (curr.title.equalsIgnoreCase(title)) {
                curr.rating = newRating;
                System.out.println(" Updated rating for: " + title);
                return;
            }
            curr = curr.next;
        }
        System.out.println(" Movie not found: " + title);
    }

    // Print a movie's info
    void printMovie(MovieNode m) {
        System.out.println( m.title + " | Director: " + m.director +
                " | Year: " + m.year + " | Rating: " + m.rating);
    }

    // Sample main method for demo
    public static void main(String[] args) {
        MovieManagementSystem mms = new MovieManagementSystem();

        mms.addAtBeginning("Inception", "Nolan", 2010, 8.8);
        mms.addAtEnd("Interstellar", "Nolan", 2014, 8.6);
        mms.addAtPosition("Avatar", "Cameron", 2009, 7.8, 1);
        mms.addAtEnd("The Matrix", "Wachowski", 1999, 8.7);

        mms.displayForward();
        System.out.println();

        mms.updateRating("Avatar", 8.0);
        mms.removeByTitle("The Matrix");

        System.out.println();
        mms.displayReverse();

        System.out.println();
        mms.searchByDirector("Nolan");
        System.out.println();
        mms.searchByRating(8.0);
    }
}