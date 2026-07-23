package dailycode.july22.PaymentGateway;

import java.util.Scanner;

public abstract class PaymentGateway {

    private String accountHolderName;
    private String accountNumber;
    private double balance;

    // Bug Fix: Default constructor initializes balance to 0
    public PaymentGateway() {
        this.balance = 0.0;
    }

    public PaymentGateway(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    // Bug Fix: 3-arg constructor was empty before — now properly sets all fields
    public PaymentGateway(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            System.out.println("Negative balance is not allowed");
            return;
        }
        this.balance = balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Methods for Deposit and Withdraw
    void deposit() {
        System.out.println("Enter the Amount to Deposit:");
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();
        balance = amount + balance;
        System.out.println("Your Account Balance after Deposit: ₹" + balance);
        System.out.println("=======================================");
    }

    double withdraw() {
        System.out.println("Enter the Amount to Withdraw:");
        Scanner sc = new Scanner(System.in);
        double widAmount = sc.nextDouble();
        if (widAmount <= balance) {
            System.out.println("Withdrawal Successful!");
            System.out.println("Amount Debited from Account. Available Balance is:");
            balance = balance - widAmount;
            System.out.println("₹" + balance);
        } else {
            System.out.println("Insufficient balance! Withdrawal not allowed.");
        }
        return widAmount;
    }

    //  New Feature: processPayment deducts paid amount from balance after payment
    public void processPayment(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid payment amount.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance! Payment of ₹" + amount + " failed.");
            return;
        }
        balance = balance - amount;
        System.out.println(" Payment of " + amount + " processed successfully.");
        System.out.println("Updated Balance: ₹" + balance);
        System.out.println("=======================================");
    }

    abstract void pay();

}

