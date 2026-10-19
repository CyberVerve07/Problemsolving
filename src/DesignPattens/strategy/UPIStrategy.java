package DesignPattens.strategy;

/**
 * Concrete Strategy 2: UPI Payment
 */
public class UPIStrategy implements PaymentStrategy {
    private final String upiId;

    public UPIStrategy(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) {
        System.out.printf("[UPI] Paid ₹%.2f successfully via UPI ID: %s%n", amount, upiId);
    }
}
