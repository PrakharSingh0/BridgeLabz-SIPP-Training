class BankAccount {
    String accountNumber;
    double balance;

    BankAccount(String accNo, double balance) {
        this.accountNumber = accNo;
        this.balance = balance;
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accNo, double balance, double rate) {
        super(accNo, balance);
        this.interestRate = rate;
    }

    void displayAccountType() {
        System.out.println("Savings Account");
    }

    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("SAV123", 10000, 3.5);
        sa.displayAccountType();
    }
}