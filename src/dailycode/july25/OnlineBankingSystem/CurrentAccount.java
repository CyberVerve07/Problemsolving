package dailycode.july25.OnlineBankingSystem;

/**
 * INTERVIEW DEFINITION — Concrete Class Extending Abstract Class:
 * -----------------------------------------------------------------
 * Q: What is a Concrete Class?
 * A: A concrete class is a regular class that provides implementation for ALL abstract
 *    methods inherited from its parent abstract class. Unlike abstract classes, concrete
 *    classes CAN be instantiated using the 'new' keyword.
 *
 * Q: Why does CurrentAccount extend AccountManagement?
 * A: Because CurrentAccount IS-A type of Account. It inherits common behavior
 *    (deposit, checkBalance) and provides its OWN withdrawal logic (with overdraft support).
 *
 * KEY DIFFERENCE: CurrentAccount vs SavingsAccount:
 * → SavingsAccount: Requires minimum balance of ₹500, earns 7.5% interest.
 * → CurrentAccount: Supports overdraft up to ₹10,000, earns 0% interest.
 *
 * JAVA TYPE: class (concrete child class)
 * OOP PILLAR: Inheritance + Polymorphism (method overriding)
 *
 * @author Aditya
 * @version 2.0
 * @see AccountManagement
 * @see SavingsAccount
 */
public class CurrentAccount extends AccountManagement {

    /**
     * Overdraft limit — current account allows withdrawal beyond zero balance up to this limit.
     *
     * INTERVIEW: What is 'private static final'?
     * → 'private' = accessible ONLY within this class.
     * → 'static'  = shared across all CurrentAccount instances (class-level constant).
     * → 'final'   = value cannot be changed (immutable).
     * → This is the Java way of defining CONSTANTS.
     */
    private static final double OVERDRAFT_LIMIT = 10000.0;

    /**
     * Constructor — initializes current account using parent constructor via super().
     *
     * @param accountHolderName String — name of the account holder
     * @param accountNumber     String — unique account number
     * @param balance           double — initial deposit amount
     */
    public CurrentAccount(String accountHolderName, String accountNumber, double balance) {
        super(accountHolderName, accountNumber, balance);
    }

    /**
     * Withdraws money with overdraft support — allows balance to go negative up to ₹10,000.
     *
     * INTERVIEW: What is Runtime Polymorphism?
     * → When the JVM decides at RUNTIME which version of an overridden method to call.
     * → Example: AccountManagement ref = new CurrentAccount(...);
     *   ref.withdrawal(500); → calls CurrentAccount's withdrawal, NOT AccountManagement's.
     * → Also called Dynamic Method Dispatch.
     *
     * @param amount double — the amount to withdraw
     */
    @Override
    void withdrawal(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount! Amount must be positive.");
        } else if (getBalance() - amount >= -OVERDRAFT_LIMIT) {
            // Current account supports overdraft up to ₹10,000
            setBalance(getBalance() - amount);
            System.out.println("Withdrawal Successful!");
            System.out.println("Remaining Balance: ₹" + getBalance());
            if (getBalance() < 0) {
                System.out.println("⚠ Warning: Account is in overdraft! Overdraft used: ₹" + Math.abs(getBalance()));
            }
        } else {
            System.out.println("Withdrawal Failed! Overdraft limit of ₹" + OVERDRAFT_LIMIT + " exceeded.");
        }
    }

    /**
     * @return String — "Current Account"
     */
    @Override
    String accountType() {
        return "Current Account";
    }

    /**
     * Current accounts typically earn NO interest.
     *
     * FIX: Renamed from 'CalcIntrest()' → 'calculateInterest()'.
     *
     * @return double — always returns 0.0
     */
    @Override
    double calculateInterest() {
        return 0.0;
    }
}
