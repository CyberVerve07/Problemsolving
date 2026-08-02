package dailycode.july.day25.onlinebankingsystem.interfaces;

/**
<<<<<<< HEAD
=======
 * INTERVIEW DEFINITION â€” Functional Interface:
>>>>>>> fe85f421d2cb682cb4100dcce38957fd3f187bcd
 * -----------------------------------------------
 * Q: What is a Functional Interface?
 * A: A Functional Interface is an interface that contains EXACTLY ONE abstract method.
 *    It is annotated with @FunctionalInterface to tell the compiler to enforce this rule.
 *    It can have any number of default, static, and private methods â€” but only ONE abstract.
 *
 * Q: Why do we use Functional Interface?
 * A: 1. To enable LAMBDA EXPRESSIONS â€” lambdas can only be used with functional interfaces.
 *    2. To promote FUNCTIONAL PROGRAMMING in Java (since Java 8).
 *    3. To write CONCISE, READABLE code (replace anonymous inner classes with lambdas).
 *
 * Q: What is @FunctionalInterface annotation?
 * A: It is a MARKER that tells the compiler: "This interface must have exactly ONE abstract method."
 *    If you accidentally add a second abstract method, the compiler gives an ERROR.
 *    NOTE: @FunctionalInterface is optional â€” any interface with one abstract method IS a
 *    functional interface, but the annotation provides compile-time safety.
 *
 * Q: What are the 3 Types of Interfaces in Java?
 * A: 1. MARKER Interface â€” has ZERO methods (e.g., Serializable, Cloneable).
 *       â†’ Used to mark/tag a class with metadata.
 *    2. NORMAL Interface â€” has ANY NUMBER of abstract methods (e.g., List, Map).
 *       â†’ Traditional interface with multiple behaviors.
 *    3. FUNCTIONAL Interface â€” has EXACTLY ONE abstract method (e.g., Runnable, Comparator).
 *       â†’ Used with lambda expressions for functional programming.
 *
 * Q: What methods can a Functional Interface have?
 * A: - Exactly 1 abstract method (the functional method).
 *    - Any number of DEFAULT methods (with body, added in Java 8).
 *    - Any number of STATIC methods (with body, added in Java 8).
 *    - Any number of PRIVATE methods (helper methods, added in Java 9).
 *
 * JAVA TYPE: @FunctionalInterface interface
 * OOP PILLAR: Abstraction + Functional Programming
 *
 * @author Aditya
 * @version 2.0
 */
@FunctionalInterface
public interface Product {

    /**
     * The SINGLE abstract method â€” this is the functional method.
     * Methods in an interface are implicitly 'public' and 'abstract'.
     * This method can be implemented using a lambda expression:
     *   Product p = (message) -> System.out.println(message);
     *
     * @param message String â€” the message to publish
     */
    void publish(String message);

    // ======================== DEFAULT METHODS (Java 8+) ========================

    /**
     * INTERVIEW: What is a Default Method?
     * â†’ A method in an interface WITH a body (implementation).
     * â†’ Added in Java 8 to allow interface evolution without breaking existing code.
     * â†’ Implementing classes INHERIT this method but can also OVERRIDE it.
     * â†’ Keyword: 'default'
     */
    default void print() {
        System.out.println("Default print method in Product interface.");
    }

    /**
     * Another default method â€” interfaces can have MULTIPLE default methods.
     */
    default void hi() {
        System.out.println("Hi from Product interface!");
    }

    // ======================== STATIC METHODS (Java 8+) ========================

    /**
     * INTERVIEW: What is a Static Method in an Interface?
     * â†’ A method that belongs to the INTERFACE itself, not to any implementing class.
     * â†’ Called using: Product.println();  (NOT through an object reference).
     * â†’ CANNOT be overridden by implementing classes.
     * â†’ Used for utility/helper methods related to the interface.
     */
    static void println() {
        System.out.println("Static println method in Product interface.");
    }

    /**
     * Another static method â€” interfaces can have MULTIPLE static methods.
     */
    static void hello() {
        System.out.println("Hello from Product interface!");
    }

    // ======================== PRIVATE METHODS (Java 9+) ========================

    /**
     * INTERVIEW: What is a Private Method in an Interface?
     * â†’ Added in Java 9 to allow code reuse WITHIN the interface.
     * â†’ Cannot be accessed from outside the interface or from implementing classes.
     * â†’ Used as HELPER methods for default/static methods (avoid code duplication).
     */
    static void helperMethod() {
        System.out.println("Private helper method â€” only accessible within this interface.");
    }
}
