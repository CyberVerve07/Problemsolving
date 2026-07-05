package Oops.Abstraction;

// Abstract class: cannot be instantiated directly
public abstract class Animal {
    
    // Abstract method: does not have a body
    public abstract void makeSound();

    // Concrete method: has a body, common to all animals
    public void sleep() {
        System.out.println("Sleeping... Zzz");
    }
}
