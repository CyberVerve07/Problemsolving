package oops.polymorphism;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Polymorphism Demo ---");

        // 1. Compile-time Polymorphism (Method Overloading)
        System.out.println("\n[Compile-time Polymorphism (Method Overloading)]");
        MathOperation math = new MathOperation();
        System.out.println("Adding integers (5 + 10): " + math.add(5, 10));
        System.out.println("Adding doubles (5.5 + 10.5): " + math.add(5.5, 10.5));

        // 2. Runtime Polymorphism (Method Overriding)
        System.out.println("\n[Runtime Polymorphism (Method Overriding)]");
        // Parent class reference pointing to parent object
        Animal myAnimal = new Animal();
        myAnimal.sound();

        // Parent class reference pointing to child object
        Animal myCat = new Cat();
        myCat.sound(); // Dynamically decides at runtime to call Cat's sound()
    }
}
