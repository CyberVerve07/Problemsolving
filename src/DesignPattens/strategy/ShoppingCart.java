package DesignPattens.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Context Class:
 * Maintains a reference to a Strategy object and delegates the execution.
 * Allows client code to dynamically switch strategies at runtime without
 * modifying the context logic.
 */
public class ShoppingCart {
    private final List<Double> items = new ArrayList<>();
    private PaymentStrategy paymentStrategy;

    public void addItem(double price) {
        items.add(price);
    }

    public double calculateTotal() {
        return items.stream().mapToDouble(Double::doubleValue).sum();
    }

    // Allows dynamic switching of strategy at runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout() {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not set! Please select a payment method before checkout.");
        }
        double total = calculateTotal();
        if (total <= 0) {
            System.out.println("Cart is empty! Nothing to checkout.");
            return;
        }
        System.out.println("Initiating checkout for cart total: ₹" + total);
        paymentStrategy.pay(total);
        items.clear(); // Reset cart after successful payment
        System.out.println("Order completed successfully.\n");
    }
}
