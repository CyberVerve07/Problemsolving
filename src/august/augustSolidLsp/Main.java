package august.augustSolidLsp;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   SOLID Principles Demo: Liskov Substitution (LSP)");
        System.out.println("==================================================");

        BankingService bankingService = new BankingService();

        // 1. Create accounts
        WithdrawableAccount savingsAcc = new SavingsAccount("SA-101", "Aditya", 10000.0);
        WithdrawableAccount currentAcc = new CurrentAccount("CA-201", "Rahul", 5000.0, 2000.0);
        Account fdAcc = new FixedDepositAccount("FD-301", "Sneha", 50000.0, 7.5);

        // 2. Deposit works for ALL Account implementations (LSP preserved)
        bankingService.processDeposit(savingsAcc, 2000.0);
        bankingService.processDeposit(currentAcc, 3000.0);
        bankingService.processDeposit(fdAcc, 10000.0);

        // 3. Withdrawal works seamlessly for any WithdrawableAccount (LSP preserved)
        bankingService.processWithdrawal(savingsAcc, 3000.0);
        bankingService.processWithdrawal(currentAcc, 7000.0); // Uses overdraft limit

        // 4. Fixed Deposit specific operations
        System.out.println("\n--- FD Interest Application ---");
        if (fdAcc instanceof FixedDepositAccount) {
            ((FixedDepositAccount) fdAcc).applyInterest();
        }

        System.out.println("\n[LSP Summary]: Subtypes (SavingsAccount, CurrentAccount) substitute base contract");
        System.out.println("(WithdrawableAccount) without throwing UnsupportedOperationException or breaking expectations!");
    }
}
