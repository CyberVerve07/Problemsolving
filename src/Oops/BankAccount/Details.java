package BankAccount;

public class Details {
    private String name;
    private double balance;
    private long accountNumber;

    // Constructor to initialize default or specific values
    public Details() {
        this.balance = 0.0;
    }

    public Details(String name, long accountNumber, double initialBalance) {
        this.name = name;
        this.accountNumber = accountNumber;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0.0;
        }
    }

    // Encapsulated methods for deposit and withdrawal
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Your Balance has been updated. Current Balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful! Remaining Balance: " + balance);
        } else if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else {
            System.out.println("Insufficient balance. Transaction failed.");
        }
    }

    // Getters and Setters for private fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }
}