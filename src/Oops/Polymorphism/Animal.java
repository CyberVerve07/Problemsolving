package oops.polymorphism;

/**
 * Animal — Parent class demonstrating Runtime Polymorphism (Method Overriding).
 *
 * INTERVIEW DEFINITION — Polymorphism:
 * ----------------------------------------
 * Q: What is Polymorphism?
 * A: Polymorphism means "MANY FORMS" — the ability of an object to take on multiple forms.
 *    A single method call can behave differently based on the object type.
 *    There are TWO types of polymorphism in Java:
 *
 *    1. COMPILE-TIME Polymorphism (Static Binding / Early Binding):
 *       → Achieved through METHOD OVERLOADING.
 *       → Compiler decides which method to call at COMPILE time.
 *       → Same method name, DIFFERENT parameters (number, type, or order).
 *       → See: MathOperation class.
 *
 *    2. RUNTIME Polymorphism (Dynamic Binding / Late Binding):
 *       → Achieved through METHOD OVERRIDING.
 *       → JVM decides which method to call at RUNTIME based on actual object type.
 *       → Parent reference, child object → calls child's overridden method.
 *       → See: Cat class overriding sound().
 *
 * Q: What is Method Overriding?
 * A: When a child class provides its OWN implementation of a method that is already
 *    defined in the parent class. Rules:
 *    - Same method name, same parameters, same return type.
 *    - Access modifier must be SAME or MORE visible.
 *    - Use @Override annotation for safety.
 *
 * JAVA TYPE: class (parent for runtime polymorphism demo)
 * OOP PILLAR: Polymorphism
 *
 * @author Aditya
 * @version 2.0
 * @see Cat
 */
public class Animal {

    /**
     * Default sound method — will be OVERRIDDEN by child classes.
     *
     * INTERVIEW: When Animal ref points to Cat object, which sound() is called?
     * → Cat's sound() is called (RUNTIME polymorphism).
     * → The method resolution happens at RUNTIME based on the ACTUAL object type.
     */
    public void sound() {
        System.out.println("Animal makes some generic sound.");
    }
}
