package oops.abstraction;

/**
 * INTERVIEW DEFINITION â€” Abstract Class (Abstraction Pillar):
 * --------------------------------------------------------------
 * Q: What is Abstraction?
 * A: Abstraction is the process of HIDING implementation details and showing only the
 *    ESSENTIAL features to the user. It focuses on WHAT an object does, not HOW it does it.
 *    In Java, abstraction is achieved through:
 *    1. Abstract Classes (0-100% abstraction)
 *    2. Interfaces (100% abstraction, before Java 8)
 *
 * Q: What is an Abstract Class?
 * A: A class declared with the 'abstract' keyword that:
 *    - CANNOT be instantiated directly (new Animal() â†’ ERROR).
 *    - CAN have abstract methods (no body â€” child must implement).
 *    - CAN have concrete methods (with body â€” shared by all children).
 *    - CAN have constructors, fields, and static methods.
 *
 * Q: When to use Abstract Class vs Interface?
 * A: Use ABSTRACT CLASS when:
 *    - Classes share COMMON STATE (fields like name, age).
 *    - You want to provide DEFAULT behavior (concrete methods).
 *    - There's a clear IS-A relationship.
 *
 *    Use INTERFACE when:
 *    - You want to define BEHAVIOR only (no state).
 *    - Multiple unrelated classes need same behavior.
 *    - You need MULTIPLE INHERITANCE.
 *
 * JAVA TYPE: abstract class
 * OOP PILLAR: Abstraction
 *
 * @author Aditya
 * @version 2.0
 * @see Dog
 */
public abstract class Animal {

    /**
     * Abstract method â€” has NO body (no implementation).
     * Every NON-ABSTRACT child class MUST provide implementation for this method.
     *
     * INTERVIEW: Why abstract method?
     * â†’ We know every animal makes a sound, but we DON'T know WHAT sound.
     * â†’ Dog barks, Cat meows â€” the specific sound depends on the animal type.
     * â†’ So we DECLARE the method here but let children DEFINE the behavior.
     */
    public abstract void makeSound();

    /**
     * Concrete method â€” has a body (implementation).
     * This method is SHARED by all child classes â€” no need to override.
     *
     * INTERVIEW: Can abstract class have concrete methods?
     * â†’ YES! Abstract class can have BOTH abstract and concrete methods.
     * â†’ Concrete methods provide COMMON behavior shared by all children.
     * â†’ This avoids CODE DUPLICATION (DRY principle â€” Don't Repeat Yourself).
     */
    public void sleep() {
        System.out.println("Sleeping... Zzz");
    }
}
