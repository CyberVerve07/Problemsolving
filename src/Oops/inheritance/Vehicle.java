package oops.inheritance;

/**
 * Vehicle — Parent class for Car (inheritance demo with constructors).
 *
 * BUG FIX: Fields changed from 'public' to 'private' for proper Encapsulation.
 *
 * JAVA TYPE: class (parent)
 * OOP PILLAR: Inheritance + Encapsulation
 *
 * @author Aditya
 * @version 2.0
 * @see Car
 */
public class Vehicle {

    /** BUG FIX: Changed from 'public' to 'private' */
    private String name;
    private int modelNo;
    private String rc;
    private int year;

    /**
     * Default (no-arg) constructor.
     */
    Vehicle() {
    }

    /**
     * Parameterized constructor.
     *
     * @param name    String — vehicle name
     * @param modelNo int — model number
     * @param rc      String — RC (Registration Certificate)
     * @param year    int — manufacturing year
     */
    Vehicle(String name, int modelNo, String rc, int year) {
        this.name = name;
        this.modelNo = modelNo;
        this.rc = rc;
        this.year = year;
    }

    // ======================== GETTERS ========================

    /** @return String — the vehicle name */
    public String getName() {
        return name;
    }

    /** @return int — the model number */
    public int getModelNo() {
        return modelNo;
    }

    /** @return String — the RC */
    public String getRc() {
        return rc;
    }

    /** @return int — the year */
    public int getYear() {
        return year;
    }

    /**
     * Starts the vehicle — displays vehicle name.
     */
    void start() {
        System.out.println("Car is started: " + name);
    }
}
