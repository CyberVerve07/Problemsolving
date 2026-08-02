package dailycode.july.day25.onlinebankingsystem;

/**
 * INTERVIEW DEFINITION â€” Inheritance (extends keyword):
 * -------------------------------------------------------
 * Q: What is Inheritance?
 * A: Inheritance is an OOP mechanism where a child class (SavingsAccount) acquires all
 *    the properties (fields) and behaviors (methods) of a parent class (AccountManagement).
 *    It is achieved using the 'extends' keyword.
 *
 * Q: Why do we use Inheritance?
 * A: 1. CODE REUSABILITY â€” SavingsAccount reuses depositMoney(), checkBalance() from parent.
 *    2. IS-A RELATIONSHIP â€” SavingsAccount IS-A type of AccountManagement.
 *    3. METHOD OVERRIDING â€” Child can provide its own version of parent's method.
 *    4. POLYMORPHISM â€” Parent reference can hold child object (Upcasting).
 *
 * Q: What is the 'extends' keyword?
 * A: 'extends' is used to create a child class that inherits from a parent class.
 *    Java supports SINGLE inheritance only (one class can extend only ONE class).
 *
 * Q: What is the 'super' keyword?
 * A: 'super' refers to the PARENT class object.
 *    - super() â†’ calls parent constructor (must be FIRST statement in child constructor).
 *    - super.method() â†’ calls parent's version of an overridden method.
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
     * â†’ 'static' = belongs to the CLASS, not to any instance.
     * â†’ 'final' = value CANNOT be changed after initialization (constant).
     * â†’ Convention: Constants use UPPER_SNAKE_CASE.
     */
    private static final double MINIMUM_BALANCE = 500.0;

    /**
     * Constructor â€” uses 'super()' to call the parent class constructor.
     *
     * INTERVIEW: What is Constructor Chaining?
     * â†’ When a child constructor calls the parent constructor using super().
     * â†’ super() MUST be the FIRST statement in the child constructor.
     * â†’ If not called explicitly, Java automatically calls the no-arg super().
     *
     * @param accountHolderName String â€” name of the account holder
     * @param accountNumber     String â€” unique account number
     * @param balance           double â€” initial deposit amount
     */
    public SavingsAccount(String accountHolderName,
                          String accountNumber,
                          double balance) {
        super(accountHolderName, accountNumber, balance);
    }

    /**
     * Withdraws money with minimum balance check â€” savings account cannot go below â‚¹500.
     *
     * INTERVIEW: What is Method Overriding?
     * â†’ When a child class provides its OWN implementation of a method
     *    that is already defined in the parent class.
     * â†’ Same method signature (name + parameters) as parent.
     * â†’ Happens at RUNTIME (Runtime Polymorphism / Dynamic Method Dispatch).
     *
     * INTERVIEW: What is @Override annotation?
     * â†’ Tells the compiler: "I am intentionally overriding a parent method."
     * â†’ If the method doesn't actually override anything, compiler gives ERROR.
     * â†’ Best practice: ALWAYS use @Override when overriding.
     *
     * @param amount double â€” the amount to withdraw
     */
    @Override
    void withdrawal(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount! Amount must be positive.");
        } else if (getBalance() - amount >= MINIMUM_BALANCE) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawal Successful!");
            System.out.println("Remaining Balance: â‚¹" + getBalance());
        } else {
            System.out.println("Withdrawal Failed! Minimum balance of â‚¹" + MINIMUM_BALANCE + " must be maintained.");
        }
    }

    /**
     * Returns the account type as "Savings Account".
     *
     * @return String â€” "Savings Account"
     */
    @Override
    String accountType() {
        return "Savings Account";
    }

    /**
     * Calculates interest at 7.5% rate on current balance.
     *
     * FIX: Renamed from 'CalcIntrest()' â†’ 'calculateInterest()' (camelCase convention + spelling fix).
     *
     * @return double â€” the interest amount
     */
    @Override
    double calculateInterest() {
        double interest = getBalance() * 7.5 / 100;
        return interest;
    }
}