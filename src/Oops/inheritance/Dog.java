package oops.inheritance;

/**
 * Dog — Extends Animal to demonstrate Inheritance.
 *
 * INTERVIEW: What does Dog inherit from Animal?
 * → Dog inherits ALL non-private fields and methods from Animal.
 * → Dog can use: getName(), getAge(), eat() — all from Animal.
 * → Dog can also add its OWN fields and methods.
 *
 * JAVA TYPE: class (child extending parent)
 * OOP PILLAR: Inheritance
 *
 * @author Aditya
 * @version 2.0
 * @see Animal
 */
public class Dog extends Animal {

    /**
     * Main method — creates Animal object and demonstrates inherited behavior.
     *
     * @param args String[] — command line arguments
     */
    public static void main(String[] args) {
        Animal a = new Animal("Tommy", 13);
        a.eat(); // Inherited method from Animal
    }
}
