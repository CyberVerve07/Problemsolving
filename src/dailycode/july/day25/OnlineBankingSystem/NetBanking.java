package dailycode.july.day25.onlinebankingsystem;

/**
 * NetBanking â€” Implements PaymentService for internet banking payments.
 *
 * INTERVIEW: What is Loose Coupling?
 * â†’ PaymentService interface makes the system LOOSELY COUPLED.
 * â†’ Main.java doesn't need to know about NetBanking specifically â€” it only knows PaymentService.
 * â†’ We can ADD new payment methods (e.g., CryptoPay) WITHOUT modifying existing code.
 * â†’ This follows the OPEN-CLOSED PRINCIPLE (open for extension, closed for modification).
 *
 * JAVA TYPE: class implementing interface
 * OOP PILLAR: Abstraction + Polymorphism
 *
 * @author Aditya
 * @version 2.0
 * @see PaymentService
 */
public class NetBanking implements PaymentService {

    /**
     * Processes payment using net banking.
     */
    @Override
    public void processPayment() {
        System.out.println("Payment is done by using the NetBanking.");
    }
}
