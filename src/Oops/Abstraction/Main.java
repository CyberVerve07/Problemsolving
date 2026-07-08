package oops.abstraction;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Abstraction Demo ---");

        // We cannot create object of abstract class Animal:
        // Animal a = new Animal(); // ERROR

        // Create object of concrete child class Dog
        Animal myDog = new Dog();

        // Call the implemented method
        myDog.makeSound();

        // Call the inherited concrete method
        myDog.sleep();
    }
}
