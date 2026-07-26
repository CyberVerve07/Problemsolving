package oops.transport;

/**
 * Scooty — Extends Vehicle.
 *
 * JAVA TYPE: class (child extending parent)
 * OOP PILLAR: Inheritance
 *
 * @author Aditya
 * @version 2.0
 * @see Vehicle
 */
public class Scooty extends Vehicle {

    /** Scooty-specific fields */
    private String color;
    private String price;

    /**
     * Constructor — initializes Scooty with Vehicle fields + scooty-specific fields.
     *
     * @param name    String — scooty name
     * @param number  int — scooty number
     * @param model   int — model year
     * @param company String — manufacturer
     * @param color   String — scooty color
     * @param price   String — scooty price
     */
    Scooty(String name, int number, int model, String company, String color, String price) {
        super(name, number, model, company);
        this.color = color;
        this.price = price;
    }

    /**
     * Displays all scooty details (inherited + own fields).
     */
    void showDetails() {
        System.out.println("Scooty Details:");
        System.out.println("Name: " + getName());
        System.out.println("Number: " + getNumber());
        System.out.println("Model: " + getModel());
        System.out.println("Company: " + getCompany());
        System.out.println("Color: " + color);
        System.out.println("Price: " + price);
    }

    // ======================== GETTERS ========================

    /** @return String — the color */
    public String getColor() {
        return color;
    }

    /** @return String — the price */
    public String getPrice() {
        return price;
    }
}
