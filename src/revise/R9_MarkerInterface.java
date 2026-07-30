package revise;

/*
 * ============================================================
 *  TOPIC: MARKER INTERFACE
 * ============================================================
 *
 *  DEFINITION (Interview Answer):
 *  A Marker Interface (also called Tagging Interface) is an interface
 *  that has NO methods and NO fields — it is completely EMPTY.
 *  Its sole purpose is to MARK or TAG a class to indicate to the
 *  JVM or Java framework that the class has some special capability
 *  or should be treated in a special way.
 *
 *  WHY WE USE MARKER INTERFACES IN JAVA:
 *  1. SIGNAL TO JVM — JVM/API checks instanceof to decide behavior.
 *     e.g., ObjectOutputStream checks if object implements Serializable.
 *  2. METADATA — conveys information about a class without behavior.
 *  3. TYPE SAFETY — only marked classes get special treatment.
 *  4. RUNTIME CAPABILITY CHECK — code can check if a class "opted in".
 *
 *  FAMOUS JAVA MARKER INTERFACES:
 *  ┌─────────────────────┬──────────────────────────────────────────┐
 *  │ Interface           │ Marks for...                             │
 *  ├─────────────────────┼──────────────────────────────────────────┤
 *  │ java.io.Serializable│ JVM: object can be serialized to bytes   │
 *  │ java.lang.Cloneable │ JVM: object.clone() is allowed           │
 *  │ java.util.RandomAccess│ List: supports O(1) index access       │
 *  │ java.rmi.Remote     │ RMI: object can be accessed remotely     │
 *  └─────────────────────┴──────────────────────────────────────────┘
 *
 *  KEY POINTS:
 *  - Has ZERO methods and ZERO fields — just a tag.
 *  - Check using instanceof at runtime.
 *  - Modern alternative: ANNOTATIONS (@Deprecated, @Override, @Entity)
 *    → annotations are more powerful and flexible than marker interfaces.
 *  - Marker interfaces still used for JVM-level operations (Serializable).
 *
 *  MARKER INTERFACE vs ANNOTATION:
 *  Marker Interface → cannot carry data, caught by instanceof.
 *  Annotation       → can carry data (key-value pairs), caught by reflection.
 *
 *  WHEN TO USE MARKER INTERFACE TODAY:
 *  - When you need TYPE-LEVEL tagging checked via instanceof.
 *  - For JVM-level integration (serialization, cloning).
 *  - Annotations preferred for everything else.
 * ============================================================
 */

import java.io.*;

// ===================== CUSTOM MARKER INTERFACE =====================

// Empty interface — just a TAG/MARKER
interface Auditable {
    // No methods, no fields — just marking that this class is auditable
}

interface Encryptable {
    // Marks that this data should be encrypted before storage
}

// ===================== CLASSES THAT USE MARKER =====================

class UserData implements Auditable, Serializable {
    // implements Auditable → marked for audit logging
    // implements Serializable → marked for JVM serialization
    String username;
    String email;

    UserData(String username, String email) {
        this.username = username;
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserData{username='" + username + "', email='" + email + "'}";
    }
}

class PaymentData implements Auditable, Encryptable, Serializable {
    // Triple marked: audit + encrypt + serialize
    String cardNumber;
    double amount;

    PaymentData(String cardNumber, double amount) {
        this.cardNumber = cardNumber;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PaymentData{card='" + cardNumber + "', amount=" + amount + "}";
    }
}

class ProductData {
    // NOT marked — no special treatment
    String productName;
    double price;

    ProductData(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductData{name='" + productName + "', price=" + price + "}";
    }
}

// ===================== SERVICE THAT CHECKS MARKER =====================

class DataService {

    // Processes any object — but applies special logic based on marker interfaces
    static void process(Object obj) {
        System.out.println("Processing: " + obj.getClass().getSimpleName());

        // Check marker interface — should we log audit?
        if (obj instanceof Auditable) {
            System.out.println("  [AUDIT] Logging this operation to audit trail...");
        }

        // Check marker interface — should we encrypt?
        if (obj instanceof Encryptable) {
            System.out.println("  [ENCRYPT] Encrypting sensitive data before saving...");
        }

        // Check marker interface — can we serialize?
        if (obj instanceof Serializable) {
            System.out.println("  [SERIALIZE] This object can be persisted to disk/network.");
        }

        System.out.println("  Processing done.\n");
    }
}

public class R9_MarkerInterface {

    public static void main(String[] args) {

        System.out.println("========== MARKER INTERFACE DEMO ==========\n");

        // ---- 1. Custom Marker Interface in Action ----
        System.out.println("--- 1. Custom Marker Interfaces ---");

        UserData user = new UserData("alice", "alice@example.com");
        PaymentData payment = new PaymentData("4111-XXXX-XXXX-1111", 5999.99);
        ProductData product = new ProductData("Laptop", 45000.0);

        DataService.process(user);
        DataService.process(payment);
        DataService.process(product); // No markers — no special treatment

        // ---- 2. instanceof Check on Marker Interface ----
        System.out.println("--- 2. instanceof Marker Check ---");
        Object[] objects = {user, payment, product};
        for (Object obj : objects) {
            System.out.println(obj.getClass().getSimpleName() +
                    " is Auditable?    " + (obj instanceof Auditable));
            System.out.println(obj.getClass().getSimpleName() +
                    " is Encryptable?  " + (obj instanceof Encryptable));
            System.out.println(obj.getClass().getSimpleName() +
                    " is Serializable? " + (obj instanceof Serializable));
            System.out.println();
        }

        // ---- 3. java.io.Serializable (Built-in Marker) ----
        System.out.println("--- 3. Serializable (Built-in Marker) Demo ---");
        // Serialize UserData to byte array (JVM checks instanceof Serializable)
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(user);        // Works — UserData implements Serializable
            oos.close();

            // Deserialize back
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            UserData restored = (UserData) ois.readObject();
            ois.close();

            System.out.println("Serialized & Deserialized: " + restored);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();

        // ---- 4. NOT Serializable — What happens? ----
        System.out.println("--- 4. Not Serializable = Exception ---");
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(product); // ProductData does NOT implement Serializable!
        } catch (NotSerializableException e) {
            System.out.println("NotSerializableException: " + e.getMessage());
            System.out.println("Lesson: Implement Serializable marker to allow serialization!");
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

        System.out.println();

        // ---- 5. Marker Interface vs Annotation ----
        System.out.println("--- 5. Marker Interface vs Annotation ---");
        System.out.println("Marker Interface:");
        System.out.println("  interface Auditable {}        ← empty, no data");
        System.out.println("  Check: obj instanceof Auditable");
        System.out.println();
        System.out.println("Annotation (Modern Alternative):");
        System.out.println("  @interface Auditable {}       ← can carry data");
        System.out.println("  @Retention(RUNTIME)");
        System.out.println("  @Target(TYPE)");
        System.out.println("  @interface Auditable { String level() default \"INFO\"; }");
        System.out.println("  Check: cls.isAnnotationPresent(Auditable.class)");
        System.out.println();
        System.out.println("Prefer Annotations for new code. Marker Interfaces for JVM-level.");

        System.out.println("\n==========================================");
    }
}
