package oops.transport;

/**
 * Car — Extends Vehicle (Inheritance with super() constructor call).
 *
 * INTERVIEW: What is the 'super' keyword used for here?
 * → super(name, number, model, company) calls the PARENT's parameterized constructor.
 * → This initializes the parent (Vehicle) fields before adding Car-specific fields.
 * → super() MUST be the FIRST statement in the child constructor.
 *
 * NAMING FIX: 'transMissiontype' → 'transmissionType' (proper camelCase).
 * BUG FIX: printf was used incorrectly — replaced with println.
 *
 * JAVA TYPE: class (child extending parent)
 * OOP PILLAR: Inheritance
 *
 * @author Aditya
 * @version 2.0
 * @see Vehicle
 */
public class Car extends Vehicle {

    /** Car-specific fields */
    private int numberOfDoors;
    private String transmissionType; // NAMING FIX: was 'transMissiontype'

    /**
     * Constructor — initializes Car with Vehicle fields + car-specific fields.
     *
     * @param name             String — car name
     * @param number           int — car number
     * @param model            int — model year
     * @param company          String — manufacturer
     * @param numberOfDoors    int — number of doors (e.g., 2, 4)
     * @param transmissionType String — transmission type (e.g., "Manual", "Automatic")
     */
    Car(String name, int number, int model, String company, int numberOfDoors, String transmissionType) {
        super(name, number, model, company); // Constructor Chaining — calls Vehicle constructor
        this.numberOfDoors = numberOfDoors;
        this.transmissionType = transmissionType;
    }

    /**
     * Starts the car and displays all details.
     *
     * BUG FIX: Replaced printf (used incorrectly) with println.
     */
    void startCar() {
        System.out.println("Car is started: " + getName());
        super.start(); // Calls Vehicle's start() method
        System.out.println("Model number is: " + getModel());
        System.out.println("Company name is: " + getCompany());
        System.out.println("Number of doors: " + numberOfDoors);
        System.out.println("Transmission type is: " + transmissionType);
    }

    // ======================== GETTERS & SETTERS ========================

    /** @return int — number of doors */
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    /** @param numberOfDoors int — number of doors to set */
    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    /** @return String — the transmission type */
    public String getTransmissionType() {
        return transmissionType;
    }
}
