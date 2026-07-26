package oops.polymorphism;

/**
 * Main — Demonstrates both types of Polymorphism in action.
 *
 * INTERVIEW: What are the two types of Polymorphism in Java?
 * 1. COMPILE-TIME (Static) → Method Overloading → Resolved by COMPILER.
 * 2. RUNTIME (Dynamic)     → Method Overriding  → Resolved by JVM at runtime.
 *
 * @author Aditya
 * @version 2.0
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("--- Polymorphism Demo ---");

        // ========= 1. COMPILE-TIME POLYMORPHISM (Method Overloading) =========
        System.out.println("\n[Compile-time Polymorphism (Method Overloading)]");
        MathOperation math = new MathOperation();
        // Compiler decides: add(int,int) → because arguments are int
        System.out.println("Adding integers (5 + 10): " + math.add(5, 10));
        // Compiler decides: add(double,double) → because arguments are double
        System.out.println("Adding doubles (5.5 + 10.5): " + math.add(5.5, 10.5));

        // ========= 2. RUNTIME POLYMORPHISM (Method Overriding) =========
        System.out.println("\n[Runtime Polymorphism (Method Overriding)]");

        // Parent reference → Parent object → calls Animal's sound()
        Animal myAnimal = new Animal();
        myAnimal.sound();

        // Parent reference → Child object (UPCASTING) → calls Cat's sound() at RUNTIME
        Animal myCat = new Cat();
        myCat.sound(); // JVM dynamically decides at runtime to call Cat's sound()
    }
}
