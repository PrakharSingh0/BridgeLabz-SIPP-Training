import java.util.Scanner;

public class ArrayIndexExceptionExample {
    public static void generateException(String[] arr, int index) {
        System.out.println(arr[index]); // This will throw exception
    }

    public static void handleException(String[] arr, int index) {
        try {
            System.out.println(arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException handled: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = {"Alice", "Bob", "Charlie"};
        System.out.print("Enter index: ");
        int index = scanner.nextInt();

        generateException(names, index);
        handleException(names, index);

        scanner.close();
    }
}