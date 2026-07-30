package revise;

/*
 * ============================================================
 *  TOPIC: final, static, private KEYWORDS
 * ============================================================
 *
 *  ======================== FINAL ============================
 *  DEFINITION:
 *  The 'final' keyword restricts further modification.
 *  It can be applied to:
 *    - VARIABLE: value cannot be changed (becomes constant).
 *    - METHOD:   cannot be overridden in child class.
 *    - CLASS:    cannot be extended (no child class allowed).
 *
 *  WHY WE USE final IN JAVA:
 *  1. IMMUTABILITY — create constants (final variables).
 *  2. SECURITY — prevent method overriding to avoid tampering.
 *  3. PERFORMANCE — JVM can inline final methods (optimization).
 *  4. DESIGN INTENT — signals "this is complete, don't extend".
 *  5. String, Integer, Math classes are all final in Java!
 *
 *  KEY POINTS:
 *  - final variable: must be initialized at declaration or in constructor.
 *  - final method: inherited but NOT overridable.
 *  - final class: cannot be subclassed (e.g., String, Integer).
 *  - Blank final: declared without value, assigned in constructor.
 *
 * ======================== STATIC ============================
 *  DEFINITION:
 *  The 'static' keyword means the member belongs to the CLASS itself,
 *  NOT to any specific object/instance of the class.
 *  It can be applied to: variables, methods, blocks, nested classes.
 *
 *  WHY WE USE static IN JAVA:
 *  1. SHARED DATA — one copy shared across all instances.
 *  2. MEMORY EFFICIENCY — only one copy in memory (class-level).
 *  3. UTILITY METHODS — Math.sqrt(), Arrays.sort() are static.
 *  4. CONSTANTS — public static final int MAX = 100.
 *  5. FACTORY METHODS — getInstance() in Singleton pattern.
 *  6. Can be called WITHOUT creating an object.
 *
 *  KEY POINTS:
 *  - Static members belong to the CLASS, not to objects.
 *  - Static methods CANNOT access non-static (instance) members directly.
 *  - Static block runs ONCE when class is loaded (initialization).
 *  - Cannot use 'this' or 'super' in static methods.
 *
 * ======================== PRIVATE ============================
 *  DEFINITION:
 *  The 'private' access modifier restricts visibility of a member
 *  to ONLY within the same class. It is the most restrictive
 *  access level in Java.
 *
 *  WHY WE USE private IN JAVA:
 *  1. ENCAPSULATION — hide internal implementation details.
 *  2. DATA PROTECTION — prevent direct modification from outside.
 *  3. CONTROL ACCESS — force use of getters/setters (validation).
 *  4. REDUCES COUPLING — other classes can't depend on internal details.
 *  5. "OOP Pillar" — Encapsulation is built on private fields.
 *
 *  KEY POINTS:
 *  - private field: accessible only within same class.
 *  - private method: accessible only within same class.
 *  - private constructor: prevents object creation from outside (Singleton).
 *  - NOT inherited by subclasses (child can't access parent's private).
 *
 *  ACCESS MODIFIER COMPARISON:
 *  private   → same class only
 *  default   → same package
 *  protected → same package + subclasses
 *  public    → everywhere
 * ============================================================
 */

public class R7_FinalStaticPrivate {

    // ======================== STATIC MEMBERS ========================

    // static variable — shared across ALL instances
    static int instanceCount = 0;

    // static final constant — naming convention: ALL_CAPS
    static final double PI = 3.14159;
    static final int MAX_USERS = 1000;

    // static block — runs ONCE when class is loaded (before main/constructor)
    static {
        System.out.println("[STATIC BLOCK] Class loaded! One-time initialization.");
        instanceCount = 0;
    }

    // ======================== INSTANCE MEMBERS ========================

    // private fields — encapsulation (HAS-A relationship with access control)
    private String name;
    private int age;

    // final instance variable — must be set in constructor (blank final)
    final String id; // This person's ID cannot change after creation

    // Constructor
    R7_FinalStaticPrivate(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id; // blank final initialized here
        instanceCount++;  // static variable shared — tracks total objects
    }

    // ======================== GETTERS / SETTERS (private field access) ========================

    // public getter — controlled read access to private field
    public String getName() {
        return name;
    }

    // public setter — controlled write access with validation
    public void setAge(int age) {
        if (age > 0 && age < 150) {
            this.age = age;
        } else {
            System.out.println("Invalid age! Must be between 0 and 150.");
        }
    }

    public int getAge() {
        return age;
    }

    // private helper method — only used internally
    private String formatInfo() {
        return "[" + id + "] " + name + " (age " + age + ")";
    }

    // public method — uses private helper internally
    public void display() {
        System.out.println("Person: " + formatInfo()); // calling private method
    }

    // static method — belongs to class, can be called without object
    static void showCount() {
        System.out.println("Total persons created: " + instanceCount);
        // System.out.println(name); // COMPILE ERROR — can't access instance var in static
    }

