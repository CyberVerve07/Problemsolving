package DesignPattens.factory;

/**
 * Concrete Product 1:
 * Implementation of Payment via Credit Card.
 */
public class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Processing Credit Card payment of $" + amount + " [SUCCESS]");
    }
}
