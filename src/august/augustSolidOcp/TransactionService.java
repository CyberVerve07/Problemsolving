package august.augustSolidOcp;

// Single Responsibility Principle (SRP):
// This class is responsible ONLY for handling financial operations (Deposit and Withdrawal).
public class TransactionService {

    public boolean deposit(Account account, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount: ₹" + amount);
            return false;
        }
        account.setBalance(account.getBalance() + amount);
        System.out.println("Successfully deposited ₹" + amount + " to Account: " + account.getAccountId());
        return true;
    }

    public boolean withdraw(Account account, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount: ₹" + amount);
            return false;
        }
        if (account.getBalance() < amount) {
            System.out.println("Insufficient balance! Current Balance: ₹" + account.getBalance() + ", Attempted Withdrawal: ₹" + amount);
            return false;
        }
        account.setBalance(account.getBalance() - amount);
        System.out.println("Successfully withdrew ₹" + amount + " from Account: " + account.getAccountId());
        return true;
    }
}
