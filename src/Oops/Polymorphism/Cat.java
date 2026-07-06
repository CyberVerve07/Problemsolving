package Oops.Polymorphism;

// Subclass overriding the parent class method
public class
Cat extends Animal {

    // Overriding the sound method
    @Override
    public void sound() {
        System.out.println("Cat meows: Meow Meow!");
    }
}
