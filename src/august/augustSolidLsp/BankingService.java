package august.augustSolidLsp;

/**
 * Service class for executing banking operations.
 * Demonstrates Liskov Substitution Principle (LSP) in practice.
 */
public class BankingService {

    /**
     * Accepts any WithdrawableAccount (SavingsAccount, CurrentAccount, etc.).
     * LSP Guarantee: Any subtype of WithdrawableAccount will perform withdrawal
     * safely without throwing unexpected errors or breaking contract assumptions.
     */
    public void processWithdrawal(WithdrawableAccount account, double amount) {
        System.out.println("\n--- Processing Withdrawal for " + account.getAccountHolderName() + " (" + account.getAccountNumber() + ") ---");
        account.withdraw(amount);
    }

    /**
     * Accepts any Account type (SavingsAccount, CurrentAccount, FixedDepositAccount).
     * Deposit operation is valid across ALL Account subtypes.
     */
    public void processDeposit(Account account, double amount) {
        System.out.println("\n--- Processing Deposit for " + account.getAccountHolderName() + " (" + account.getAccountNumber() + ") ---");
        account.deposit(amount);
    }
}
