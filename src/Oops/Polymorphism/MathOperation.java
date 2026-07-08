package oops.polymorphism;

// Class demonstrating Compile-time Polymorphism (Method Overloading)
public class MathOperation {

    // Add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Overloaded method: Add two doubles
    public double add(double a, double b) {
        return a + b;
    }
}
