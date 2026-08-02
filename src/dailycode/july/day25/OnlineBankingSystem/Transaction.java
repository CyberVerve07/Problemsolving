package dailycode.july.day25.onlinebankingsystem;

/**
 * Transaction â€” Represents a single banking transaction between two accounts.
 *
 * INTERVIEW DEFINITION â€” Encapsulation:
 * ----------------------------------------
 * Q: What is Encapsulation?
 * A: Encapsulation is the process of BINDING data (fields) and methods together in a
 *    single unit (class), and HIDING the internal state from outside access using
 *    access modifiers (private). External code can only access data through public
 *    getter/setter methods.
 *
 * Q: Why do we make fields private?
 * A: 1. DATA PROTECTION â€” prevents accidental modification of critical data
 *       (e.g., transactionId should NEVER be changed after creation).
 *    2. DATA VALIDATION â€” setters can validate input before storing.
 *    3. DATA HIDING â€” internal implementation can change without affecting external code.
 *    4. SECURITY â€” sensitive data like account numbers are not directly accessible.
 *
 * Q: What are Getters and Setters?
 * A: - Getter: A public method that RETURNS the value of a private field (read access).
 *    - Setter: A public method that SETS/UPDATES the value of a private field (write access).
 *    - Convention: getFieldName() for getters, setFieldName() for setters.
 *    - For boolean fields, getter uses 'is' prefix: isActive().
 *
 * BUG FIX: All fields were PUBLIC â€” now changed to PRIVATE with proper getters.
 * Transaction data should be IMMUTABLE (no setters) â€” once created, it should not be changed.
 *
 * JAVA TYPE: class (POJO â€” Plain Old Java Object)
 * OOP PILLAR: Encapsulation
 *
 * @author Aditya
 * @version 2.0
 */
public class Transaction {

    /** Unique identifier for this transaction */
    private String transactionId;

    /** Account number from which money is sent */
    private String fromAccount;

    /** Account number to which money is received */
    private String toAccount;

    /** Transaction amount in â‚¹ */
    private double amount;

    /** Date and time of the transaction */
    private String dateTime;

    /** Transaction status â€” "SUCCESS", "FAILED", "PENDING" */
    private String status;

    /**
     * Constructor â€” initializes all transaction details.
     *
     * INTERVIEW: Why no setters for Transaction?
     * â†’ Transaction data is IMMUTABLE â€” once a transaction is created,
     *   its details should NOT be modified (for audit/security purposes).
     * â†’ This follows the IMMUTABILITY principle.
     *
     * @param transactionId String â€” unique transaction ID (e.g., "TXN001")
     * @param fromAccount   String â€” sender's account number
     * @param toAccount     String â€” receiver's account number
     * @param amount        double â€” transaction amount
     * @param dateTime      String â€” date and time of transaction
     * @param status        String â€” transaction status
     */
    public Transaction(String transactionId, String fromAccount, String toAccount,
                       double amount, String dateTime, String status) {
        this.transactionId = transactionId;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.dateTime = dateTime;
        this.status = status;
    }

    // ======================== GETTERS (Read-only access) ========================

    /** @return String â€” the transaction ID */
    public String getTransactionId() {
        return transactionId;
    }

    /** @return String â€” the sender's account number */
    public String getFromAccount() {
        return fromAccount;
    }

    /** @return String â€” the receiver's account number */
    public String getToAccount() {
        return toAccount;
    }

    /** @return double â€” the transaction amount */
    public double getAmount() {
        return amount;
    }

    /** @return String â€” the date and time */
    public String getDateTime() {
        return dateTime;
    }

    /** @return String â€” the transaction status */
    public String getStatus() {
        return status;
    }

    // ======================== DISPLAY METHOD ========================

    /**
     * Displays all transaction details in a formatted output.
     */
    public void showDetails() {
        System.out.println("â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•");
        System.out.println("              TRANSACTION DETAILS              ");
        System.out.println("â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•");
        System.out.println("Transaction ID : " + transactionId);
        System.out.println("From Account   : " + fromAccount);
        System.out.println("To Account     : " + toAccount);
        System.out.println("Amount         : â‚¹" + amount);
        System.out.println("Date & Time    : " + dateTime);
        System.out.println("Status         : " + status);
        System.out.println("â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•");
        System.out.println();
    }
}
