package oops.netflix;

/**
 * UpgradePlan — Handles subscription plan upgrades.
 *
 * INTERVIEW: What design pattern does this follow?
 * → This is similar to the FACTORY PATTERN — a method that creates and returns
 *   different objects (Subscription types) based on input (choice).
 * → The caller doesn't need to know which specific class to instantiate.
 *
 * @author Aditya
 * @version 2.0
 */
public class UpgradePlan {

    /**
     * Upgrades/selects a subscription plan based on user choice.
     *
     * INTERVIEW: What is the Factory Pattern?
     * → A creational design pattern where a method creates objects without exposing
     *   the exact class of the object being created.
     * → Client code: planner.upgrade(3) → gets back a PremiumSubscription
     *   without knowing the PremiumSubscription class directly.
     *
     * @param choice int — 1 for Basic, 2 for Standard, 3 for Premium
     * @return Subscription — the selected subscription plan, or null for invalid choice
     */
    public Subscription upgrade(int choice) {
        if (choice == 1) {
            return new BasicSubscription("Basic", 399, "Mobile", "720p");
        } else if (choice == 2) {
            return new StandardSubscription("Standard", 799, "Mobile/Tablet/Laptop", "1080p");
        } else if (choice == 3) {
            return new PremiumSubscription("Premium", 1499, "Mobile/Tablet/Laptop/TV", "4K HDR");
        } else {
            System.out.println("Invalid Choice! Please choose 1, 2, or 3.");
            return null;
        }
    }
}
