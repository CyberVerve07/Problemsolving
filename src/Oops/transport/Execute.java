package oops.transport;

/**
 * Execute — Main entry point for Transport system demo.
 *
 * Demonstrates Inheritance in action:
 * → Scooty extends Vehicle → uses inherited constructor via super().
 * → Car extends Vehicle → uses inherited start() method via super.start().
 *
 * @author Aditya
 * @version 2.0
 */
public class Execute {

    public static void main(String[] args) {
        // Create Scooty — inherits from Vehicle
        Scooty sc = new Scooty("Sakharam", 7873, 2024, "Hero", "Red", "20k");
        sc.showDetails();

        // Create Car — inherits from Vehicle + has its own startCar()
        Car c = new Car("Aulto", 2016, 2023, "HondaCity", 4, "Automatic");
        c.startCar();
    }
}