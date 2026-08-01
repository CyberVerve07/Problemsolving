package dailycode.july.day25.onlinebankingsystem;

/**
 * CardPayment — Implements the PaymentService interface for credit/debit card payments.
 *
 * INTERVIEW DEFINITION — 'implements' keyword:
 * → 'implements' is used to make a class agree to the CONTRACT of an interface.
 * → The class MUST provide body for ALL abstract methods declared in the interface.
 * → A class can implement MULTIPLE interfaces (achieves multiple inheritance in Java).
 *
 * EXAMPLE:
 *   PaymentService card = new CardPayment();  // Upcasting (Interface reference → child object)
 *   card.processPayment();                    // Calls CardPayment's version at RUNTIME
 *
 * JAVA TYPE: class implementing interface
 * OOP PILLAR: Abstraction + Polymorphism
 *
 * @author Aditya
 * @version 2.0
 * @see PaymentService
 */
public class CardPayment implements PaymentService {

    /**
     * Processes payment using a credit/debit card.
     *
     * INTERVIEW: Why @Override here?
     * → Even though we are implementing (not overriding a class method), @Override is
     *   used to tell the compiler we are fulfilling the interface contract.
     * → If the method signature doesn't match the interface, compiler gives an ERROR.
     */
    @Override
    public void processPayment() {
        System.out.println("Payment is Done by using Credit Card.");
    }
}
