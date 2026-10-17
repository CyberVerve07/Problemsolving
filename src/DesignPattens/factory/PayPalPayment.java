package DesignPattens.factory;

/**
 * Concrete Product 3:
 * Implementation of Payment via PayPal.
 */
public class PayPalPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal payment of $" + amount + " [SUCCESS]");
    }
}
