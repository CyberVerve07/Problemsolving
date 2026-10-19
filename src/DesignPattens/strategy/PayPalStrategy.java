package DesignPattens.strategy;

/**
 * Concrete Strategy 3: PayPal Payment
 */
public class PayPalStrategy implements PaymentStrategy {
    private final String email;

    public PayPalStrategy(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.printf("[PayPal] Paid ₹%.2f successfully using account: %s%n", amount, email);
    }
}
