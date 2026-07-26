package oops.Netflix;

/**
 * BasicSubscription — Represents the Basic tier Netflix plan.
 *
 * INTERVIEW: What is Hierarchical Inheritance?
 * → When ONE parent class has MULTIPLE child classes.
 * → Subscription → BasicSubscription, StandardSubscription, PremiumSubscription.
 * → All children inherit the same parent structure but can add unique behavior.
 *
 * @author Aditya
 * @version 2.0
 * @see Subscription
 */
public class BasicSubscription extends Subscription {

    /**
     * Constructor — passes all parameters to parent via super().
     *
     * @param planName     String — plan name
     * @param price        double — monthly price
     * @param maxScreen    String — supported screens
     * @param videoQuality String — video quality
     */
    public BasicSubscription(String planName, double price, String maxScreen, String videoQuality) {
        super(planName, price, maxScreen, videoQuality);
    }
}
