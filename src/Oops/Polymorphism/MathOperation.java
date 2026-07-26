package oops.polymorphism;

/**
 * MathOperation — Demonstrates Compile-time Polymorphism (Method Overloading).
 *
 * INTERVIEW DEFINITION — Method Overloading:
 * ---------------------------------------------
 * Q: What is Method Overloading?
 * A: Method Overloading is when a class has MULTIPLE methods with the SAME NAME but
 *    DIFFERENT parameters (number, type, or order of parameters).
 *    It is resolved at COMPILE TIME (Static Binding / Early Binding).
 *
 * Q: Why do we use Method Overloading?
 * A: 1. CODE READABILITY — one method name for similar operations (add for all types).
 *    2. FLEXIBILITY — same operation for different data types.
 *    3. CLEANER API — user doesn't need to remember addInt(), addDouble(), etc.
 *
 * Q: Rules for Method Overloading?
 * A: Methods must differ in at least ONE of:
 *    1. NUMBER of parameters     → add(int a) vs add(int a, int b)
 *    2. TYPE of parameters       → add(int a, int b) vs add(double a, double b)
 *    3. ORDER of parameters      → add(int a, double b) vs add(double a, int b)
 *    NOTE: Return type alone is NOT enough for overloading!
 *
 * Q: Method Overloading vs Method Overriding?
 * A: | Feature        | Overloading (Compile-time) | Overriding (Runtime)   |
 *    |----------------|----------------------------|------------------------|
 *    | Where?         | Same class                 | Parent-child classes   |
 *    | Parameters     | MUST be different          | MUST be same           |
 *    | Return type    | Can be different           | Must be same/covariant |
 *    | Binding        | Compile-time (static)      | Runtime (dynamic)      |
 *    | Keyword        | No special keyword         | @Override annotation   |
 *
 * JAVA TYPE: class (method overloading demo)
 * OOP PILLAR: Polymorphism (Compile-time)
 *
 * @author Aditya
 * @version 2.0
 */
public class MathOperation {

    /**
     * Adds two integers.
     *
     * @param a int — first integer
     * @param b int — second integer
     * @return int — sum of a and b
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Adds two doubles — OVERLOADED version of add().
     * Compiler selects this method when double arguments are passed.
     *
     * @param a double — first double
     * @param b double — second double
     * @return double — sum of a and b
     */
    public double add(double a, double b) {
        return a + b;
    }
}
