package august.augustSolidOcp;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SOLID Principles Demo: SRP + OCP ===");

        // 1. Create Account (Data State)
        Account userAccount = new Account("ACC-1001", "Aditya Kumar", 10000.0);

        // 2. SRP - Printing initial account state
        AccountPrinter printer = new AccountPrinter();
        printer.printAccountDetails(userAccount);

        // 3. SRP - Deposit and Withdrawal Operations
        TransactionService txService = new TransactionService();

        System.out.println("\n--- Performing Transactions ---");
        txService.deposit(userAccount, 5000.0);  // Balance: 15000
        txService.withdraw(userAccount, 3000.0); // Balance: 12000
        txService.withdraw(userAccount, 20000.0); // Failed withdrawal (insufficient balance)

        // Print updated balance
        System.out.println("\n--- Updated Account Details ---");
        printer.printAccountDetails(userAccount);

        // 4. OCP - Interest Calculation (Open for Extension, Closed for Modification)
        System.out.println("\n--- OCP Demo: Calculating Interest ---");
        InterestService interestService = new InterestService();

        // Calculate Savings Interest (4%)
        System.out.print("Savings Interest: ");
        interestService.computeInterest(userAccount, new SavingsInterestCalculator());

        // Calculate Fixed Deposit Interest (7.5%)
        System.out.print("Fixed Deposit Interest: ");
        interestService.computeInterest(userAccount, new FixedDepositInterestCalculator());
    }
}
