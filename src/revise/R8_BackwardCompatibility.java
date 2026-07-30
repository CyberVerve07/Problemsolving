package revise;

/*
 * ============================================================
 *  TOPIC: BACKWARD COMPATIBILITY IN JAVA
 * ============================================================
 *
 *  DEFINITION (Interview Answer):
 *  Backward Compatibility means that NEW versions of Java can still
 *  run code written for OLDER versions WITHOUT any modification.
 *  Old code compiled on Java 5 should still run perfectly on Java 21.
 *  Java is famous for its extremely strong backward compatibility.
 *
 *  WHY JAVA MAINTAINS BACKWARD COMPATIBILITY:
 *  1. TRUST — enterprises invest millions in Java codebases.
 *     Breaking them with every version would destroy Java's adoption.
 *  2. ECOSYSTEM STABILITY — billions of lines of Java code exist.
 *  3. MIGRATION FREEDOM — companies can upgrade JDK without rewriting apps.
 *  4. "Write Once, Run Anywhere" — Java's core promise includes versions too.
 *
 *  HOW JAVA ACHIEVES BACKWARD COMPATIBILITY:
 *  1. OLD .class files work on newer JVMs (bytecode is stable).
 *  2. New features ADDED (not removed) — no existing API is broken.
 *  3. @Deprecated annotation warns developers BEFORE removal.
 *  4. Default Methods in Interfaces (Java 8) — added behavior to
 *     existing interfaces without breaking all implementing classes.
 *  5. Type Erasure in Generics — generics compiled to Object bytecode,
 *     so pre-generics code works alongside generic code.
 *  6. Autoboxing, varargs — added without breaking old code.
 *
 *  KEY EXAMPLES OF BACKWARD COMPATIBILITY IN JAVA:
 *
 *  a) Generics (Java 5) — Type Erasure
 *     Old: List list = new ArrayList();       ← still compiles in Java 21
 *     New: List<String> list = new ArrayList<>();
 *
 *  b) Default Methods (Java 8) — Interface Evolution
 *     Before Java 8: adding a method to interface broke all implementations.
 *     Java 8+: default methods added to existing interfaces (Iterable.forEach,
 *     Collection.stream) without breaking existing implementations.
 *
 *  c) @Deprecated — Gradual Phase-out
 *     Methods are deprecated before removal, giving developers time to migrate.
 *
 *  TRADE-OFFS:
 *  - Java can't fix design mistakes (e.g., Date class is broken but kept).
 *  - Sometimes new features are more complex to keep backward compat.
 *  - Raw types, unchecked warnings — price of type erasure.
 *
 *  REAL WORLD ANALOGY:
 *  Your old DVD player still plays DVDs even after 20 years.
 *  Java is like that player — old code still runs on new JVM.
 * ============================================================
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

// -------- Old-style class (Java 1.0 era style) --------
class LegacyStack {
    private Object[] data = new Object[100];
    private int top = -1;

    // Old style — no generics (Java 1.4 and before)
    public void push(Object item) {
        data[++top] = item;
    }

    public Object pop() {
        return data[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

// -------- New-style Generic class (Java 5+) --------
class ModernStack<T> {
    private List<T> data = new ArrayList<>();

    public void push(T item) {
        data.add(item);
    }

    public T pop() {
        return data.remove(data.size() - 1);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}

// -------- Interface evolution with Default Method --------
// Imagine this interface existed before Java 8
interface Printable {
    void print();

    // DEFAULT METHOD (Java 8) — added to existing interface WITHOUT
    // breaking any class that already implemented this interface!
    default void printWithBorder() {
        System.out.println("===================");
        print(); // calls the abstract method
        System.out.println("===================");
    }

    // STATIC METHOD in interface (Java 8)
    static void info() {
        System.out.println("Printable interface — Java 8 compatible");
    }
}

// Old implementation — written before Java 8 (only implemented print())
// Still compiles and works in Java 21 — BACKWARD COMPATIBLE!
class OldDocument implements Printable {
    private String content;

    OldDocument(String content) {
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println("Document: " + content);
    }
    // No need to implement printWithBorder() — default method handles it
}

// -------- @Deprecated usage --------
class OldAPI {
    /**
     * @deprecated Use newCalculate() instead. This method will be removed in future.
     */
    @Deprecated(since = "2.0", forRemoval = true)
    public int calculate(int a, int b) {
        return a + b; // old buggy implementation
    }

    public int newCalculate(int a, int b) {
        // new, improved implementation
        return Integer.sum(a, b);
    }
}

