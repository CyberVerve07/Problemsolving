package oops.interfaces;

/**
 * Main â€” Demonstrates Interface Polymorphism (Upcasting with Interfaces).
 *
 * INTERVIEW DEFINITION â€” Interface Polymorphism:
 * -------------------------------------------------
 * Q: What is Upcasting with Interfaces?
 * A: When an INTERFACE reference holds a child class object.
 *    Example: Payment p = new PhonePe();
 *    â†’ 'p' is of type Payment (interface), but points to PhonePe (implementation).
 *    â†’ p.pay() â†’ calls PhonePe's pay() at RUNTIME (Dynamic Method Dispatch).
 *
 * Q: How does Polymorphism work here?
 * A: 1. Payment p = new PhonePe();  â†’ p.pay() calls PhonePe's version
 *    2. Payment g = new GooglePay(); â†’ g.pay() calls GooglePay's version
 *    â†’ Same method call (pay()), DIFFERENT behavior â€” this is POLYMORPHISM!
 *
 * JAVA TYPE: class (driver class)
 * OOP PILLAR: Polymorphism (Runtime via Interfaces)
 *
 * @author Aditya
 * @version 2.0
 */
public class Main {

    public static void main(String[] args) {
        // Interface reference holding implementation objects â€” UPCASTING
        Payment p = new PhonePe();
        Payment g = new GooglePay();

        // Runtime Polymorphism â€” JVM calls the ACTUAL object's pay() method
        p.pay();  // â†’ calls PhonePe's pay()
        g.pay();  // â†’ calls GooglePay's pay()
    }
}
