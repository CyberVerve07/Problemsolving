package august.augustSolidLsp;

/**
 * Concrete class representing a Current Account.
 * Implements WithdrawableAccount and supports overdraft capability up to a limit.
 */
public class CurrentAccount implements WithdrawableAccount {

    private final String accountNumber;
    private final String accountHolderName;
    private double balance;
    private final double overdraftLimit;

    public CurrentAccount(String accountNumber, String accountHolderName, double initialBalance, double overdraftLimit) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String getAccountHolderName() {
        return accountHolderName;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("[CurrentAccount] Deposit amount must be positive!");
            return;
        }
        balance += amount;
        System.out.println("[CurrentAccount] Deposited " + amount + " | New Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("[CurrentAccount] Invalid withdrawal amount!");
            return;
        }
        if (balance - amount < -overdraftLimit) {
            System.out.println("[CurrentAccount] Overdraft limit exceeded! Limit: " + overdraftLimit);
            return;
        }
        balance -= amount;
        System.out.println("[CurrentAccount] Withdrew " + amount + " | Remaining Balance: " + balance);
    }
}
