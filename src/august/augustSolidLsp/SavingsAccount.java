package august.augustSolidLsp;

/**
 * Concrete class representing a Savings Account.
 * Implements WithdrawableAccount as savings accounts allow withdrawals.
 */
public class SavingsAccount implements WithdrawableAccount {

    private final String accountNumber;
    private final String accountHolderName;
    private double balance;

    public SavingsAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
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
            System.out.println("[SavingsAccount] Deposit amount must be positive!");
            return;
        }
        balance += amount;
        System.out.println("[SavingsAccount] Deposited ₹" + amount + " | New Balance: ₹" + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("[SavingsAccount] Invalid withdrawal amount!");
            return;
        }
        if (amount > balance) {
            System.out.println("[SavingsAccount] Insufficient funds! Current Balance: ₹" + balance);
            return;
        }
        balance -= amount;
        System.out.println("[SavingsAccount] Withdrew ₹" + amount + " | Remaining Balance: ₹" + balance);
    }
}
