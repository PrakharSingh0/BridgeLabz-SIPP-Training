import java.util.Scanner;

class BankAccount {
    String accountHolder;
    int accountNumber;
    double balance;

    void inputDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Account Holder Name: ");
        accountHolder = sc.nextLine();
        System.out.print("Enter Account Number: ");
        accountNumber = sc.nextInt();
        System.out.print("Enter Initial Balance: ");
        balance = sc.nextDouble();
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        Scanner sc = new Scanner(System.in);
        acc.inputDetails();
        acc.deposit(5000);
        acc.withdraw(3000);
        acc.displayBalance();
    }
}