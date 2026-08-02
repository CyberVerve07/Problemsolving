package dailycode.july.day24.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Order â€” Industry-level E-Commerce Order demonstrating Serialization.
 *
 * â•”â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•—
 * â•‘                  SERIALIZATION â€” INTERVIEW GUIDE                   â•‘
 * â• â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•£
 * â•‘                                                                    â•‘
 * â•‘  Q: What is Serialization?                                         â•‘
 * â•‘  A: Converting an OBJECT into a BYTE STREAM so it can be:          â•‘
 * â•‘     â†’ Saved to a FILE (persistence)                                â•‘
 * â•‘     â†’ Sent over a NETWORK (RMI, sockets, microservices)            â•‘
 * â•‘     â†’ Stored in a CACHE (Redis, Memcached)                         â•‘
 * â•‘     â†’ Put in a SESSION (HttpSession in web apps)                   â•‘
 * â•‘                                                                    â•‘
 * â•‘  Q: What is Deserialization?                                       â•‘
 * â•‘  A: The REVERSE â€” converting a byte stream BACK into an object.    â•‘
 * â•‘                                                                    â•‘
 * â•‘  Q: What is the Serializable interface?                            â•‘
 * â•‘  A: A MARKER interface (no methods) in java.io package.            â•‘
 * â•‘     â†’ It "marks" the class as eligible for serialization.          â•‘
 * â•‘     â†’ JVM checks: if object instanceof Serializable â†’ allow.      â•‘
 * â•‘     â†’ Without it â†’ NotSerializableException at runtime.            â•‘
 * â•‘                                                                    â•‘
 * â•‘  Q: What is 'transient' keyword?                                   â•‘
 * â•‘  A: Fields marked 'transient' are SKIPPED during serialization.    â•‘
 * â•‘     â†’ Used for: passwords, calculated fields, non-serializable     â•‘
 * â•‘       objects, sensitive data.                                     â•‘
 * â•‘     â†’ After deserialization, transient fields get DEFAULT values:   â•‘
 * â•‘       null (objects), 0 (int), false (boolean).                    â•‘
 * â•‘                                                                    â•‘
 * â•‘  Q: What is 'static' field behavior in Serialization?              â•‘
 * â•‘  A: Static fields are NOT serialized because they belong to the    â•‘
 * â•‘     CLASS, not the OBJECT. Serialization only saves object state.  â•‘
 * â•‘                                                                    â•‘
 * â•‘  Q: What are writeObject() and readObject()?                       â•‘
 * â•‘  A: Custom hooks for controlling serialization/deserialization.     â•‘
 * â•‘     â†’ Must be 'private' with exact method signatures.              â•‘
 * â•‘     â†’ JVM uses REFLECTION to find and call them.                   â•‘
 * â•‘     â†’ Use case: encrypt sensitive data, validate, add custom logic.â•‘
 * â•‘                                                                    â•‘
 * â•‘  INDUSTRY USE CASES:                                               â•‘
 * â•‘  1. Saving order data to file for audit/backup                     â•‘
 * â•‘  2. Sending order objects over network (microservices)              â•‘
 * â•‘  3. Storing orders in distributed cache (Redis)                    â•‘
 * â•‘  4. HTTP Session persistence (e.g., shopping cart)                 â•‘
 * â•‘  5. Deep copying objects (serialize â†’ deserialize)                 â•‘
 * â•‘                                                                    â•‘
 * â•šâ•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•
 *
 * @author Aditya
 * @version 2.0
 * @see java.io.Serializable
 * @see Address
 */
public class Order implements Serializable {

    // ======================== serialVersionUID ========================
    /**
     * INTERVIEW: Why is serialVersionUID important?
     * â†’ It acts as a VERSION NUMBER for this class.
     * â†’ During deserialization, JVM checks if the serialVersionUID of the
     *   serialized object MATCHES the class loaded in memory.
     * â†’ If they DON'T match â†’ InvalidClassException.
     * â†’ If NOT declared, JVM auto-generates one â€” but it changes whenever
     *   the class structure changes, breaking backward compatibility.
     *
     * BEST PRACTICE: ALWAYS declare serialVersionUID explicitly.
     */
    private static final long serialVersionUID = 100L;

    // ======================== FIELDS ========================