public class R8_BackwardCompatibility {

    @SuppressWarnings({"unchecked", "rawtypes", "deprecation"})
    public static void main(String[] args) {

        System.out.println("====== BACKWARD COMPATIBILITY DEMO ======\n");

        // ---- 1. RAW TYPES (Pre-Generics code — Java 1.4 style) ----
        System.out.println("--- 1. Raw Types (Pre-Generics style — still works!) ---");

        // This old-style code STILL compiles and runs on Java 21
        List rawList = new ArrayList(); // no generic type — raw type
        rawList.add("Hello");
        rawList.add(42);         // mix types — old style
        rawList.add(3.14);
        System.out.println("Raw List (old style): " + rawList);

        // New generic style — type-safe
        List<String> genericList = new ArrayList<>();
        genericList.add("Java 5");
        genericList.add("Java 8");
        genericList.add("Java 21");
        System.out.println("Generic List (new style): " + genericList);

        System.out.println();

        // ---- 2. Legacy Stack vs Modern Stack ----
        System.out.println("--- 2. Legacy vs Modern Stack ---");

        LegacyStack legacy = new LegacyStack();
        legacy.push("item1");
        legacy.push(100);
        System.out.println("Legacy Stack pop: " + legacy.pop()); // returns Object

        ModernStack<String> modern = new ModernStack<>();
        modern.push("Java");
        modern.push("Python");
        System.out.println("Modern Stack pop: " + modern.pop()); // returns String directly

        System.out.println();

        // ---- 3. Default Method — Interface Evolution ----
        System.out.println("--- 3. Default Method (Java 8 — Interface Evolution) ---");

        OldDocument doc = new OldDocument("Annual Report 2024");
        doc.print();            // Original method
        doc.printWithBorder();  // Default method — didn't need to implement!

        Printable.info();       // Static method in interface

        System.out.println();

        // ---- 4. @Deprecated ----
        System.out.println("--- 4. @Deprecated Annotation ---");

        OldAPI api = new OldAPI();
        int old = api.calculate(5, 3);     // Works but shows deprecation warning
        int newResult = api.newCalculate(5, 3); // New way
        System.out.println("Old (deprecated) result: " + old);
        System.out.println("New (preferred) result: " + newResult);

        System.out.println();

        // ---- 5. Date class (famous backward compat trade-off) ----
        System.out.println("--- 5. java.util.Date (kept for backward compat) ---");
        // Date class is broken/confusing but KEPT for backward compatibility
        Date oldDate = new Date(); // deprecated constructors still work
        System.out.println("Old Date (broken but kept): " + oldDate);
        System.out.println("Better alternative: java.time.LocalDate (Java 8+)");

        System.out.println();

        // ---- 6. TYPE ERASURE Demo ----
        System.out.println("--- 6. Type Erasure (Generics Backward Compat Trick) ---");
        // At runtime, List<String> and List<Integer> are BOTH just List (Object)
        List<String> strings = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        System.out.println("List<String> class: " + strings.getClass().getName());
        System.out.println("List<Integer> class: " + integers.getClass().getName());
        System.out.println("Same class? " + strings.getClass().equals(integers.getClass()));
        System.out.println("Type info erased at runtime — backward compat with pre-generics code!");

        System.out.println();

        // ---- 7. Summary ----
        System.out.println("--- KEY BACKWARD COMPAT FEATURES ---");
        System.out.println("1. Raw Types       — pre-generics code still compiles");
        System.out.println("2. Type Erasure    — generics erased at runtime");
        System.out.println("3. Default Methods — new interface behavior without breaking impls");
        System.out.println("4. @Deprecated     — gradual phase-out (warn before remove)");
        System.out.println("5. Varargs         — old fixed-arg calls still work");
        System.out.println("6. Autoboxing      — primitives/wrappers interchangeable");

        System.out.println("\n==========================================");
    }
}
