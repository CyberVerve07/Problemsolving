package august.augustSolidOcp;

// Single Responsibility Principle (SRP): 
// This class is responsible ONLY for holding account data state (Model).
public class Account {
    private String accountId;
    private String accountHolderName;
    private double balance;

    public Account(String accountId, String accountHolderName, double balance) {
        this.accountId = accountId;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
