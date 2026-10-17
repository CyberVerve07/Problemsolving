package DesignPattens.factory;

/**
 * Concrete Product 2:
 * Implementation of Payment via UPI (Google Pay, PhonePe, etc.).
 */
public class UPIPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Processing UPI payment of INR " + amount + " [SUCCESS]");
    }
}
