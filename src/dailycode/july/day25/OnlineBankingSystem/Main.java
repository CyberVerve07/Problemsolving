package dailycode.july.day25.onlinebankingsystem;

/**
 * Main — Entry point for the Online Banking System demonstration.
 *
 * INTERVIEW DEFINITION — Upcasting:
 * ------------------------------------
 * Q: What is Upcasting?
 * A: Upcasting is when a PARENT class reference holds a CHILD class object.
 *    Example: AccountManagement savings = new SavingsAccount(...);
 *    → 'savings' is of type AccountManagement (parent), but points to SavingsAccount (child).
 *    → Upcasting happens IMPLICITLY (automatically) — no casting syntax needed.
 *
 * Q: Why do we use Upcasting?
 * A: 1. POLYMORPHISM — call overridden methods that execute child's version at runtime.
 *    2. FLEXIBILITY — write generic code that works with any subclass.
 *    3. COLLECTIONS — store different subtypes in same collection (List<AccountManagement>).
 *
 * Q: What is Dynamic Method Dispatch?
 * A: When the JVM decides at RUNTIME which overridden method to call based on the
 *    ACTUAL OBJECT TYPE (not reference type). This is the mechanism behind runtime polymorphism.
 *    Example: savings.withdrawal(500) → calls SavingsAccount's withdrawal(), not AccountManagement's.
 *
 * JAVA TYPE: class (main entry point)
 * OOP CONCEPTS DEMONSTRATED: Upcasting, Polymorphism, Abstraction, Interfaces
 *
 * @author Aditya
 * @version 2.0
 */
public class Main {

    /**
     * Main method — JVM entry point.
     *
     * INTERVIEW: What is 'public static void main(String[] args)'?
     * → 'public'         = accessible from anywhere (JVM needs to access it).
     * → 'static'         = can be called WITHOUT creating an object of the class.
     * → 'void'           = returns nothing.
     * → 'main'           = method name recognized by JVM as entry point.
     * → 'String[] args'  = command-line arguments passed to the program.
     *
     * @param args String[] — command line arguments
     */
    public static void main(String[] args) {

        // ======== SAVINGS ACCOUNT ========
        // UPCASTING: Parent reference (AccountManagement) holds child object (SavingsAccount)
        System.out.println("========== SAVINGS ACCOUNT ==========");
        AccountManagement savings = new SavingsAccount("Aditya", "7389330032", 7000);
        System.out.println("Account Type  : " + savings.accountType());
        savings.depositMoney(800);
        savings.withdrawal(500);
        savings.withdrawal(10000); // should fail — below min balance
        System.out.println("Interest (7.5%): ₹" + savings.calculateInterest());
        savings.checkBalance();

        System.out.println();

        // ======== CURRENT ACCOUNT ========
        // UPCASTING: Same parent reference, different child — Polymorphism in action!
        System.out.println("========== CURRENT ACCOUNT ==========");
        AccountManagement current = new CurrentAccount("Rohit", "9876543210", 5000);
        System.out.println("Account Type  : " + current.accountType());
        current.depositMoney(1000);
        current.withdrawal(2000);
        current.withdrawal(20000); // overdraft — should work up to ₹10,000 limit
        System.out.println("Interest      : ₹" + current.calculateInterest());

        System.out.println();

        // ======== PAYMENT SERVICES ========
        // INTERFACE POLYMORPHISM: PaymentService reference holds different implementations
        System.out.println("========== PAYMENT SERVICES ==========");
        PaymentService card = new CardPayment();
        PaymentService net = new NetBanking();
        PaymentService upi = new UpiPayment("Aditya", "aditya@upi", 1234);
        PaymentService wallet = new WalletPay();
        card.processPayment();
        net.processPayment();
        upi.processPayment();
        wallet.processPayment();

        System.out.println();

        // ======== TRANSACTION ========
        System.out.println("========== TRANSACTION ==========");
        Transaction t1 = new Transaction("TXN001", "7389330032", "9876543210",
                500.0, "2026-07-25 14:00", "SUCCESS");
        t1.showDetails();

        // ======== RECEIPT ========
        System.out.println("========== RECEIPT ==========");
        Receipt r1 = new Receipt("RCP001", "TXN001", 500.0, "2026-07-25 14:00");
        r1.generate();
        r1.showReceipt(); // FIX: renamed from showRecipt() → showReceipt()
    }
}