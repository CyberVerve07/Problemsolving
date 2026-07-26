package oops.transport;

/**
 * Vehicle — Parent class for all transport vehicles (Car, Bike, Truck, Scooty).
 *
 * INTERVIEW DEFINITION — Constructor Overloading:
 * --------------------------------------------------
 * Q: What is Constructor Overloading?
 * A: Constructor Overloading is when a class has MULTIPLE constructors with DIFFERENT
 *    parameter lists. The compiler decides which constructor to call based on the arguments.
 *    This is a form of COMPILE-TIME POLYMORPHISM.
 *
 * Q: Why use Constructor Overloading?
 * A: To provide FLEXIBILITY in object creation:
 *    - new Vehicle() → creates with default values.
 *    - new Vehicle("Car", 123, 2024, "Honda") → creates with all values.
 *
 * JAVA TYPE: class (parent class with constructor overloading)
 * OOP PILLAR: Inheritance + Encapsulation
 *
 * @author Aditya
 * @version 2.0
 * @see Car
 * @see Bike
 * @see Truck
 * @see Scooty
 */
public class Vehicle {

    /** Encapsulated fields — private for data protection */
    private String name;
    private int number;
    private int model;
    private String company;

    /**
     * Default (no-arg) constructor.
     *
     * INTERVIEW: What is a Default Constructor?
     * → A constructor with NO parameters.
     * → If you define ANY constructor, Java won't provide a default one automatically.
     * → You must define it explicitly if needed.
     */
    Vehicle() {
    }

    /**
     * Parameterized constructor — initializes vehicle with all required fields.
     *
     * INTERVIEW: What is 'this' keyword in constructors?
     * → 'this' refers to the current object instance.
     * → this.name = name → assigns the parameter 'name' to instance variable 'name'.
     * → Without 'this', Java would treat both as the parameter (shadowing).
     *
     * @param name    String — vehicle name
     * @param number  int — vehicle number
     * @param model   int — model year
     * @param company String — manufacturer company
     */
    Vehicle(String name, int number, int model, String company) {
        this.name = name;
        this.number = number;
        this.model = model;
        this.company = company;
    }

    // ======================== GETTERS ========================

    /** @return String — the vehicle name */
    public String getName() {
        return name;
    }

    /** @return int — the vehicle number */
    public int getNumber() {
        return number;
    }

    /** @return int — the model year */
    public int getModel() {
        return model;
    }

    /** @return String — the company name */
    public String getCompany() {
        return company;
    }

    /**
     * Starts the vehicle.
     */
    void start() {
        System.out.println("Vehicle is started: " + name);
    }

    /**
     * Stops the vehicle.
     */
    void stop() {
        System.out.println("Vehicle is stopped: " + name);
    }
}
