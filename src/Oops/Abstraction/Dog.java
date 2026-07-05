package Oops.Abstraction;

// Concrete class extending the abstract class
public class Dog extends Animal {

    // Providing implementation for the abstract method
    @Override
    public void makeSound() {
        System.out.println("Dog barks: Woof Woof!");
    }
}
