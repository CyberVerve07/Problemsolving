package august.august2;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BuiltInFunctionalInterfaceDemo {
    public static void main(String[] args) {
        System.out.println("=== JAVA BUILT-IN FUNCTIONAL INTERFACES DEMO ===");

        // 1. Predicate<T> -> Takes an argument of type T, returns boolean
        System.out.println("\n1. Predicate<T> Example:");
        Predicate<Integer> isEven = num -> num % 2 == 0;
        Predicate<Integer> isGreaterThan10 = num -> num > 10;

        int testNum = 14;
        System.out.println("Is " + testNum + " even? " + isEven.test(testNum));
        // Predicate chaining (AND)
        System.out.println("Is " + testNum + " even AND > 10? " + isEven.and(isGreaterThan10).test(testNum));

        // 2. Function<T, R> -> Takes an argument of type T, returns result of type R
        System.out.println("\n2. Function<T, R> Example:");
        Function<String, Integer> stringLength = String::length;
        Function<Integer, Integer> square = n -> n * n;

        // Function composition (andThen)
        Function<String, Integer> lengthSquared = stringLength.andThen(square);

        String sampleStr = "FunctionalInterface";
        System.out.println("Length of '" + sampleStr + "': " + stringLength.apply(sampleStr));
        System.out.println("Square of length: " + lengthSquared.apply(sampleStr));

        // 3. Consumer<T> -> Takes an argument of type T, returns void (performs action)
        System.out.println("\n3. Consumer<T> Example:");
        Consumer<String> printUpper = str -> System.out.println("Consumer Output: " + str.toUpperCase());

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.forEach(printUpper);

        // 4. Supplier<T> -> Takes no arguments, returns a result of type T
        System.out.println("\n4. Supplier<T> Example:");
        Supplier<Double> randomValue = Math::random;
        Supplier<String> currentDate = () -> java.time.LocalDate.now().toString();

        System.out.println("Generated Random Number: " + randomValue.get());
        System.out.println("Current Date: " + currentDate.get());

        // 5. BiFunction<T, U, R> -> Takes two arguments of types T and U, returns result of type R
        System.out.println("\n5. BiFunction<T, U, R> Example:");
        BiFunction<String, String, String> concatenate = (str1, str2) -> str1 + " " + str2;
        System.out.println("Combined String: " + concatenate.apply("August", "2026"));
    }
}
