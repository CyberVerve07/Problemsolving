package oops.transport;

/**
 * Truck — Extends Vehicle.
 *
 * NAMING FIX: 'Driver' → 'driverName', 'Condition' → 'condition'.
 * → Java variable names follow camelCase — NEVER start with uppercase.
 * → Uppercase starting letter is reserved for CLASS NAMES (PascalCase).
 *
 * BUG FIX: printf used incorrectly — replaced with println.
 *
 * JAVA TYPE: class (child extending parent)
 * OOP PILLAR: Inheritance
 *
 * @author Aditya
 * @version 2.0
 * @see Vehicle
 */
public class Truck extends Vehicle {

    /** NAMING FIX: Renamed from 'Driver' → 'driverName' (camelCase convention) */
    private String driverName;

    /** NAMING FIX: Renamed from 'Condition' → 'condition' (camelCase convention) */
    private String condition;

    /**
     * Constructor — initializes Truck with Vehicle fields + truck-specific fields.
     *
     * @param name       String — truck name
     * @param number     int — truck number
     * @param model      int — model year
     * @param company    String — manufacturer
     * @param driverName String — driver's name
     * @param condition  String — truck condition (e.g., "Good", "Fair")
     */
    Truck(String name, int number, int model, String company, String driverName, String condition) {
        super(name, number, model, company); // Calls Vehicle constructor
        this.driverName = driverName;
        this.condition = condition;
    }

    /**
     * Starts the truck.
     *
     * BUG FIX: Replaced printf (incorrect usage) with println.
     */
    void startTruck() {
        System.out.println("The Truck is started: " + getName() + ", Model: " + getModel());
    }

    // ======================== GETTERS ========================

    /** @return String — the driver's name */
    public String getDriverName() {
        return driverName;
    }

    /** @return String — the truck's condition */
    public String getCondition() {
        return condition;
    }
}
