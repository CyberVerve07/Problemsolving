package oops.InterPhases;

/**
 * Main — Demonstrates Interface Polymorphism (Upcasting with Interfaces).
 *
 * INTERVIEW DEFINITION — Interface Polymorphism:
 * -------------------------------------------------
 * Q: What is Upcasting with Interfaces?
 * A: When an INTERFACE reference holds a child class object.
 *    Example: Payment p = new PhonePe();
 *    → 'p' is of type Payment (interface), but points to PhonePe (implementation).
 *    → p.pay() → calls PhonePe's pay() at RUNTIME (Dynamic Method Dispatch).
 *
 * Q: How does Polymorphism work here?
 * A: 1. Payment p = new PhonePe();  → p.pay() calls PhonePe's version
 *    2. Payment g = new GoogelPay(); → g.pay() calls GoogelPay's version
 *    → Same method call (pay()), DIFFERENT behavior — this is POLYMORPHISM!
 *
 * NAMING NOTE: Class name is 'main' (lowercase) — violates Java conventions.
 * Java class names should be PascalCase (e.g., 'Main'). Kept as-is to avoid file rename issues.
 *
 * @author Aditya
 * @version 2.0
 */
public class main {

    public static void main(String[] args) {
        // Interface reference holding implementation objects — UPCASTING
        Payment p = new PhonePe();
        Payment g = new GoogelPay();

        // Runtime Polymorphism — JVM calls the ACTUAL object's pay() method
        p.pay();  // → calls PhonePe's pay()
        g.pay();  // → calls GoogelPay's pay()
    }
}
