package DesignPattens.factory;

/**
 * Client / Driver Class:
 * Demonstrates how client code uses PaymentFactory without
 * knowing the specific concrete classes directly.
 */
public class PaymentDemo {
    public static void main(String[] args) {
        System.out.println("=== Factory Design Pattern: Payment Service ===\n");

        // 1. Process UPI Payment
        Payment upiPayment = PaymentFactory.createPayment("UPI");
        upiPayment.pay(2499.00);

        // 2. Process Credit Card Payment
        Payment cardPayment = PaymentFactory.createPayment("CREDIT_CARD");
        cardPayment.pay(899.50);

        // 3. Process PayPal Payment
        Payment paypalPayment = PaymentFactory.createPayment("PAYPAL");
        paypalPayment.pay(49.99);

        // 4. Handling Invalid Payment Type gracefully
        try {
            Payment invalidPayment = PaymentFactory.createPayment("CRYPTO");
            invalidPayment.pay(100.00);
        } catch (IllegalArgumentException e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }
}
