package dailycode.july8;

/**
 * Car — Demonstrates Encapsulation with controlled speed management.
 *
 * INTERVIEW: What is Encapsulation demonstrated here?
 * → 'brand' and 'speed' are PRIVATE — cannot be accessed directly.
 * → 'speed' has NO public setter — can only be changed via accelerate() and brake().
 * → This provides CONTROLLED ACCESS — speed can never go below 0 or above 220.
 * → This is a real-world example of WHY Encapsulation is important:
 *   Without it, someone could set speed = -100 (invalid!).
 *
 * INTERVIEW: Why no setter for speed?
 * → Speed should only change through accelerate() and brake() methods.
 * → This enforces BUSINESS LOGIC — max speed is 220, min speed is 0.
 * → If we provided setSpeed(int speed), someone could bypass the limits.
 *
 * JAVA TYPE: class
 * OOP PILLAR: Encapsulation (Data Hiding + Controlled Access)
 *
 * @author Aditya
 * @version 2.0
 */
public class Car {

    /** Private fields — cannot be accessed directly from outside */
    private String brand;
    private int speed;

    // ======================== BRAND GETTERS & SETTERS ========================

    /**
     * @return String — the car brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand String — the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Speed getter — READ-ONLY access (no public setter for speed).
     *
     * @return int — current speed
     */
    public int getSpeed() {
        return speed;
    }

    // ======================== SPEED CONTROL METHODS ========================

    /**
     * Accelerates the car — increases speed with max limit of 220.
     *
     * INTERVIEW: Why method instead of setter?
     * → Methods can include BUSINESS LOGIC (max speed check).
     * → A simple setter would allow invalid values.
     *
     * @param increment int — speed increment (must be positive)
     */
    public void accelerate(int increment) {
        if (increment > 0) {
            this.speed += increment;
            if (this.speed > 220) {
                this.speed = 220;
                System.out.println("Maximum speed limit (220) reached!");
            }
            System.out.println("Car accelerated. Current speed: " + this.speed);
        } else {
            System.out.println("Invalid acceleration amount!");
        }
    }

    /**
     * Applies brake — decreases speed with min limit of 0.
     *
     * @param decrement int — speed decrement (must be positive)
     */
    public void brake(int decrement) {
        if (decrement > 0) {
            this.speed -= decrement;
            if (this.speed < 0) {
                this.speed = 0;
                System.out.println("Car has stopped.");
            }
            System.out.println("Brake applied. Current speed: " + this.speed);
        } else {
            System.out.println("Invalid brake amount!");
        }
    }
}
