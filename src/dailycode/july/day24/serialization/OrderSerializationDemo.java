package dailycode.july.day24.serialization;

import java.io.*;
import java.util.Arrays;

/**
 * OrderSerializationDemo â€” Driver class demonstrating Serialization & Deserialization.
 *
 * WORKFLOW:
 * â”Œâ”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”     serialize      â”Œâ”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”     deserialize     â”Œâ”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”
 * â”‚  Order Object    â”‚ â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â†’  â”‚  .ser FILE   â”‚ â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â†’   â”‚  Order Object    â”‚
 * â”‚  (in memory)     â”‚  ObjectOutput     â”‚  (on disk)   â”‚  ObjectInput       â”‚  (restored)      â”‚
 * â”‚                  â”‚  Stream           â”‚              â”‚  Stream            â”‚                  â”‚
 * â””â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”˜                    â””â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”˜                    â””â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”˜
 *
 * INTERVIEW: Key Classes Used:
 * â†’ ObjectOutputStream â€” writes objects to an OutputStream (serializes)
 * â†’ ObjectInputStream  â€” reads objects from an InputStream (deserializes)
 * â†’ FileOutputStream   â€” writes bytes to a file
 * â†’ FileInputStream    â€” reads bytes from a file
 *
 * INTERVIEW: What happens during Serialization?
 * 1. JVM checks: Does the object implement Serializable? â†’ Yes â†’ proceed.
 * 2. JVM checks: Does the class have writeObject()? â†’ Yes â†’ call it (custom).
 *    â†’ No â†’ use defaultWriteObject() (default serialization).
 * 3. All non-transient, non-static fields are converted to bytes.
 * 4. Nested objects are also serialized (entire object graph).
 * 5. Bytes are written to the output stream (file, network, etc.).
 *
 * INTERVIEW: What happens during Deserialization?
 * 1. JVM reads bytes from the input stream.
 * 2. JVM checks serialVersionUID â†’ matches class in memory? â†’ proceed.
 * 3. JVM creates a NEW object WITHOUT calling the constructor.
 *    â†’ This is why deserialization can break Singleton pattern!
 * 4. Non-transient fields are restored from the byte stream.
 * 5. Transient fields get default values (null, 0, false).
 * 6. If readObject() exists â†’ JVM calls it for custom restoration.
 *
 * @author Aditya
 * @version 2.0
 */
public class OrderSerializationDemo {

    // File path where the serialized order will be saved
    private static final String FILE_PATH = "order_data.ser";

    public static void main(String[] args) {

        System.out.println("â•”â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•—");
        System.out.println("â•‘     SERIALIZATION & DESERIALIZATION â€” INDUSTRY DEMO     â•‘");
        System.out.println("â•šâ•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•\n");

        // ======================== STEP 1: CREATE ORDER ========================

        Address address = new Address(
                "42, Connaught Place",
                "New Delhi",
                "Delhi",
                "110001"
        );

        Order order = new Order(
                "ORD-2024-07-001",
                "Aditya Sharma",
                Arrays.asList("MacBook Pro M3", "AirPods Pro", "Apple Watch Ultra"),
                245999.00,
                address,
                "4532015112830366"  // Credit card â€” this is TRANSIENT, won't be fully saved
        );

        System.out.println("â•â•â• BEFORE SERIALIZATION â•â•â•");
        System.out.println(order);
        System.out.println("Static field (totalOrdersCreated): " + Order.getTotalOrdersCreated());

        // ======================== STEP 2: SERIALIZE (Write to File) ========================

        System.out.println("\nâ•â•â• SERIALIZING ORDER TO FILE... â•â•â•");
        serializeOrder(order);

        // ======================== STEP 3: DESERIALIZE (Read from File) ========================

        System.out.println("\nâ•â•â• DESERIALIZING ORDER FROM FILE... â•â•â•");
        Order restoredOrder = deserializeOrder();

        if (restoredOrder != null) {
            System.out.println("\nâ•â•â• AFTER DESERIALIZATION â•â•â•");
            System.out.println(restoredOrder);

            // ======================== STEP 4: VERIFY TRANSIENT & STATIC BEHAVIOR ========================

            System.out.println("\nâ•â•â• VERIFICATION â•â•â•");
            System.out.println("1. Credit Card (transient)      : " + restoredOrder.getCreditCardNumber());
            System.out.println("   â†’ Transient field was masked via custom writeObject()");

            System.out.println("2. Discount (transient)         : " + restoredOrder.getDiscountPercentage() + "%");
            System.out.println("   â†’ Transient field was restored via custom readObject()");

            System.out.println("3. Static totalOrdersCreated    : " + Order.getTotalOrdersCreated());
            System.out.println("   â†’ Static fields are NOT serialized (belong to class, not object)");

            System.out.println("4. Order ID (normal field)      : " + restoredOrder.getOrderId());
            System.out.println("   â†’ Normal fields are fully restored âœ”");

            System.out.println("5. Address (nested object)      : " + restoredOrder.getShippingAddress());
            System.out.println("   â†’ Nested Serializable objects are fully restored âœ”");

            System.out.println("6. Are they same object?        : " + (order == restoredOrder));
            System.out.println("   â†’ Deserialization creates a NEW object (different reference) âœ”");
        }

        // ======================== CLEANUP ========================
        File file = new File(FILE_PATH);
        if (file.delete()) {
            System.out.println("\n[CLEANUP] Serialized file deleted successfully.");
        }
    }

    // ======================== SERIALIZE METHOD ========================

    /**
     * Serializes an Order object to a .ser file.
     *
     * INTERVIEW: try-with-resources (Java 7+)
     * â†’ Automatically closes the stream when done.
     * â†’ No need for explicit finally { stream.close(); }
     * â†’ The stream implements AutoCloseable interface.
     */
    private static void serializeOrder(Order order) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(FILE_PATH))) {

            oos.writeObject(order);
            System.out.println("[SUCCESS] Order saved to file: " + FILE_PATH);

        } catch (IOException e) {
            System.err.println("[ERROR] Serialization failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ======================== DESERIALIZE METHOD ========================

    /**
     * Deserializes an Order object from a .ser file.
     *
     * INTERVIEW: Why do we cast (Order) ois.readObject()?
     * â†’ readObject() returns type 'Object' (the base class).
     * â†’ We must DOWNCAST to the actual type (Order).
     * â†’ ClassNotFoundException can occur if the Order class is not in classpath.
     */
    private static Order deserializeOrder() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(FILE_PATH))) {

            Order order = (Order) ois.readObject();
            System.out.println("[SUCCESS] Order restored from file: " + FILE_PATH);
            return order;

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("[ERROR] Deserialization failed: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
