package dailycode.july25.OnlineBankingSystem;

/**
 * INTERVIEW DEFINITION — Interface:
 * -----------------------------------
 * Q: What is an Interface in Java?
 * A: An interface is a BLUEPRINT of behavior that defines WHAT a class must do,
 *    but NOT HOW it does it. It contains abstract methods (no body) that implementing
 *    classes MUST override. It is declared using the 'interface' keyword.
 *
 * Q: Why do we use Interfaces?
 * A: 1. To achieve 100% ABSTRACTION (before Java 8).
 *    2. To achieve MULTIPLE INHERITANCE — a class can implement multiple interfaces.
 *    3. To define a CONTRACT — any class implementing PaymentService MUST have processPayment().
 *    4. LOOSE COUPLING — code depends on interface, not on specific implementation.
 *    5. POLYMORPHISM — PaymentService ref can point to CardPayment, UpiPayment, etc.
 *
 * Q: Interface vs Abstract Class?
 * A: | Feature              | Interface                  | Abstract Class           |
 *    |----------------------|----------------------------|--------------------------|
 *    | Methods              | All abstract (before Java8)| Both abstract + concrete |
 *    | Variables            | Only public static final   | Any type of variable     |
 *    | Constructor          | ❌ NOT allowed             | ✅ Allowed               |
 *    | Multiple Inheritance | ✅ A class can implement N | ❌ Can extend only ONE   |
 *    | Keyword              | implements                 | extends                  |
 *    | Access Modifiers     | All methods are public     | Can have any modifier    |
 *
 * Q: What does 'implements' keyword mean?
 * A: 'implements' is used when a class agrees to fulfill the CONTRACT of an interface.
 *    The class MUST provide implementations for ALL abstract methods of the interface.
 *
 * NOTE: Interface methods are implicitly 'public' and 'abstract'.
 *       Interface variables are implicitly 'public', 'static', and 'final'.
 *
 * JAVA TYPE: interface
 * OOP PILLAR: Abstraction (100%)
 *
 * @author Aditya
 * @version 2.0
 * @see CardPayment
 * @see NetBanking
 * @see UpiPayment
 * @see WalletPay
 */
public interface PaymentService {

    /**
     * Processes a payment — each implementing class defines its own payment logic.
     *
     * NOTE: This is NOT an abstract method in the traditional sense — in an interface,
     * ALL methods are implicitly abstract (no need to write 'abstract' keyword).
     * The implementing class MUST provide the body for this method.
     */
    void processPayment();
}
