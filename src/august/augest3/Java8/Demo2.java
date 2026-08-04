package august.augest3.Java8;

import java.util.function.Predicate;

@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

public class Demo2 {
    public static void main(String[] args) {
        // Lambda implementation for addition
        MathOperation add = (a, b) -> a + b;
        System.out.println(add.operate(5, 3)); // Outputs: 8



    }
}

