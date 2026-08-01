package oops.interphases;

/**
 * Paytm — Implements the Payment interface for Paytm wallet payments.
 *
 * INTERVIEW: What happens when a class implements an interface?
 * → The class signs a CONTRACT — it MUST provide body for ALL abstract methods.
 * → If it doesn't, the class must be declared 'abstract'.
 * → @Override annotation ensures the method signature matches the interface method.
 *
 * TYPO FIX: Output message corrected from "PAy using Paytem" → "Pay using Paytm".
 *
 * JAVA TYPE: class implementing interface
 * OOP PILLAR: Abstraction + Polymorphism
 *
 * @author Aditya
 * @version 2.0
 * @see Payment
 */
public class Paytrm implements Payment {

    /**
     * Processes payment using Paytm wallet.
     */
    @Override
    public void pay() {
        System.out.println("Pay using Paytm.");
    }
}
