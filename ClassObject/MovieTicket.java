import java.util.Scanner;

class MovieTicket {
    String movieName;
    String seatNumber;
    double price;

    void bookTicket() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Movie Name: ");
        movieName = sc.nextLine();
        System.out.print("Enter Seat Number: ");
        seatNumber = sc.nextLine();
        System.out.print("Enter Ticket Price: ");
        price = sc.nextDouble();
    }

    void displayTicket() {
        System.out.println("\nMovie Ticket Details:");
        System.out.println("Movie: " + movieName);
        System.out.println("Seat: " + seatNumber);
        System.out.println("Price: ₹" + price);
    }

    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket();
        ticket.bookTicket();
        ticket.displayTicket();
    }
}