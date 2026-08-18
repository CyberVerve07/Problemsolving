package august.augustSolidLsp;

/**
 * Concrete class representing a Fixed Deposit Account.
 * 
 * Notice: FixedDepositAccount implements `Account`, NOT `WithdrawableAccount`.
 * Fixed deposits locked for a term cannot be withdrawn arbitrary via a withdraw() method.
 * 
 * WHY THIS HONORS LISKOV SUBSTITUTION PRINCIPLE (LSP):
 * If FixedDepositAccount had extended an Account class containing a withdraw() method
 * and thrown `new UnsupportedOperationException("Withdrawal not allowed on FD")`,
 * it would VIOLATE LSP because substituting FDAccount where Account.withdraw() was expected
 * would crash the program.
 * 
 * By separating `WithdrawableAccount` from `Account`, FDAccount only promises what it can fulfill!
 */
public class FixedDepositAccount implements Account {

    private final String accountNumber;
    private final String accountHolderName;
    private double balance;
    private final double interestRate;

    public FixedDepositAccount(String accountNumber, String accountHolderName, double initialDeposit, double interestRate) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
        this.interestRate = interestRate;
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
            System.out.println("[FixedDepositAccount] Deposit amount must be positive!");
            return;
        }
        balance += amount;
        System.out.println("[FixedDepositAccount] Deposited ₹" + amount + " to FD | Total FD Amount: ₹" + balance);
    }

    public void applyInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.println("[FixedDepositAccount] Interest of ₹" + interest + " applied (" + interestRate + "%). New FD Balance: ₹" + balance);
    }
}
