package oops.phonepay;

/**
 * User — Model representing a PhonePe User.
 */
public class User {
    private String userName;
    private double balance;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
            System.out.println("Transaction complete. Current balance: " + balance);
        } else {
            System.out.println("Low balance or invalid amount. Payment failed.");
        }
    }

    public boolean login(String username) {
        return this.userName != null && this.userName.equals(username);
    }
}
