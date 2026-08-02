package oops.interfaces;

/**
 * Paytm Ã¢â‚¬â€ Implements the Payment interface for Paytm wallet payments.
 *
 * INTERVIEW: What happens when a class implements an interface?
 * Ã¢â€ â€™ The class signs a CONTRACT Ã¢â‚¬â€ it MUST provide body for ALL abstract methods.
 * Ã¢â€ â€™ If it doesn't, the class must be declared 'abstract'.
 * Ã¢â€ â€™ @Override annotation ensures the method signature matches the interface method.
 *
 * TYPO FIX: Output message corrected from "PAy using Paytem" Ã¢â€ â€™ "Pay using Paytm".
 *
 * JAVA TYPE: class implementing interface
 * OOP PILLAR: Abstraction + Polymorphism
 *
 * @author Aditya
 * @version 2.0
 * @see Payment
 */
public class Paytm implements Payment {

    /**
     * Processes payment using Paytm wallet.
     */
    @Override
    public void pay() {
        System.out.println("Pay using Paytm.");
    }
}
