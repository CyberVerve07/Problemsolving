package oops.netflix;

/**
 * StandardSubscription — Represents the Standard tier Netflix plan.
 *
 * @author Aditya
 * @version 2.0
 * @see Subscription
 */
public class StandardSubscription extends Subscription {

    /**
     * @param planName     String — plan name
     * @param price        double — monthly price
     * @param maxScreen    String — supported screens
     * @param videoQuality String — video quality
     */
    public StandardSubscription(String planName, double price, String maxScreen, String videoQuality) {
        super(planName, price, maxScreen, videoQuality);
    }
}
