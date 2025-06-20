import java.util.Scanner;

public class HandshakeMax {
    public static int maxHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int students = input.nextInt();
        int handshakes = maxHandshakes(students);
        System.out.println("Maximum possible handshakes: " + handshakes);
        input.close();
    }
}