package dailycode.july.day25.onlinebankingsystem;

/**
 * UpiPayment â€” Implements PaymentService for UPI-based payments (Google Pay, PhonePe, etc.).
 *
 * INTERVIEW DEFINITION â€” Encapsulation in Action:
 * â†’ This class demonstrates ENCAPSULATION â€” all fields (name, upiId, pin) are PRIVATE.
 * â†’ Fields are set via the CONSTRUCTOR (no setters needed for immutable data).
 * â†’ Outside code cannot access or modify the UPI PIN directly â€” data is HIDDEN.
 *
 * INTERVIEW: What is Encapsulation?
 * â†’ Encapsulation is the process of WRAPPING data (fields) and methods that operate on
 *   that data into a SINGLE UNIT (class), and RESTRICTING direct access to the data
 *   using access modifiers (private, protected, public).
 *
 * JAVA TYPE: class implementing interface
 * OOP PILLAR: Encapsulation + Abstraction
 *
 * @author Aditya
 * @version 2.0
 * @see PaymentService
 */
public class UpiPayment implements PaymentService {

    /** Name of the UPI account holder â€” private for data hiding */
    private String name;

    /** UPI ID (e.g., "aditya@upi") â€” private for security */
    private String upiId;

    /** UPI PIN â€” private for SECURITY (never expose payment credentials) */
    private int pin;

    /**
     * Constructor â€” initializes UPI payment with user credentials.
     *
     * @param name  String â€” account holder name
     * @param upiId String â€” UPI ID (e.g., "user@bank")
     * @param pin   int â€” 4 or 6 digit UPI PIN
     */
    public UpiPayment(String name, String upiId, int pin) {
        this.name = name;
        this.upiId = upiId;
        this.pin = pin;
    }

    /**
     * Processes UPI payment and displays UPI ID.
     */
    @Override
    public void processPayment() {
        System.out.println("Payment is Done By Using UPI (Google Pay) | UPI ID: " + upiId);
    }
}
