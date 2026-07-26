package oops.BankAccount;

/**
 * Details — Bank Account management class demonstrating Encapsulation.
 *
 * INTERVIEW DEFINITION — Constructor Overloading:
 * --------------------------------------------------
 * Q: What is Constructor Overloading?
 * A: Having MULTIPLE constructors in the same class with DIFFERENT parameters.
 *    The compiler selects which constructor to call based on the arguments provided.
 *
 *    Example in this class:
 *    - Details() → default constructor (balance = 0.0)
 *    - Details("Aman", 123456789L, 1000.0) → parameterized constructor
 *
 * Q: Why use Constructor Overloading?
 * A: To provide FLEXIBILITY — create objects with different initial states:
 *    - Default: new Details() → creates account with zero balance.
 *    - With details: new Details("Aman", 123L, 1000) → creates with all info.
 *
 * JAVA TYPE: class (POJO with encapsulated fields)
 * OOP PILLAR: Encapsulation + Constructor Overloading
 *
 * @author Aditya
 * @version 2.0
 */
public class Details {

    private String name;
    private double balance;
    private long accountNumber;

    /**
     * Default Constructor — initializes balance to 0.0.
     */
    public Details() {
        this.balance = 0.0;
    }

    /**
     * Parameterized Constructor — initializes with all account details.
     * Includes VALIDATION — initial balance must be non-negative.
     *
     * @param name           String — account holder name
     * @param accountNumber  long — account number
     * @param initialBalance double — initial deposit (must be >= 0)
     */
    public Details(String name, long accountNumber, double initialBalance) {
        this.name = name;
        this.accountNumber = accountNumber;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0.0;
        }
    }

    /**
     * Deposits money into the account.
     *
     * @param amount double — amount to deposit (must be positive)
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Your Balance has been updated. Current Balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    /**
     * Withdraws money from the account with insufficient balance check.
     *
     * @param amount double — amount to withdraw
     */
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful! Remaining Balance: " + balance);
        } else if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else {
            System.out.println("Insufficient balance. Transaction failed.");
        }
    }

    // ======================== GETTERS & SETTERS ========================

    /** @return String — the account holder name */
    public String getName() {
        return name;
    }

    /** @param name String — the name to set */
    public void setName(String name) {
        this.name = name;
    }

    /** @return double — the current balance */
    public double getBalance() {
        return balance;
    }

    /** @return long — the account number */
    public long getAccountNumber() {
        return accountNumber;
    }

    /** @param accountNumber long — the account number to set */
    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }
}