public class TicketReservationSystem {

    class TicketNode {
        int ticketId;
        String customerName, movieName, seatNumber, bookingTime;
        TicketNode next;

        TicketNode(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
            this.next = null;
        }
    }

    private TicketNode head = null;
    private TicketNode tail = null;

    // Add ticket at end
    void addTicket(int id, String name, String movie, String seat, String time) {
        TicketNode newTicket = new TicketNode(id, name, movie, seat, time);
        if (head == null) {
            head = tail = newTicket;
            tail.next = head;
        } else {
            tail.next = newTicket;
            newTicket.next = head;
            tail = newTicket;
        }
        System.out.println("Ticket booked successfully for " + name);
    }

    // Remove ticket by ID
    void removeTicket(int id) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        TicketNode curr = head, prev = tail;
        boolean found = false;

        do {
            if (curr.ticketId == id) {
                found = true;
                break;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        if (!found) {
            System.out.println("Ticket ID not found.");
            return;
        }

        if (curr == head && curr == tail) { // Only one node
            head = tail = null;
        } else {
            if (curr == head) head = head.next;
            if (curr == tail) tail = prev;
            prev.next = curr.next;
        }

        System.out.println("Ticket ID " + id + " canceled.");
    }

    // Display all tickets
    void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        TicketNode temp = head;
        System.out.println("Booked Tickets:");
        do {
            printTicket(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by customer or movie
    void searchTicket(String keyword, boolean searchByCustomer) {
        if (head == null) {
            System.out.println("No tickets to search.");
            return;
        }

        boolean found = false;
        TicketNode temp = head;
        do {
            if ((searchByCustomer && temp.customerName.equalsIgnoreCase(keyword)) ||
                (!searchByCustomer && temp.movieName.equalsIgnoreCase(keyword))) {
                printTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tickets found for " + keyword);
        }
    }

    // Count tickets
    int totalTickets() {
        if (head == null) return 0;
        int count = 0;
        TicketNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }

    // Helper to print ticket
    void printTicket(TicketNode t) {
        System.out.println("ID: " + t.ticketId + ", Customer: " + t.customerName +
                ", Movie: " + t.movieName + ", Seat: " + t.seatNumber +
                ", Time: " + t.bookingTime);
    }

    public static void main(String[] args) {
        TicketReservationSystem trs = new TicketReservationSystem();

        trs.addTicket(101, "Anjali", "Oppenheimer", "A5", "7:30 PM");
        trs.addTicket(102, "Rahul", "Dune", "B3", "8:00 PM");
        trs.addTicket(103, "Vikram", "Oppenheimer", "C2", "7:30 PM");

        trs.displayTickets();

        System.out.println("\nSearching tickets for 'Oppenheimer':");
        trs.searchTicket("Oppenheimer", false);

        System.out.println("\nCanceling ticket with ID 102:");
        trs.removeTicket(102);
        trs.displayTickets();

        System.out.println("\nTotal tickets booked: " + trs.totalTickets());
    }
}