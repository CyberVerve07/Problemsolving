package dailycode.july.day25.onlinebankingsystem;

/**
 * Receipt — Represents a payment receipt generated after a successful transaction.
 *
 * INTERVIEW DEFINITION — Access Modifiers:
 * -------------------------------------------
 * Q: What are Access Modifiers in Java?
 * A: Access modifiers control the VISIBILITY/ACCESSIBILITY of classes, methods, and fields.
 *    Java has 4 access modifiers:
 *
 *    | Modifier    | Class | Package | Subclass | World |
 *    |-------------|-------|---------|----------|-------|
 *    | private     | ✅    | ❌      | ❌       | ❌    |
 *    | default     | ✅    | ✅      | ❌       | ❌    |
 *    | protected   | ✅    | ✅      | ✅       | ❌    |
 *    | public      | ✅    | ✅      | ✅       | ✅    |
 *
 * Q: Why use private for fields?
 * A: To achieve ENCAPSULATION — data is hidden and can only be accessed through
 *    controlled methods (getters/setters). This prevents unauthorized modification.
 *
 * BUG FIXES:
 * 1. Made 'receiptId' and 'transactionId' PRIVATE (were public — broke encapsulation).
 * 2. Renamed 'showRecipt()' → 'showReceipt()' (spelling fix).
 * 3. Added getters for all private fields.
 *
 * JAVA TYPE: class (POJO)
 * OOP PILLAR: Encapsulation
 *
 * @author Aditya
 * @version 2.0
 */
public class Receipt {

    /** Unique receipt identifier */
    private String receiptId;

    /** Associated transaction ID */
    private String transactionId;

    /** Payment amount */
    private double amount;

    /** Date and time of receipt generation */
    private String dateTime;

    /**
     * Constructor — creates a receipt with all details.
     *
     * @param receiptId     String — unique receipt ID (e.g., "RCP001")
     * @param transactionId String — associated transaction ID
     * @param amount        double — payment amount
     * @param dateTime      String — date and time
     */
    public Receipt(String receiptId, String transactionId, double amount, String dateTime) {
        this.receiptId = receiptId;
        this.transactionId = transactionId;
        this.amount = amount;
        this.dateTime = dateTime;
    }

    // ======================== GETTERS ========================

    /** @return String — the receipt ID */
    public String getReceiptId() {
        return receiptId;
    }

    /** @return String — the transaction ID */
    public String getTransactionId() {
        return transactionId;
    }

    /** @return double — the amount */
    public double getAmount() {
        return amount;
    }

    /** @return String — the date and time */
    public String getDateTime() {
        return dateTime;
    }

    // ======================== METHODS ========================

    /**
     * Generates the receipt — marks it as ready for display.
     */
    void generate() {
        System.out.println("Receipt Generated Successfully!");
    }

    /**
     * Displays the receipt details in a formatted output.
     *
     * NAMING FIX: Renamed from 'showRecipt()' → 'showReceipt()' (spelling correction).
     * Java naming convention: method names should be accurate, descriptive, and in camelCase.
     */
    void showReceipt() {
        System.out.println("Show Receipt Details:");
        System.out.println("=======================");
        System.out.println("Receipt ID     : " + receiptId);
        System.out.println("Transaction ID : " + transactionId);
        System.out.println("Amount         : ₹" + amount);
        System.out.println("Date and Time  : " + dateTime);
        System.out.println("===========================");
        System.out.println();
    }
}
