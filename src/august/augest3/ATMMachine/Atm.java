package august.augest3.ATMMachine;

public class Atm {

    private String accountHolderName;
    private String accountNumber;
    private double balance;

    // Constructor
    public Atm(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getters
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Withdraw Method
    public void withdraw(double amount) {

        System.out.println("\nProcessing Withdrawal...");

        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than 0.");
            return;
        }

        if (amount <= balance) {
            balance = balance - amount;

            System.out.println("Withdrawal Successful.");
            System.out.println("Withdrawn Amount : " + amount);
            System.out.println("Remaining Balance : " + balance);
        } else {
            System.out.println("Insufficient Balance.");
        }
    }

    // Deposit Method
    public void deposit(double amount) {

        System.out.println("\nProcessing Deposit...");

        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than 0.");
            return;
        }

        balance = balance + amount;

        System.out.println("Deposit Successful.");
        System.out.println("Deposited Amount : " + amount);
        System.out.println("Current Balance : " + balance);
    }

    // Account Details
    public void showAccountDetails() {

        System.out.println("\n========== ACCOUNT DETAILS ==========");
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Balance        : " + balance);
        System.out.println("=====================================");
    }
}