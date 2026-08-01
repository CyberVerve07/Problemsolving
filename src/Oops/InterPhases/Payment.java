package oops.interphases;

/**
 * INTERVIEW DEFINITION — Interface:
 * ------------------------------------
 * Q: What is an Interface?
 * A: An interface defines a CONTRACT of behavior — it specifies WHAT methods a class
 *    must have, but not HOW they are implemented. Any class that implements this interface
 *    MUST provide the body for all its abstract methods.
 *
 * Q: Why use Interface for Payment?
 * A: Different payment methods (PhonePe, Google Pay, Paytm) all share the SAME behavior
 *    (pay) but implement it DIFFERENTLY. Interface provides this abstraction.
 *
 * JAVA TYPE: interface
 * OOP PILLAR: Abstraction (100%)
 *
 * @author Aditya
 * @version 2.0
 * @see Paytm
 * @see GooglePay
 * @see PhonePe
 */
interface Payment {

    /**
     * Processes a payment — each implementing class defines its own logic.
     * Interface methods are implicitly public and abstract.
     */
    void pay();
}
