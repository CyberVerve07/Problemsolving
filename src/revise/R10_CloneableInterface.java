package revise;

/*
 * ============================================================
 *  TOPIC: Cloneable (Marker Interface) + Object.clone()
 * ============================================================
 *
 *  DEFINITION (Interview Answer):
 *  Cloneable is a MARKER INTERFACE in java.lang package.
 *  It signals to the JVM that the class allows its objects to be
 *  cloned using the Object.clone() method.
 *  If a class implements Cloneable, Object.clone() creates a
 *  field-by-field COPY (shallow copy) of the object.
 *  If a class does NOT implement Cloneable but calls clone(),
 *  JVM throws CloneNotSupportedException.
 *
 *  WHY WE USE Cloneable IN JAVA:
 *  1. Create an EXACT COPY of an object quickly.
 *  2. Avoid creating a new object from scratch (performance).
 *  3. PROTOTYPE DESIGN PATTERN â€” clone base object, modify copy.
 *  4. Defensive copying â€” pass a copy, not the original object.
 *  5. Undo/Redo features â€” save state snapshots.
 *
 *  SHALLOW COPY vs DEEP COPY (Most Important Interview Point!):
 *
 *  SHALLOW COPY (default clone()):
 *  - Primitives are COPIED by VALUE (independent).
 *  - Objects/Arrays are COPIED by REFERENCE (shared!).
 *  - Changes to nested objects in clone AFFECT the original.
 *
 *  DEEP COPY (manual override of clone()):
 *  - Primitives AND nested Objects are all fully copied.
 *  - Clone is completely INDEPENDENT of original.
 *  - Must manually clone each nested object.
 *
 *  KEY POINTS:
 *  - Cloneable is empty â€” it's a MARKER INTERFACE.
 *  - Object.clone() is protected â€” must override and make public.
 *  - Default clone() gives SHALLOW copy.
 *  - For deep copy: override clone() and clone nested objects too.
 *  - @deprecated style: Many experts say avoid Cloneable,
 *    prefer copy constructors or factory methods instead.
 *  - Arrays have a built-in clone() that works well.
 *
 *  Cloneable vs Serializable (Marker Interface Comparison):
 *  Cloneable   â†’ in-memory copy of object (clone())
 *  Serializableâ†’ convert object to bytes (persistence/network)
 * ============================================================
 */

import java.util.Arrays;

// ===================== ADDRESS (nested object) =====================
class Address implements Cloneable {
    String city;
    String country;

    Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    @Override
    public Address clone() {
        try {
            return (Address) super.clone(); // Shallow â€” but Address has only primitives/Strings
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return city + ", " + country;
    }
}

// ===================== SHALLOW COPY DEMO =====================
class StudentShallow implements Cloneable {
    String name;     // String (immutable â€” effectively safe in shallow copy)
    int age;         // primitive â€” always copied by value
    int[] scores;    // array â€” shared reference in shallow copy (DANGER!)
    Address address; // object â€” shared reference in shallow copy (DANGER!)

    StudentShallow(String name, int age, int[] scores, Address address) {
        this.name = name;
        this.age = age;
        this.scores = scores;
        this.address = address;
    }

    @Override
    public StudentShallow clone() {
        try {
            // super.clone() â†’ SHALLOW copy â€” does field-by-field copy
            // primitives: copied by value âœ“
            // objects/arrays: copied by reference âœ— (shared!)
            return (StudentShallow) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age +
               ", scores=" + Arrays.toString(scores) +
               ", address=" + address + "}";
    }
}

// ===================== DEEP COPY DEMO =====================
class StudentDeep implements Cloneable {
    String name;
    int age;
    int[] scores;    // Will be deeply cloned
    Address address; // Will be deeply cloned

    StudentDeep(String name, int age, int[] scores, Address address) {
        this.name = name;
        this.age = age;
        this.scores = scores;
        this.address = address;
    }

    @Override
    public StudentDeep clone() {
        try {
            StudentDeep cloned = (StudentDeep) super.clone(); // get shallow first
            // NOW manually deep clone each mutable nested field:
            cloned.scores = this.scores.clone();       // clone the array
            cloned.address = this.address.clone();     // clone the Address object
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "StudentDeep{name='" + name + "', age=" + age +
               ", scores=" + Arrays.toString(scores) +
               ", address=" + address + "}";
    }
}

// ===================== NOT CLONEABLE â€” What happens? =====================
class NotCloneableClass {
    int data = 42;
    // Does NOT implement Cloneable
}

// ===================== PROTOTYPE DESIGN PATTERN =====================
// Clone a complex object instead of constructing it from scratch
class ConfigTemplate implements Cloneable {
    String host;
    int port;
    String[] allowedIPs;
    boolean sslEnabled;

    ConfigTemplate(String host, int port, String[] allowedIPs, boolean sslEnabled) {
        this.host = host;
        this.port = port;
        this.allowedIPs = allowedIPs;
        this.sslEnabled = sslEnabled;
    }

