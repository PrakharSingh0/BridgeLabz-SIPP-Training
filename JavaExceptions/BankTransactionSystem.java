import java.util.Scanner;

public class BankTransactionSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        BankAccount account = new BankAccount("123456789", 1000.0);
        
        try {
            System.out.println("Current balance: $" + account.getBalance());
            System.out.print("Enter withdrawal amount: $");
            double amount = scanner.nextDouble();
            
            account.withdraw(amount);
            System.out.println("Withdrawal successful, new balance: $" + account.getBalance());
            
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input!");
        } finally {
            scanner.close();
        }
    }
}