    // static utility method (like Math.max)
    static int add(int a, int b) {
        return a + b;
    }

    // ======================== FINAL METHOD ========================

    // final method — child classes CANNOT override this
    final void showPolicy() {
        System.out.println("Company Policy: No changes allowed! (final method)");
    }

    // ======================== MAIN ========================

    public static void main(String[] args) {

        System.out.println("====== final, static, private KEYWORDS DEMO ======\n");

        // ---- 1. STATIC DEMO ----
        System.out.println("--- 1. STATIC DEMO ---");

        // Call static method WITHOUT creating any object
        System.out.println("Static PI constant: " + R7_FinalStaticPrivate.PI);
        System.out.println("Static MAX_USERS: " + R7_FinalStaticPrivate.MAX_USERS);
        System.out.println("Static add(5, 3): " + R7_FinalStaticPrivate.add(5, 3));

        R7_FinalStaticPrivate.showCount(); // 0 before any objects

        System.out.println();

        // ---- 2. Creating Objects (instanceCount updates) ----
        System.out.println("--- 2. OBJECT CREATION (static counter) ---");
        R7_FinalStaticPrivate p1 = new R7_FinalStaticPrivate("Alice", 25, "ID001");
        R7_FinalStaticPrivate p2 = new R7_FinalStaticPrivate("Bob", 30, "ID002");
        R7_FinalStaticPrivate p3 = new R7_FinalStaticPrivate("Charlie", 22, "ID003");

        // static variable updated across ALL objects
        showCount(); // 3 — shared count

        System.out.println();

        // ---- 3. PRIVATE DEMO ----
        System.out.println("--- 3. PRIVATE DEMO ---");

        // p1.name = "Hacker"; // COMPILE ERROR — 'name' is private!
        // p1.age = -5;        // COMPILE ERROR — 'age' is private!

        // Must use public getter/setter
        System.out.println("Get name (via getter): " + p1.getName());
        p1.setAge(26); // setter validates
        p1.setAge(-99); // invalid — setter rejects
        System.out.println("Get age (via getter): " + p1.getAge());

        p1.display(); // internally uses private formatInfo()
        p2.display();
        p3.display();

        System.out.println();

        // ---- 4. FINAL VARIABLE DEMO ----
        System.out.println("--- 4. FINAL VARIABLE DEMO ---");

        System.out.println("p1's ID (final): " + p1.id);
        // p1.id = "NEW_ID"; // COMPILE ERROR — 'id' is final, can't reassign!

        // final local variable
        final int MAX_SCORE = 100;
        // MAX_SCORE = 200; // COMPILE ERROR — final local var can't change
        System.out.println("Final local var MAX_SCORE: " + MAX_SCORE);

        System.out.println();

        // ---- 5. FINAL METHOD DEMO ----
        System.out.println("--- 5. FINAL METHOD DEMO ---");
        p1.showPolicy(); // Final method — works, but CANNOT be overridden

        System.out.println();

        // ---- 6. FINAL CLASS DEMO (shown via String) ----
        System.out.println("--- 6. FINAL CLASS (e.g., String in Java) ---");
        // String is a final class — you cannot extend it:
        // class MyString extends String {} // COMPILE ERROR!
        String str = "Hello";
        System.out.println("String is a final class in Java: " + str.getClass().getName());
        System.out.println("Cannot extend String or Integer — they are final classes.");

        System.out.println();

        // ---- 7. Summary Table ----
        System.out.println("--- SUMMARY TABLE ---");
        System.out.println("Keyword  | Applied To       | Effect");
        System.out.println("---------|------------------|-------------------------------");
        System.out.println("final    | variable         | Value cannot be reassigned");
        System.out.println("final    | method           | Cannot be overridden");
        System.out.println("final    | class            | Cannot be extended");
        System.out.println("static   | variable         | Shared across all instances");
        System.out.println("static   | method           | Called without object");
        System.out.println("static   | block            | Runs once at class loading");
        System.out.println("private  | field/method     | Accessible only within class");
        System.out.println("private  | constructor      | Prevents object creation (Singleton)");

        System.out.println("\n==================================================");
    }
}

// ======================== FINAL CLASS DEMO ========================
// This class CANNOT be extended by anyone
final class MathUtils {
    static final double E = 2.71828;

    static double square(double n) {
        return n * n;
    }
    // No class can do: class MyMath extends MathUtils {} // COMPILE ERROR
}

// ======================== PRIVATE CONSTRUCTOR (Singleton Pattern) ========================
class DatabaseConnection {
    private static DatabaseConnection instance; // static single instance

    // private constructor — no one outside can do: new DatabaseConnection()
    private DatabaseConnection() {
        System.out.println("DB Connection established!");
    }

    // static factory method — only way to get the single instance
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void query(String sql) {
        System.out.println("Executing: " + sql);
    }
}
