package oops.polymorphism;

/**
 * Cat — Child class overriding parent's sound() method (Runtime Polymorphism).
 *
 * INTERVIEW DEFINITION — Method Overriding:
 * -------------------------------------------
 * Q: What is Method Overriding?
 * A: Method Overriding occurs when a child class provides a SPECIFIC implementation
 *    for a method already defined in the parent class.
 *
 * Rules for Method Overriding:
 *    1. Method name MUST be the same as parent's method.
 *    2. Parameters MUST be the same (number, type, and order).
 *    3. Return type MUST be the same (or covariant — child of parent's return type).
 *    4. Access modifier MUST be same or MORE visible (e.g., protected → public is OK).
 *    5. Cannot override 'static', 'final', or 'private' methods.
 *
 * FORMATTING FIX: Class declaration was split across 2 lines — now on single line.
 *
 * JAVA TYPE: class (child overriding parent method)
 * OOP PILLAR: Polymorphism (Runtime)
 *
 * @author Aditya
 * @version 2.0
 * @see Animal
 */
public class Cat extends Animal {

    /**
     * Overrides parent's sound() method with Cat-specific behavior.
     * When called via: Animal myCat = new Cat(); myCat.sound();
     * → JVM calls THIS method (Cat's version) at RUNTIME — Dynamic Method Dispatch.
     */
    @Override
    public void sound() {
        System.out.println("Cat meows: Meow Meow!");
    }
}
