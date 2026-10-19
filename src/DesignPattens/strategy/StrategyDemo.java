package DesignPattens.strategy;

/**
 * Driver / Demo Class:
 * Demonstrates the Strategy Design Pattern.
 * - Strategy encapsulates interchangeable algorithms.
 * - Context delegates work to the strategy.
 * - Client can switch strategies dynamically at runtime (Open/Closed Principle).
 */
public class StrategyDemo {
    public static void main(String[] args) {
        System.out.println("=== Strategy Design Pattern: Payment Processing ===\n");

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(499.00);
        cart.addItem(1500.50);

        // 1. Pay using UPI Strategy
        System.out.println("--- Scenario 1: Customer selects UPI ---");
        cart.setPaymentStrategy(new UPIStrategy("user@okaxis"));
        cart.checkout();

        // 2. Add new items and pay using Credit Card Strategy
        System.out.println("--- Scenario 2: Customer selects Credit Card ---");
        cart.addItem(3200.00);
        cart.setPaymentStrategy(new CreditCardStrategy("1234567890123456", "John Doe"));
        cart.checkout();

        // 3. Switch strategy at runtime (e.g., fallback if a method fails)
        System.out.println("--- Scenario 3: Switching Strategy dynamically to PayPal ---");
        cart.addItem(750.00);
        cart.setPaymentStrategy(new PayPalStrategy("john.doe@example.com"));
        cart.checkout();

        // 4. Modern Java: Strategy using Lambda Expression
        System.out.println("--- Scenario 4: Modern Java Strategy using Lambda (e.g., Crypto / Gift Card) ---");
        cart.addItem(1200.00);
        cart.setPaymentStrategy(amount -> System.out.printf("[Gift Card] Redeemed gift coupon for ₹%.2f%n", amount));
        cart.checkout();
    }
}
