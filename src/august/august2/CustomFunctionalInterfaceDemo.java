package august.august2;

// Custom Functional Interface 1: Math Operations
@FunctionalInterface
interface MathOperation {
    int operate(int a, int b); // Single Abstract Method (SAM)

    // Functional interfaces can have default methods
    default void printInfo() {
        System.out.println("Executing custom MathOperation...");
    }

    // Functional interfaces can also have static helper methods
    static void help() {
        System.out.println("MathOperation is a custom Functional Interface with a single abstract method: operate(int, int)");
    }
}

// Custom Functional Interface 2: String Processing
@FunctionalInterface
interface StringProcessor {
    String process(String str);
}

public class CustomFunctionalInterfaceDemo {
    public static void main(String[] args) {
        System.out.println("=== FUNCTIONAL INTERFACE: CUSTOM INTERFACE & LAMBDAS DEMO ===");

        // Display static method info
        MathOperation.help();
        System.out.println();

        // 1. Lambda Expression implementations for MathOperation
        MathOperation add = (a, b) -> a + b;
        MathOperation multiply = (a, b) -> a * b;
        MathOperation max = (a, b) -> Math.max(a, b);

        System.out.println("Addition (10 + 5): " + add.operate(10, 5));
        System.out.println("Multiplication (10 * 5): " + multiply.operate(10, 5));
        System.out.println("Maximum of (10, 5): " + max.operate(10, 5));

        add.printInfo();

        System.out.println("\n--- StringProcessor Custom Functional Interface ---");

        // 2. Lambda implementations for StringProcessor
        StringProcessor upperCase = str -> str.toUpperCase();
        StringProcessor reverse = str -> new StringBuilder(str).reverse().toString();

        // Method reference usage
        StringProcessor trim = String::trim;

        String originalText = "  Hello Java Functional Interfaces!  ";
        System.out.println("Original: '" + originalText + "'");
        System.out.println("Trimmed: '" + trim.process(originalText) + "'");
        System.out.println("Uppercase: '" + upperCase.process(trim.process(originalText)) + "'");
        System.out.println("Reversed: '" + reverse.process("Java") + "'");
    }
}
