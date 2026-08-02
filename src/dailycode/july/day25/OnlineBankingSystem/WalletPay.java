package dailycode.july.day25.onlinebankingsystem;

/**
 * WalletPay â€” Implements PaymentService for digital wallet payments (PhonePe, Paytm, etc.).
 *
 * INTERVIEW: What is Polymorphism with Interfaces?
 * â†’ PaymentService ref = new WalletPay();  // Interface reference holding child object
 * â†’ ref.processPayment();                  // JVM calls WalletPay's version at RUNTIME
 * â†’ This is RUNTIME POLYMORPHISM â€” the method to call is decided at runtime based on
 *   the ACTUAL object type, not the reference type.
 *
 * JAVA TYPE: class implementing interface
 * OOP PILLAR: Polymorphism + Abstraction
 *
 * @author Aditya
 * @version 2.0
 * @see PaymentService
 */
public class WalletPay implements PaymentService {

    /**
     * Processes payment using digital wallet (PhonePe).
     */
    @Override
    public void processPayment() {
        System.out.println("Payment is done by using PhonePe.");
    }
}