    private String orderId;
    private String customerName;
    private List<String> items;
    private double totalAmount;
    private Address shippingAddress;   // Nested Serializable object
    private LocalDateTime orderDate;   // LocalDateTime is Serializable âœ”

    /**
     * TRANSIENT FIELD â€” will NOT be serialized.
     * â†’ Credit card info should NEVER be saved to disk or sent over network.
     * â†’ After deserialization, this will be null.
     */
    private transient String creditCardNumber;

    /**
     * TRANSIENT FIELD â€” calculated at runtime, no need to persist.
     * â†’ Discount can be recalculated, so we skip it.
     */
    private transient double discountPercentage;

    /**
     * STATIC FIELD â€” will NOT be serialized.
     * â†’ Static belongs to CLASS, not to OBJECT.
     * â†’ Serialization only saves OBJECT state.
     */
    private static int totalOrdersCreated = 0;

    // ======================== CONSTRUCTOR ========================

    public Order(String orderId, String customerName, List<String> items,
                 double totalAmount, Address shippingAddress, String creditCardNumber) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.items = items;
        this.totalAmount = totalAmount;
        this.shippingAddress = shippingAddress;
        this.orderDate = LocalDateTime.now();
        this.creditCardNumber = creditCardNumber;
        this.discountPercentage = 10.0; // default 10% discount
        totalOrdersCreated++;
    }

    // ======================== CUSTOM SERIALIZATION HOOKS ========================

    /**
     * INTERVIEW: What is writeObject()?
     * â†’ A custom hook called by JVM DURING serialization (via reflection).
     * â†’ Must be: private void writeObject(ObjectOutputStream oos)
     * â†’ Use case: Add custom logic BEFORE/AFTER default serialization.
     *
     * HERE: We call defaultWriteObject() first (serialize all non-transient fields),
     * then write the masked credit card number (last 4 digits only) for audit purposes.
     */
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject(); // Serialize all non-transient fields

        // Custom: Save masked card number for audit trail
        String maskedCard = (creditCardNumber != null)
                ? "****-****-****-" + creditCardNumber.substring(creditCardNumber.length() - 4)
                : "N/A";
        oos.writeObject(maskedCard);

        System.out.println("[SERIALIZE] Order " + orderId + " serialized successfully.");
        System.out.println("[SERIALIZE] Credit card masked for security: " + maskedCard);
    }

    /**
     * INTERVIEW: What is readObject()?
     * â†’ A custom hook called by JVM DURING deserialization (via reflection).
     * â†’ Must be: private void readObject(ObjectInputStream ois)
     * â†’ Use case: Restore transient fields, validate data, apply business logic.
     *
     * HERE: We restore the masked card and recalculate the discount.
     */
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject(); // Deserialize all non-transient fields

        // Custom: Read back the masked card number
        this.creditCardNumber = (String) ois.readObject();

        // Recalculate transient fields
        this.discountPercentage = 10.0; // Restore default discount

        System.out.println("[DESERIALIZE] Order " + orderId + " deserialized successfully.");
        System.out.println("[DESERIALIZE] Transient fields restored.");
    }

    // ======================== GETTERS ========================

    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public List<String> getItems() { return items; }
    public double getTotalAmount() { return totalAmount; }
    public Address getShippingAddress() { return shippingAddress; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public String getCreditCardNumber() { return creditCardNumber; }
    public double getDiscountPercentage() { return discountPercentage; }
    public static int getTotalOrdersCreated() { return totalOrdersCreated; }

    // ======================== DISPLAY ========================

    @Override
    public String toString() {
        return "\nâ•”â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•—\n"
             + "â•‘           ORDER DETAILS                   â•‘\n"
             + "â• â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•£\n"
             + "  Order ID       : " + orderId + "\n"
             + "  Customer       : " + customerName + "\n"
             + "  Items          : " + items + "\n"
             + "  Total Amount   : â‚¹" + totalAmount + "\n"
             + "  Order Date     : " + orderDate + "\n"
             + "  Shipping To    : " + shippingAddress + "\n"
             + "  Credit Card    : " + (creditCardNumber != null ? creditCardNumber : "N/A (transient)") + "\n"
             + "  Discount       : " + discountPercentage + "%\n"
             + "â•šâ•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•";
    }
}
