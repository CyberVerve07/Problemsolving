package oops.Netflix;

/**
 * Subscription — Parent class for all Netflix subscription types.
 *
 * INTERVIEW DEFINITION — Parent Class Design:
 * -----------------------------------------------
 * Q: Why is Subscription a parent class?
 * A: All subscription types (Basic, Standard, Premium) share the SAME fields
 *    (planName, price, maxScreen, videoQuality) and the SAME behavior (showDetails).
 *    Instead of duplicating code in each type, we put common code in the PARENT.
 *    This follows the DRY Principle (Don't Repeat Yourself).
 *
 * Q: What is the IS-A relationship here?
 * A: BasicSubscription IS-A Subscription.
 *    StandardSubscription IS-A Subscription.
 *    PremiumSubscription IS-A Subscription.
 *
 * BUG FIX: All fields were 'public' — changed to 'private' with getters for proper Encapsulation.
 *
 * JAVA TYPE: class (parent class)
 * OOP PILLAR: Inheritance + Encapsulation
 *
 * @author Aditya
 * @version 2.0
 * @see BasicSubscription
 * @see StandardSubscription
 * @see PremiumSubscription
 */
public class Subscription {

    /** BUG FIX: Changed from 'public' to 'private' */
    private String planName;
    private double price;
    private String maxScreen;
    private String videoQuality;

    /**
     * Constructor — initializes subscription with all details.
     *
     * @param planName     String — plan name (e.g., "Basic", "Premium")
     * @param price        double — monthly price in ₹
     * @param maxScreen    String — supported screen types
     * @param videoQuality String — video quality (e.g., "720p", "4K HDR")
     */
    public Subscription(String planName, double price, String maxScreen, String videoQuality) {
        this.planName = planName;
        this.price = price;
        this.maxScreen = maxScreen;
        this.videoQuality = videoQuality;
    }

    // ======================== GETTERS ========================

    /** @return String — the plan name */
    public String getPlanName() {
        return planName;
    }

    /** @return double — the price */
    public double getPrice() {
        return price;
    }

    /** @return String — the max screen type */
    public String getMaxScreen() {
        return maxScreen;
    }

    /** @return String — the video quality */
    public String getVideoQuality() {
        return videoQuality;
    }

    /**
     * Displays subscription details.
     */
    public void showDetails() {
        System.out.println("Your Details are----------------------------");
        System.out.println("Your Plan is          : " + this.planName);
        System.out.println("Subscription Price is : ₹" + this.price);
        System.out.println("Maximum Screen is     : " + this.maxScreen);
        System.out.println("Video Quality is      : " + this.videoQuality);
    }
}
