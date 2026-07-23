package dailycode.july22.PaymentGateway;

public class Main {
    public static void main(String[] args) {

        // Create Process object — the orchestrator
        Process process = new Process();

        System.out.println("========================================");
        System.out.println("        PAYMENT GATEWAY SYSTEM          ");
        System.out.println("========================================");

        // ✅ GPay (UPI) Payment — balance auto-updates after payment
        System.out.println("\n--- G-Pay Payment ---");
        PaymentGateway gpay = new UpiPAyment(900.0, "Aditya", "73084403083");
        process.done(gpay);   // calls pay() → processPayment() → balance updates

        // ✅ Credit Card Payment — balance auto-updates after payment
        System.out.println("\n--- Credit Card Payment ---");
        PaymentGateway creditCard = new CreditCard("Prachi", "3838338309", 9208);
        process.done(creditCard);  // calls pay() → processPayment() → balance updates

        // ✅ Debit Card Payment — balance auto-updates after payment
        System.out.println("\n--- Debit Card Payment ---");
        PaymentGateway debitCard = new DebitCard(5000.0, "Prashant", "93039393029");
        process.done(debitCard);   // calls pay() → processPayment() → balance updates

        // NetBanking with deposit first then pay
        System.out.println("\n--- NetBanking Payment (Deposit first) ---");
        NetBanking netBanking = new NetBanking(3000, "Raj", "93039393029");
        process.depositAndPay(netBanking);

    }
}
