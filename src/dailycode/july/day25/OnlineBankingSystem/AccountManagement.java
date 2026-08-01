package dailycode.july.day25.onlinebankingsystem;

import java.util.Scanner;

/**
 * INTERVIEW DEFINITION — Abstract Class:
 * ----------------------------------------
 * Q: What is an Abstract Class?
 * A: An abstract class is a class declared with the 'abstract' keyword that cannot be
 *    instantiated directly (you cannot do new AccountManagement()). It can contain both
 *    abstract methods (without body — child MUST override) and concrete methods (with body —
 *    shared logic). It acts as a blueprint/template for its child classes.
 *
 * Q: Why do we use an Abstract Class?
 * A: 1. To provide a COMMON BASE for related classes (SavingsAccount, CurrentAccount).
 *    2. To FORCE child classes to implement certain behaviors (withdrawal, accountType).
 *    3. To SHARE common code (depositMoney, checkBalance) — avoids code duplication.
 *    4. To achieve PARTIAL ABSTRACTION (0-100%), unlike Interface which gives 100%.
 *
 * Q: Abstract Class vs Interface?
 * A: - Abstract class can have constructors, instance variables, and concrete methods.
 *    - Interface (before Java 8) could only have abstract methods.
 *    - A class can extend ONLY ONE abstract class but implement MULTIPLE interfaces.
 *    - Use abstract class when classes share common state (fields); use interface for behavior contracts.
 *
 * Q: What is the 'abstract' keyword?
 * A: The 'abstract' keyword is used to declare a class or method as abstract.
 *    - Abstract CLASS → cannot be instantiated.
 *    - Abstract METHOD → has no body, must be overridden by child class.
 *
 * JAVA TYPE: abstract class
 * OOP PILLAR: Abstraction
 * DESIGN PATTERN USED: Template Method Pattern (common logic in parent, variable logic in children)
 *
 * @author Aditya
 * @version 2.0
 * @see SavingsAccount
 * @see CurrentAccount
 */
public abstract class AccountManagement {

    /**
     * Private fields — Encapsulation ensures these cannot be accessed directly from outside.
     *
     * INTERVIEW: Why private?
     * → To protect data from unauthorized/accidental modification.
     * → External code must use getters/setters (controlled access).
     */
    private String accountHolderName;
    private String accountNumber;
    private double balance;

    /**
     * Scanner object for user input.
     *
     * INTERVIEW: Why 'static final'?
     * → 'static' means shared across ALL instances (only one Scanner needed).
     * → 'final' means the reference cannot be reassigned after initialization.
     *
     * WARNING: In production code, Scanner should be closed to avoid resource leaks.
     * This is acceptable in a learning/console application context.
     */
    private static final Scanner sc = new Scanner(System.in);

    // ======================== GETTERS & SETTERS ========================

    /**
     * Returns the account holder's name.
     *
     * INTERVIEW: What is a Getter?
     * → A public method that provides READ access to a private field.
     * → Part of Encapsulation — controls HOW data is accessed.
     *
     * @return String — the account holder's name
     */
    public String getAccountHolderName() {
        return accountHolderName;
    }

    /**
     * Sets the account holder's name.
     *
     * INTERVIEW: What is a Setter?
     * → A public method that provides WRITE access to a private field.
     * → Can include VALIDATION logic before setting the value.
     *
     * @param accountHolderName String — the name to set
     */
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    /**
     * @return String — the account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber String — the account number to set
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @return double — the current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance double — the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // ======================== CONSTRUCTOR ========================

    /**
     * Parameterized Constructor — initializes account with all required fields.
     *
     * INTERVIEW: What is a Constructor?
     * → A special method that is called when an object is created (new keyword).
     * → Same name as the class, NO return type (not even void).
     * → Used to initialize object state.
     *
     * INTERVIEW: What is 'this' keyword?
     * → 'this' refers to the CURRENT OBJECT instance.
     * → Used to distinguish between instance variable and parameter with same name.
     *
     * @param accountHolderName String — name of the account holder
     * @param accountNumber     String — unique account number
     * @param balance           double — initial balance
     */
    public AccountManagement(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // ======================== CONCRETE METHODS ========================

    /**
     * Deposits money into the account.
     *
     * INTERVIEW: What is a Concrete Method in an Abstract Class?
     * → A method WITH a body (implementation) inside an abstract class.
     * → Child classes INHERIT this method — no need to override.
     * → Used for SHARED/COMMON behavior across all account types.
     *
     * @param amount double — the amount to deposit (must be positive)
     */
    void depositMoney(double amount) {
        if (amount > 0) {
            System.out.println("Amount Successfully Deposited!");
            balance = amount + balance;
            System.out.println("Updated Balance: ₹" + getBalance());
        } else {
            System.out.println("Invalid amount! Amount must be positive.");
        }
    }

    /**
     * Checks and displays the balance after PIN verification.
     *
     * SECURITY WARNING: PIN is hardcoded as 1234 — in real applications,
     * PIN should be encrypted, stored securely, and validated against a database.
     * TODO: Replace hardcoded PIN with secure authentication mechanism.
     */
    void checkBalance() {
        System.out.println("Enter the 4-digit PIN:");
        int pin = sc.nextInt();

        if (pin != 1234) {
            System.out.println("Invalid PIN!");
        } else {
            System.out.println("Your Balance is: ₹" + getBalance());
        }
    }

    // ======================== ABSTRACT METHODS ========================

    /**
     * Withdraws money from the account — each account type implements differently.
     *
     * INTERVIEW: What is an Abstract Method?
     * → A method declared WITHOUT a body (no curly braces, just semicolon).
     * → MUST be overridden by every non-abstract child class.
     * → Defines a CONTRACT — "every account must support withdrawal, but HOW is up to the account type."
     *
     * @param amount double — the amount to withdraw
     */
    abstract void withdrawal(double amount);

    /**
     * Returns the type of account (e.g., "Savings Account", "Current Account").
     *
     * @return String — the account type name
     */
    abstract String accountType();

    /**
     * Calculates interest based on account type.
     * - SavingsAccount: earns interest (e.g., 7.5%)
     * - CurrentAccount: typically earns 0% interest
     *
     * NAMING CONVENTION FIX: Renamed from 'CalcIntrest()' to 'calculateInterest()'.
     * → Java methods follow camelCase convention.
     * → Method names should be descriptive verbs.
     *
     * @return double — the calculated interest amount
     */
    abstract double calculateInterest();
}
