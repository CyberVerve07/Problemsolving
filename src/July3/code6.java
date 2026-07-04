package July3;

import java.util.Scanner;

public class code6 {

    public String accountHolder;
    public double balance;
    private int upiPin = 1289; // Default UPI PIN (e.g. 1289)

    // Constructor
    public code6(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Constructor to set custom UPI PIN
    public code6(String accountHolder, double balance, int upiPin) {
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.upiPin = upiPin;
    }

    // Helper method to verify UPI PIN (gives up to 3 attempts)
    private boolean verifyUPIPin() {
        Scanner sc = new Scanner(System.in);
        int attempts = 3;
        for (int i = 1; i <= attempts; i++) {
            System.out.print("Enter 4-digit UPI PIN (Attempt " + i + "/" + attempts + "): ");
            int enteredPin = sc.nextInt();
            if (enteredPin == this.upiPin) {
                System.out.println("UPI PIN Verified Successfully!");
                return true;
            } else {
                System.out.println("Incorrect UPI PIN!");
                if (i < attempts) {
                    System.out.println("Please try again.");
                }
            }
        }
        System.out.println("Transaction Declined! Too many incorrect PIN attempts.");
        return false;
    }

    // Deposit Money (UPI Credit - Doesn't require UPI PIN, just like real life)
    public void deposited(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("------ UPI TRANSACTION CREDIT ------");
            System.out.println("Account Holder: " + this.accountHolder);
            System.out.println("Successfully Credited: Rs. " + amount);
            System.out.println("Total Available Balance: Rs. " + this.balance);
            System.out.println("------------------------------------");
        } else {
            System.out.println("Deposit failed! Invalid amount (must be greater than 0).");
        }
    }

    // Withdrawal Money (UPI Debit - Requires UPI PIN)
    public void withdral(int amount) {
        withdral((double) amount);
    }

    public void withdral(double amount) {
        System.out.println("------ UPI TRANSACTION DEBIT (WITHDRAW) ------");
        if (amount <= 0) {
            System.out.println("Failed! Invalid withdrawal amount.");
            return;
        }
        if (amount > this.balance) {
            System.out.println("Failed! Insufficient balance. Available: Rs. " + this.balance);
            return;
        }

        // UPI authentication
        if (verifyUPIPin()) {
            this.balance -= amount;
            System.out.println("Successfully Debited: Rs. " + amount);
            System.out.println("Remaining Balance: Rs. " + this.balance);
        } else {
            System.out.println("Transaction Failed: UPI PIN authentication failed.");
        }
        System.out.println("----------------------------------------------");
    }

    // UPI Transfer/Pay to another user (Requires UPI PIN)
    public void transfer(code6 recipient, double amount) {
        System.out.println("------ UPI SEND MONEY ------");
        System.out.println("Paying Rs. " + amount + " to " + recipient.accountHolder + "...");
        
        if (amount <= 0) {
            System.out.println("Failed! Invalid amount.");
            return;
        }
        if (amount > this.balance) {
            System.out.println("Failed! Insufficient balance. Available: Rs. " + this.balance);
            return;
        }

        // UPI authentication
        if (verifyUPIPin()) {
            this.balance -= amount;
            recipient.balance += amount;
            System.out.println("Payment Successful!");
            System.out.println("Debited from your account: Rs. " + amount);
            System.out.println("Credited to " + recipient.accountHolder + "'s account.");
            System.out.println("Your Remaining Balance: Rs. " + this.balance);
        } else {
            System.out.println("Transaction Failed: UPI PIN authentication failed.");
        }
        System.out.println("----------------------------");
    }

    // Check Balance (Requires UPI PIN, just like Google Pay / PhonePe)
    public void display() {
        System.out.println("------ UPI BALANCE INQUIRY ------");
        if (verifyUPIPin()) {
            System.out.println("Account Holder: " + this.accountHolder);
            System.out.println("Available Balance: Rs. " + this.balance);
        } else {
            System.out.println("Failed to fetch balance: UPI PIN authentication failed.");
        }
        System.out.println("---------------------------------");
    }

    // Overloaded display with integer pin (for backward compatibility if needed)
    public void display(int pin) {
        System.out.println("------ UPI BALANCE INQUIRY ------");
        if (pin == this.upiPin) {
            System.out.println("Account Holder: " + this.accountHolder);
            System.out.println("Available Balance: Rs. " + this.balance);
        } else {
            System.out.println("Incorrect PIN parameter. Initiating standard verification...");
            if (verifyUPIPin()) {
                System.out.println("Account Holder: " + this.accountHolder);
                System.out.println("Available Balance: Rs. " + this.balance);
            }
        }
        System.out.println("---------------------------------");
    }
}
