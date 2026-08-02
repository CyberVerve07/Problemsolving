package dailycode.july.day25.onlinebankingsystem;

/**
 * Receipt â€” Represents a payment receipt generated after a successful transaction.
 *
 * INTERVIEW DEFINITION â€” Access Modifiers:
 * -------------------------------------------
 * Q: What are Access Modifiers in Java?
 * A: Access modifiers control the VISIBILITY/ACCESSIBILITY of classes, methods, and fields.
 *    Java has 4 access modifiers:
 *
 *    | Modifier    | Class | Package | Subclass | World |
 *    |-------------|-------|---------|----------|-------|
 *    | private     | âœ…    | âŒ      | âŒ       | âŒ    |
 *    | default     | âœ…    | âœ…      | âŒ       | âŒ    |
 *    | protected   | âœ…    | âœ…      | âœ…       | âŒ    |
 *    | public      | âœ…    | âœ…      | âœ…       | âœ…    |
 *
 * Q: Why use private for fields?
 * A: To achieve ENCAPSULATION â€” data is hidden and can only be accessed through
 *    controlled methods (getters/setters). This prevents unauthorized modification.
 *
 * BUG FIXES:
 * 1. Made 'receiptId' and 'transactionId' PRIVATE (were public â€” broke encapsulation).
 * 2. Renamed 'showRecipt()' â†’ 'showReceipt()' (spelling fix).
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
     * Constructor â€” creates a receipt with all details.
     *
     * @param receiptId     String â€” unique receipt ID (e.g., "RCP001")
     * @param transactionId String â€” associated transaction ID
     * @param amount        double â€” payment amount
     * @param dateTime      String â€” date and time
     */
    public Receipt(String receiptId, String transactionId, double amount, String dateTime) {
        this.receiptId = receiptId;
        this.transactionId = transactionId;
        this.amount = amount;
        this.dateTime = dateTime;
    }

    // ======================== GETTERS ========================

    /** @return String â€” the receipt ID */
    public String getReceiptId() {
        return receiptId;
    }

    /** @return String â€” the transaction ID */
    public String getTransactionId() {
        return transactionId;
    }

    /** @return double â€” the amount */
    public double getAmount() {
        return amount;
    }

    /** @return String â€” the date and time */
    public String getDateTime() {
        return dateTime;
    }

    // ======================== METHODS ========================

    /**
     * Generates the receipt â€” marks it as ready for display.
     */
    void generate() {
        System.out.println("Receipt Generated Successfully!");
    }

    /**
     * Displays the receipt details in a formatted output.
     *
     * NAMING FIX: Renamed from 'showRecipt()' â†’ 'showReceipt()' (spelling correction).
     * Java naming convention: method names should be accurate, descriptive, and in camelCase.
     */
    void showReceipt() {
        System.out.println("Show Receipt Details:");
        System.out.println("=======================");
        System.out.println("Receipt ID     : " + receiptId);
        System.out.println("Transaction ID : " + transactionId);
        System.out.println("Amount         : â‚¹" + amount);
        System.out.println("Date and Time  : " + dateTime);
        System.out.println("===========================");
        System.out.println();
    }
}
