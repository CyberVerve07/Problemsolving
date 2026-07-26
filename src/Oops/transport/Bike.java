package oops.transport;

/**
 * Bike — Extends Vehicle (Inheritance with super() constructor call).
 *
 * NAMING FIX: 'handel' → 'handleType' (spelling correction + descriptive name).
 * BUG FIX: printf used incorrectly — replaced with println.
 *
 * JAVA TYPE: class (child extending parent)
 * OOP PILLAR: Inheritance
 *
 * @author Aditya
 * @version 2.0
 * @see Vehicle
 */
public class Bike extends Vehicle {

    /** Bike-specific fields */
    private int price;
    private String handleType; // NAMING FIX: was 'handel'

    /**
     * Constructor — initializes Bike with Vehicle fields + bike-specific fields.
     *
     * @param name       String — bike name
     * @param number     int — bike number
     * @param model      int — model year
     * @param company    String — manufacturer
     * @param price      int — bike price
     * @param handleType String — handle type
     */
    Bike(String name, int number, int model, String company, int price, String handleType) {
        super(name, number, model, company); // Calls Vehicle constructor
        this.price = price;
        this.handleType = handleType;
        super.start(); // Starts the bike on creation
    }

    /**
     * Stops the bike.
     *
     * BUG FIX: Replaced printf (incorrect format specifiers) with println.
     */
    public void stopBike() {
        System.out.println("Bike is stopped: " + getName() + ", Model: " + getModel());
    }

    /**
     * Opens the fuel tank.
     *
     * BUG FIX: Replaced printf (incorrect format specifiers) with println.
     */
    public void openTank() {
        System.out.println("Open fuel tank: " + getName() + ", Model: " + getModel());
    }

    // ======================== GETTERS ========================

    /** @return int — the price */
    public int getPrice() {
        return price;
    }

    /** @return String — the handle type */
    public String getHandleType() {
        return handleType;
    }
}
