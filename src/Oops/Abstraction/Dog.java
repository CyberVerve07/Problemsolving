package oops.abstraction;

/**
 * Dog â€” Concrete class extending the abstract Animal class.
 *
 * INTERVIEW DEFINITION â€” Concrete Class:
 * -----------------------------------------
 * Q: What is a Concrete Class?
 * A: A concrete class is a REGULAR class that provides implementation for ALL abstract
 *    methods inherited from its parent abstract class. Unlike abstract classes, concrete
 *    classes CAN be instantiated using the 'new' keyword.
 *
 * Q: What does @Override annotation do?
 * A: @Override tells the compiler: "I am intentionally overriding a parent method."
 *    Benefits:
 *    1. Compile-time ERROR if the method doesn't actually override anything.
 *    2. Improves code READABILITY â€” clearly shows which methods are overridden.
 *    3. Best practice: ALWAYS use @Override when overriding.
 *
 * JAVA TYPE: class (concrete child of abstract class)
 * OOP PILLAR: Inheritance + Abstraction
 *
 * @author Aditya
 * @version 2.0
 * @see Animal
 */
public class Dog extends Animal {

    /**
     * Provides implementation for the abstract makeSound() method.
     * Dog's specific sound: "Woof Woof!"
     *
     * INTERVIEW: What happens if Dog doesn't implement makeSound()?
     * â†’ Dog would also need to be declared 'abstract' (cannot be instantiated).
     * â†’ Every abstract method MUST be implemented somewhere in the inheritance chain.
     */
    @Override
    public void makeSound() {
        System.out.println("Dog barks: Woof Woof!");
    }
}
