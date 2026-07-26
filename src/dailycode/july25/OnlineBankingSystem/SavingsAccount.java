package dailycode.july25.OnlineBankingSystem;

/**
 * INTERVIEW DEFINITION — Inheritance (extends keyword):
 * -------------------------------------------------------
 * Q: What is Inheritance?
 * A: Inheritance is an OOP mechanism where a child class (SavingsAccount) acquires all
 *    the properties (fields) and behaviors (methods) of a parent class (AccountManagement).
 *    It is achieved using the 'extends' keyword.
 *
 * Q: Why do we use Inheritance?
 * A: 1. CODE REUSABILITY — SavingsAccount reuses depositMoney(), checkBalance() from parent.
 *    2. IS-A RELATIONSHIP — SavingsAccount IS-A type of AccountManagement.
 *    3. METHOD OVERRIDING — Child can provide its own version of parent's method.
 *    4. POLYMORPHISM — Parent reference can hold child object (Upcasting).
 *
 * Q: What is the 'extends' keyword?
 * A: 'extends' is used to create a child class that inherits from a parent class.
 *    Java supports SINGLE inheritance only (one class can extend only ONE class).
 *
 * Q: What is the 'super' keyword?
 * A: 'super' refers to the PARENT class object.
 *    - super() → calls parent constructor (must be FIRST statement in child constructor).
 *    - super.method() → calls parent's version of an overridden method.
 *
 * JAVA TYPE: class (concrete class extending abstract class)
 * OOP PILLAR: Inheritance + Abstraction (implementing abstract methods)
 *
 * @author Aditya
 * @version 2.0
 * @see AccountManagement
 */
public class SavingsAccount extends AccountManagement {

    /**
     * Minimum balance that must be maintained in a savings account.
     *
     * INTERVIEW: What is 'static final'?
     * → 'static' = belongs to the CLASS, not to any instance.
     * → 'final' = value CANNOT be changed after initialization (constant).
     * → Convention: Constants use UPPER_SNAKE_CASE.
     */
    private static final double MINIMUM_BALANCE = 500.0;

    /**
     * Constructor — uses 'super()' to call the parent class constructor.
     *
     * INTERVIEW: What is Constructor Chaining?
     * → When a child constructor calls the parent constructor using super().
     * → super() MUST be the FIRST statement in the child constructor.
     * → If not called explicitly, Java automatically calls the no-arg super().
     *
     * @param accountHolderName String — name of the account holder
     * @param accountNumber     String — unique account number
     * @param balance           double — initial deposit amount
     */
    public SavingsAccount(String accountHolderName,
                          String accountNumber,
                          double balance) {
        super(accountHolderName, accountNumber, balance);
    }

    /**
     * Withdraws money with minimum balance check — savings account cannot go below ₹500.
     *
     * INTERVIEW: What is Method Overriding?
     * → When a child class provides its OWN implementation of a method
     *    that is already defined in the parent class.
     * → Same method signature (name + parameters) as parent.
     * → Happens at RUNTIME (Runtime Polymorphism / Dynamic Method Dispatch).
     *
     * INTERVIEW: What is @Override annotation?
     * → Tells the compiler: "I am intentionally overriding a parent method."
     * → If the method doesn't actually override anything, compiler gives ERROR.
     * → Best practice: ALWAYS use @Override when overriding.
     *
     * @param amount double — the amount to withdraw
     */
    @Override
    void withdrawal(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount! Amount must be positive.");
        } else if (getBalance() - amount >= MINIMUM_BALANCE) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawal Successful!");
            System.out.println("Remaining Balance: ₹" + getBalance());
        } else {
            System.out.println("Withdrawal Failed! Minimum balance of ₹" + MINIMUM_BALANCE + " must be maintained.");
        }
    }

    /**
     * Returns the account type as "Savings Account".
     *
     * @return String — "Savings Account"
     */
    @Override
    String accountType() {
        return "Savings Account";
    }

    /**
     * Calculates interest at 7.5% rate on current balance.
     *
     * FIX: Renamed from 'CalcIntrest()' → 'calculateInterest()' (camelCase convention + spelling fix).
     *
     * @return double — the interest amount
     */
    @Override
    double calculateInterest() {
        double interest = getBalance() * 7.5 / 100;
        return interest;
    }
}