    @Override
    public ConfigTemplate clone() {
        try {
            ConfigTemplate c = (ConfigTemplate) super.clone();
            c.allowedIPs = this.allowedIPs.clone(); // deep clone array
            return c;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Config{host=" + host + ", port=" + port +
               ", ssl=" + sslEnabled + ", ips=" + Arrays.toString(allowedIPs) + "}";
    }
}

public class R10_CloneableInterface {

    public static void main(String[] args) {

        System.out.println("======== Cloneable MARKER INTERFACE DEMO ========\n");

        // ---- 1. SHALLOW COPY PROBLEM ----
        System.out.println("--- 1. SHALLOW COPY (default clone) ---");

        int[] originalScores = {90, 85, 78};
        Address addr = new Address("Mumbai", "India");
        StudentShallow s1 = new StudentShallow("Rohit", 21, originalScores, addr);
        StudentShallow s2 = s1.clone(); // SHALLOW clone

        System.out.println("Before modification:");
        System.out.println("  s1: " + s1);
        System.out.println("  s2: " + s2);

        // Modify the clone's array â€” AFFECTS ORIGINAL (shared reference!)
        s2.scores[0] = 999;
        s2.address.city = "Delhi"; // modifying shared address!

        System.out.println("\nAfter modifying s2's scores[0] and address:");
        System.out.println("  s1: " + s1); // s1's score & address also changed!
        System.out.println("  s2: " + s2);
        System.out.println("  [PROBLEM] s1 was affected â€” shallow copy shares references!");

        System.out.println();

        // ---- 2. DEEP COPY SOLUTION ----
        System.out.println("--- 2. DEEP COPY (overridden clone) ---");

        int[] scores2 = {90, 85, 78};
        Address addr2 = new Address("Bengaluru", "India");
        StudentDeep d1 = new StudentDeep("Priya", 22, scores2, addr2);
        StudentDeep d2 = d1.clone(); // DEEP clone

        System.out.println("Before modification:");
        System.out.println("  d1: " + d1);
        System.out.println("  d2: " + d2);

        // Modify clone's array â€” does NOT affect original
        d2.scores[0] = 999;
        d2.address.city = "Hyderabad";

        System.out.println("\nAfter modifying d2's scores[0] and address:");
        System.out.println("  d1: " + d1); // d1 unchanged!
        System.out.println("  d2: " + d2);
        System.out.println("  [SUCCESS] d1 is NOT affected â€” deep copy is independent!");

        System.out.println();

        // ---- 3. Same object? â€” Reference Check ----
        System.out.println("--- 3. Clone Identity Checks ---");
        System.out.println("d1 == d2: " + (d1 == d2));                   // false â€” different objects
        System.out.println("d1.equals(d2): " + d1.equals(d2));           // false (default equals uses ==)
        System.out.println("d1.getClass() == d2.getClass(): " + (d1.getClass() == d2.getClass())); // true

        System.out.println();

        // ---- 4. NOT Cloneable â†’ CloneNotSupportedException ----
        System.out.println("--- 4. Without Cloneable = CloneNotSupportedException ---");
        // NotCloneableClass doesn't implement Cloneable
        // Can't call clone() â€” compiler/runtime blocks it
        System.out.println("Class without Cloneable cannot use clone() â€” JVM throws CloneNotSupportedException");
        System.out.println("(Calling super.clone() without Cloneable marker = exception)");

        System.out.println();

        // ---- 5. PROTOTYPE PATTERN â€” clone instead of construct ----
        System.out.println("--- 5. Prototype Pattern (Real World Use) ---");

        // Base config â€” created once
        ConfigTemplate baseConfig = new ConfigTemplate(
            "prod-server.com", 443,
            new String[]{"192.168.1.1", "10.0.0.5"},
            true
        );

        // Clone it for different environments â€” much faster than new construction
        ConfigTemplate devConfig = baseConfig.clone();
        devConfig.host = "dev-server.local";
        devConfig.port = 8080;
        devConfig.sslEnabled = false;
        devConfig.allowedIPs[0] = "127.0.0.1"; // Only affects devConfig

        System.out.println("Base (prod) config: " + baseConfig);
        System.out.println("Dev config (cloned): " + devConfig);

        System.out.println();

        // ---- 6. Array clone() ----
        System.out.println("--- 6. Array clone() (Built-in) ---");
        int[] arr = {1, 2, 3, 4, 5};
        int[] arrCopy = arr.clone(); // shallow for primitives = deep (no reference issue)
        arrCopy[0] = 999;
        System.out.println("Original array: " + Arrays.toString(arr));    // unchanged
        System.out.println("Cloned array:   " + Arrays.toString(arrCopy));

        System.out.println();

        // ---- 7. Summary ----
        System.out.println("--- SUMMARY ---");
        System.out.println("Cloneable     â†’ Marker interface (empty) â€” tags class for clone() support");
        System.out.println("Shallow Copy  â†’ primitives copied, objects SHARED (default clone)");
        System.out.println("Deep Copy     â†’ everything independent (manual clone of nested objects)");
        System.out.println("Alternative   â†’ Copy Constructor: new Student(otherStudent) â€” preferred today");

        System.out.println("\n=================================================");
    }

}
