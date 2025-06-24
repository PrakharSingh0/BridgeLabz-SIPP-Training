class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    public void displayAccount() {
        System.out.println("Savings Account: " + accountHolder + ", Number: " + accountNumber + ", Balance: ₹" + getBalance());
    }

    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("SB123456", "Rohit Verma", 10000);
        sa.deposit(2000);
        sa.withdraw(1500);
        sa.displayAccount();
    }
}