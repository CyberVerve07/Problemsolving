package dailycode.july.day25.onlinebankingsystem;

/**
 * CardPayment â€” Implements the PaymentService interface for credit/debit card payments.
 *
 * INTERVIEW DEFINITION â€” 'implements' keyword:
 * â†’ 'implements' is used to make a class agree to the CONTRACT of an interface.
 * â†’ The class MUST provide body for ALL abstract methods declared in the interface.
 * â†’ A class can implement MULTIPLE interfaces (achieves multiple inheritance in Java).
 *
 * EXAMPLE:
 *   PaymentService card = new CardPayment();  // Upcasting (Interface reference â†’ child object)
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
     * â†’ Even though we are implementing (not overriding a class method), @Override is
     *   used to tell the compiler we are fulfilling the interface contract.
     * â†’ If the method signature doesn't match the interface, compiler gives an ERROR.
     */
    @Override
    public void processPayment() {
        System.out.println("Payment is Done by using Credit Card.");
    }
}
