import java.util.Scanner;

public class NestedTryCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter array size: ");
            int size = scanner.nextInt();
            int[] array = new int[size];
            
            System.out.println("Enter array elements:");
            for (int i = 0; i < size; i++) {
                array[i] = scanner.nextInt();
            }
            
            System.out.print("Enter index to access: ");
            int index = scanner.nextInt();
            
            System.out.print("Enter divisor: ");
            int divisor = scanner.nextInt();
            
            try {
                int value = array[index];
                int result = value / divisor;
                System.out.println("Result: " + result);
                
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}