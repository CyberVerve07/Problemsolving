package dailycode.july24.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Order — Industry-level E-Commerce Order demonstrating Serialization.
 *
 * ╔══════════════════════════════════════════════════════════════════════╗
 * ║                  SERIALIZATION — INTERVIEW GUIDE                   ║
 * ╠══════════════════════════════════════════════════════════════════════╣
 * ║                                                                    ║
 * ║  Q: What is Serialization?                                         ║
 * ║  A: Converting an OBJECT into a BYTE STREAM so it can be:          ║
 * ║     → Saved to a FILE (persistence)                                ║
 * ║     → Sent over a NETWORK (RMI, sockets, microservices)            ║
 * ║     → Stored in a CACHE (Redis, Memcached)                         ║
 * ║     → Put in a SESSION (HttpSession in web apps)                   ║
 * ║                                                                    ║
 * ║  Q: What is Deserialization?                                       ║
 * ║  A: The REVERSE — converting a byte stream BACK into an object.    ║
 * ║                                                                    ║
 * ║  Q: What is the Serializable interface?                            ║
 * ║  A: A MARKER interface (no methods) in java.io package.            ║
 * ║     → It "marks" the class as eligible for serialization.          ║
 * ║     → JVM checks: if object instanceof Serializable → allow.      ║
 * ║     → Without it → NotSerializableException at runtime.            ║
 * ║                                                                    ║
 * ║  Q: What is 'transient' keyword?                                   ║
 * ║  A: Fields marked 'transient' are SKIPPED during serialization.    ║
 * ║     → Used for: passwords, calculated fields, non-serializable     ║
 * ║       objects, sensitive data.                                     ║
 * ║     → After deserialization, transient fields get DEFAULT values:   ║
 * ║       null (objects), 0 (int), false (boolean).                    ║
 * ║                                                                    ║
 * ║  Q: What is 'static' field behavior in Serialization?              ║
 * ║  A: Static fields are NOT serialized because they belong to the    ║
 * ║     CLASS, not the OBJECT. Serialization only saves object state.  ║
 * ║                                                                    ║
 * ║  Q: What are writeObject() and readObject()?                       ║
 * ║  A: Custom hooks for controlling serialization/deserialization.     ║
 * ║     → Must be 'private' with exact method signatures.              ║
 * ║     → JVM uses REFLECTION to find and call them.                   ║
 * ║     → Use case: encrypt sensitive data, validate, add custom logic.║
 * ║                                                                    ║
 * ║  INDUSTRY USE CASES:                                               ║
 * ║  1. Saving order data to file for audit/backup                     ║
 * ║  2. Sending order objects over network (microservices)              ║
 * ║  3. Storing orders in distributed cache (Redis)                    ║
 * ║  4. HTTP Session persistence (e.g., shopping cart)                 ║
 * ║  5. Deep copying objects (serialize → deserialize)                 ║
 * ║                                                                    ║
 * ╚══════════════════════════════════════════════════════════════════════╝
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
     * → It acts as a VERSION NUMBER for this class.
     * → During deserialization, JVM checks if the serialVersionUID of the
     *   serialized object MATCHES the class loaded in memory.
     * → If they DON'T match → InvalidClassException.
     * → If NOT declared, JVM auto-generates one — but it changes whenever
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
    private LocalDateTime orderDate;   // LocalDateTime is Serializable ✔

    /**
     * TRANSIENT FIELD — will NOT be serialized.
     * → Credit card info should NEVER be saved to disk or sent over network.
     * → After deserialization, this will be null.
     */
    private transient String creditCardNumber;

    /**
     * TRANSIENT FIELD — calculated at runtime, no need to persist.
     * → Discount can be recalculated, so we skip it.
     */
    private transient double discountPercentage;

    /**
     * STATIC FIELD — will NOT be serialized.
     * → Static belongs to CLASS, not to OBJECT.
     * → Serialization only saves OBJECT state.
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
     * → A custom hook called by JVM DURING serialization (via reflection).
     * → Must be: private void writeObject(ObjectOutputStream oos)
     * → Use case: Add custom logic BEFORE/AFTER default serialization.
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
     * → A custom hook called by JVM DURING deserialization (via reflection).
     * → Must be: private void readObject(ObjectInputStream ois)
     * → Use case: Restore transient fields, validate data, apply business logic.
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
        return "\n╔══════════════════════════════════════════╗\n"
             + "║           ORDER DETAILS                   ║\n"
             + "╠══════════════════════════════════════════╣\n"
             + "  Order ID       : " + orderId + "\n"
             + "  Customer       : " + customerName + "\n"
             + "  Items          : " + items + "\n"
             + "  Total Amount   : ₹" + totalAmount + "\n"
             + "  Order Date     : " + orderDate + "\n"
             + "  Shipping To    : " + shippingAddress + "\n"
             + "  Credit Card    : " + (creditCardNumber != null ? creditCardNumber : "N/A (transient)") + "\n"
             + "  Discount       : " + discountPercentage + "%\n"
             + "╚══════════════════════════════════════════╝";
    }
}
