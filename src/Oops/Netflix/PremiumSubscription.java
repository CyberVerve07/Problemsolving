package oops.Netflix;

/**
 * PremiumSubscription — Represents the Premium tier Netflix plan (4K HDR, all screens).
 *
 * @author Aditya
 * @version 2.0
 * @see Subscription
 */
public class PremiumSubscription extends Subscription {

    /**
     * @param planName     String — plan name
     * @param price        double — monthly price
     * @param maxScreen    String — supported screens
     * @param videoQuality String — video quality
     */
    public PremiumSubscription(String planName, double price, String maxScreen, String videoQuality) {
        super(planName, price, maxScreen, videoQuality);
    }
}
