package oops.inheritance;

/**
 * Car — Extends Vehicle to demonstrate Inheritance with super() constructor call.
 *
 * JAVA TYPE: class (child extending parent)
 * OOP PILLAR: Inheritance
 *
 * @author Aditya
 * @version 2.0
 * @see Vehicle
 */
public class Car extends Vehicle {

    /**
     * Main method — creates Vehicle and demonstrates inherited start() method.
     *
     * @param args String[] — command line arguments
     */
    public static void main(String[] args) {
        Vehicle vh = new Vehicle("Aulto", 2020, "pass", 3040);
        vh.start(); // Inherited method from Vehicle
    }
}