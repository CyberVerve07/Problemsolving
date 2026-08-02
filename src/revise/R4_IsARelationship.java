package revise;

/*
 * ============================================================
 *  TOPIC: IS-A RELATIONSHIP (Inheritance)
 * ============================================================
 *
 *  DEFINITION (Interview Answer):
 *  IS-A relationship represents INHERITANCE in Java.
 *  When a class extends another class (or implements an interface),
 *  it establishes an IS-A relationship â€” meaning the child class
 *  IS-A type of the parent class.
 *  Implemented using: extends (class) and implements (interface).
 *
 *  WHY WE USE IT IN JAVA:
 *  1. CODE REUSE â€” child inherits all non-private members of parent.
 *  2. POLYMORPHISM â€” child objects can be used wherever parent is expected.
 *  3. EXTENSIBILITY â€” extend existing classes without modifying them.
 *  4. STANDARD HIERARCHY â€” Java API uses it everywhere (Exception, Thread, etc.)
 *  5. SUBSTITUTION PRINCIPLE (Liskov) â€” child can replace parent safely.
 *
 *  KEY POINTS:
 *  - "extends" keyword establishes IS-A with a class (single inheritance).
 *  - "implements" keyword establishes IS-A with interface (multiple allowed).
 *  - IS-A is a one-way relationship: Dog IS-A Animal, but Animal is NOT Dog.
 *  - Java only supports SINGLE class inheritance (no multiple extends).
 *  - Use IS-A when the relationship is genuinely "X is a type of Y".
 *
 *  WHEN NOT TO USE IS-A:
 *  If the relationship is "uses" or "has", prefer HAS-A (Composition).
 *  Wrong: class Car extends Engine (Car IS-A Engine? No! Car HAS-A Engine)
 * ============================================================
 */

// Base class (Parent / Superclass)
abstract class Vehicle {
    String brand;
    int speed;

    Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    void startEngine() {
        System.out.println(brand + " engine started!");
    }

    abstract void fuelType(); // child must implement this
}

// Interface â€” another form of IS-A
interface Electric {
    void charge();
    default void showChargingStatus() {
        System.out.println("Charging... 80% complete");
    }
}

// Car IS-A Vehicle (class extends class)
class Car extends Vehicle {

    Car(String brand, int speed) {
        super(brand, speed);
    }

    @Override
    void fuelType() {
        System.out.println(brand + " runs on Petrol/Diesel");
    }

    void honk() {
        System.out.println(brand + " goes Beep Beep!");
    }
}

// ElectricCar IS-A Car AND IS-A Electric (multiple IS-A via interface)
class ElectricCar extends Car implements Electric {

    ElectricCar(String brand, int speed) {
        super(brand, speed);
    }

    @Override
    void fuelType() {
        System.out.println(brand + " runs on Electricity");
    }

    @Override
    public void charge() {
        System.out.println(brand + " is charging at 11kW...");
    }
}

public class R4_IsARelationship {
    public static void main(String[] args) {

        System.out.println("========== IS-A RELATIONSHIP DEMO ==========\n");

        // ---- 1. Basic IS-A ----
        Car car = new Car("Toyota", 180);
        System.out.println("Car IS-A Vehicle:");
        car.startEngine(); // Inherited from Vehicle
        car.fuelType();    // Overridden
        car.honk();        // Car-specific

        System.out.println();

        // ---- 2. IS-A Test with instanceof ----
        System.out.println("instanceof checks (IS-A verification):");
        ElectricCar tesla = new ElectricCar("Tesla", 250);

        System.out.println("tesla instanceof ElectricCar: " + (tesla instanceof ElectricCar)); // true
        System.out.println("tesla instanceof Car: " + (tesla instanceof Car));                  // true (IS-A)
        System.out.println("tesla instanceof Vehicle: " + (tesla instanceof Vehicle));          // true (IS-A)
        System.out.println("tesla instanceof Electric: " + (tesla instanceof Electric));        // true (IS-A)

        System.out.println();

        // ---- 3. Polymorphism through IS-A ----
        System.out.println("Polymorphism via IS-A (parent ref = child obj):");
        Vehicle v = new ElectricCar("BMW iX", 220); // IS-A allows this
        v.startEngine();
        v.fuelType(); // Calls ElectricCar's fuelType (runtime polymorphism)

        System.out.println();

        // ---- 4. Interface IS-A ----
        System.out.println("Interface IS-A:");
        Electric ev = new ElectricCar("Tata Nexon EV", 200);
        ev.charge();
        ev.showChargingStatus();

        System.out.println();

        // ---- 5. IS-A Hierarchy Summary ----
        System.out.println("IS-A Chain:");
        System.out.println("ElectricCar IS-A Car");
        System.out.println("Car IS-A Vehicle");
        System.out.println("ElectricCar IS-A Vehicle (transitively)");
        System.out.println("ElectricCar IS-A Electric (via interface)");

        System.out.println("\n============================================");
    }
}
