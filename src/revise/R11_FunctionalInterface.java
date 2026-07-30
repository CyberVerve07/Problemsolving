package revise;

/*
 * ============================================================
 *  TOPIC: FUNCTIONAL INTERFACE
 * ============================================================
 *
 *  DEFINITION (Interview Answer):
 *  A Functional Interface is an interface that has EXACTLY ONE
 *  abstract method (SAM — Single Abstract Method).
 *  It CAN have any number of default and static methods.
 *  It is the foundation of Lambda Expressions in Java (Java 8+).
 *  Annotated with @FunctionalInterface (optional but recommended).
 *
 *  WHY WE USE FUNCTIONAL INTERFACES IN JAVA:
 *  1. LAMBDA EXPRESSIONS — enables concise, readable functional code.
 *  2. FUNCTIONAL PROGRAMMING — pass behavior (code) as a parameter.
 *  3. LESS BOILERPLATE — replace verbose anonymous inner classes.
 *  4. STREAMS API — map(), filter(), forEach() all use functional interfaces.
 *  5. METHOD REFERENCES — Printer::print style of coding.
 *  6. Higher-Order Functions — functions that take/return functions.
 *
 *  BUILT-IN FUNCTIONAL INTERFACES (java.util.function package):
 *  ┌──────────────────┬────────────────────┬──────────────────────────┐
 *  │ Interface        │ Abstract Method    │ Use Case                 │
 *  ├──────────────────┼────────────────────┼──────────────────────────┤
 *  │ Runnable         │ void run()         │ No input, no output      │
 *  │ Callable<V>      │ V call()           │ No input, returns value  │
 *  │ Function<T,R>    │ R apply(T t)       │ Transform T → R          │
 *  │ Consumer<T>      │ void accept(T t)   │ Takes T, returns nothing │
 *  │ Supplier<T>      │ T get()            │ No input, returns T      │
 *  │ Predicate<T>     │ boolean test(T t)  │ Takes T, returns boolean │
 *  │ BiFunction<T,U,R>│ R apply(T t, U u)  │ Two inputs → one output  │
 *  │ UnaryOperator<T> │ T apply(T t)       │ Same type in/out         │
 *  │ BinaryOperator<T>│ T apply(T t, T u)  │ Two same type → same type│
 *  └──────────────────┴────────────────────┴──────────────────────────┘
 *
 *  KEY POINTS:
 *  - Exactly ONE abstract method — this is the SAM rule.
 *  - @FunctionalInterface: compiler checks the SAM rule for you.
 *  - Adding a second abstract method = compile error (with annotation).
 *  - Lambda = shorthand implementation of functional interface.
 *  - Method references (Class::method) also implement functional interfaces.
 *  - Functional interfaces are TYPE for lambda expressions.
 * ============================================================
 */

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

// ===================== CUSTOM FUNCTIONAL INTERFACES =====================

@FunctionalInterface
interface MathOperation {
    // SAM — Single Abstract Method
    int operate(int a, int b);

    // Default methods are ALLOWED (don't violate SAM rule)
    default void printResult(int a, int b) {
        System.out.println("Result: " + operate(a, b));
    }

    // Static methods are ALLOWED too
    static MathOperation addition() {
        return (a, b) -> a + b;
    }
}

@FunctionalInterface
interface StringTransformer {
    String transform(String input);
}

@FunctionalInterface
interface Validator<T> {
    boolean validate(T value);
}

// ===================== WITHOUT LAMBDA (Old way — Anonymous Class) =====================
// This is what Java looked like before Java 8

public class R11_FunctionalInterface {

    public static void main(String[] args) {

        System.out.println("======== FUNCTIONAL INTERFACE DEMO ========\n");

        // ---- 1. OLD WAY vs LAMBDA ----
        System.out.println("--- 1. Old Way (Anonymous Class) vs Lambda ---");

        // OLD WAY (verbose — before Java 8)
        MathOperation addOld = new MathOperation() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };
        System.out.println("Old way (add): " + addOld.operate(10, 5));

        // LAMBDA WAY (Java 8+) — same thing, much cleaner!
        MathOperation addLambda = (a, b) -> a + b;
        MathOperation subLambda = (a, b) -> a - b;
        MathOperation mulLambda = (a, b) -> a * b;
        MathOperation divLambda = (a, b) -> a / b;

        System.out.println("Lambda (add):      " + addLambda.operate(10, 5));
        System.out.println("Lambda (subtract): " + subLambda.operate(10, 5));
        System.out.println("Lambda (multiply): " + mulLambda.operate(10, 5));
        System.out.println("Lambda (divide):   " + divLambda.operate(10, 5));

        // Using default method
        addLambda.printResult(20, 30);

        // Using static factory
        MathOperation staticAdd = MathOperation.addition();
        System.out.println("Static factory add: " + staticAdd.operate(7, 3));

        System.out.println();

        // ---- 2. Custom Functional Interfaces ----
        System.out.println("--- 2. Custom StringTransformer & Validator ---");

        StringTransformer toUpper = s -> s.toUpperCase();
        StringTransformer trim = s -> s.trim();
        StringTransformer reverse = s -> new StringBuilder(s).reverse().toString();
        StringTransformer addPrefix = s -> "JAVA: " + s;

        System.out.println(toUpper.transform("hello world"));
        System.out.println(trim.transform("   spaces   "));
        System.out.println(reverse.transform("Hello"));
        System.out.println(addPrefix.transform("Interview Ready!"));

        Validator<String> notEmpty = s -> !s.isEmpty();
        Validator<Integer> isPositive = n -> n > 0;
        Validator<String> isEmail = s -> s.contains("@") && s.contains(".");

        System.out.println("Is 'hello' not empty? " + notEmpty.validate("hello"));
        System.out.println("Is -5 positive?        " + isPositive.validate(-5));
        System.out.println("Is 'test@email.com' email? " + isEmail.validate("test@email.com"));

        System.out.println();

        // ---- 3. BUILT-IN: Function<T, R> ----
        System.out.println("--- 3. Built-in: Function<T, R> (transform) ---");

        Function<String, Integer> strLength = s -> s.length();
        Function<Integer, String> intToStr = n -> "Number: " + n;
        Function<String, String> trim2 = String::trim; // Method reference!

        System.out.println("strLength: " + strLength.apply("Hello Java"));
        System.out.println("intToStr: " + intToStr.apply(42));
        System.out.println("trim2: '" + trim2.apply("  spaces  ") + "'");

        // andThen — chain functions
        Function<String, String> lenThenStr = strLength.andThen(intToStr);
        System.out.println("Chained (andThen): " + lenThenStr.apply("Hello"));

        System.out.println();

        // ---- 4. BUILT-IN: Consumer<T> ----
        System.out.println("--- 4. Built-in: Consumer<T> (no return) ---");

        Consumer<String> printer = s -> System.out.println("  >> " + s);
        Consumer<Integer> doubler = n -> System.out.println("  Doubled: " + (n * 2));

        printer.accept("Functional Programming");
        doubler.accept(21);

        // andThen — chain consumers
        Consumer<String> printAndLog = printer.andThen(s -> System.out.println("  [LOGGED]"));
        printAndLog.accept("Combined Consumer");

        System.out.println();

        // ---- 5. BUILT-IN: Supplier<T> ----
        System.out.println("--- 5. Built-in: Supplier<T> (no input, returns value) ---");

        Supplier<String> greeting = () -> "Hello, Java Developer!";
        Supplier<List<String>> listFactory = () -> new ArrayList<>();
        Supplier<Double> randomNum = Math::random; // Method reference

        System.out.println(greeting.get());
        System.out.println("New list: " + listFactory.get());
        System.out.printf("Random: %.4f%n", randomNum.get());

        System.out.println();

        // ---- 6. BUILT-IN: Predicate<T> ----
        System.out.println("--- 6. Built-in: Predicate<T> (returns boolean) ---");

        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isGreaterThan10 = n -> n > 10;
        Predicate<String> startsWithJ = s -> s.startsWith("J");

        System.out.println("Is 4 even? " + isEven.test(4));
        System.out.println("Is 15 > 10? " + isGreaterThan10.test(15));
        System.out.println("Does 'Java' start with J? " + startsWithJ.test("Java"));

        // Combine predicates: and, or, negate
        Predicate<Integer> evenAndGT10 = isEven.and(isGreaterThan10);
        Predicate<Integer> evenOrGT10 = isEven.or(isGreaterThan10);
        Predicate<Integer> notEven = isEven.negate();

        System.out.println("12 is even AND > 10: " + evenAndGT10.test(12));
        System.out.println("3 is even OR > 10:   " + evenOrGT10.test(3));
        System.out.println("7 is NOT even:        " + notEven.test(7));

        System.out.println();

        // ---- 7. BUILT-IN: BiFunction, UnaryOperator, BinaryOperator ----
        System.out.println("--- 7. BiFunction, UnaryOperator, BinaryOperator ---");

        BiFunction<String, Integer, String> repeat = (s, n) -> s.repeat(n);
        System.out.println("BiFunction repeat: " + repeat.apply("Java! ", 3));

        UnaryOperator<String> shout = s -> s.toUpperCase() + "!!!";
        System.out.println("UnaryOperator shout: " + shout.apply("hello"));

        BinaryOperator<Integer> max = (a, b) -> a > b ? a : b;
        System.out.println("BinaryOperator max(7,12): " + max.apply(7, 12));

        System.out.println();

        // ---- 8. METHOD REFERENCES (shorthand for lambdas) ----
        System.out.println("--- 8. Method References ---");

        // Type 1: Static method reference  ClassName::staticMethod
        Function<String, Integer> parseInt = Integer::parseInt;
        System.out.println("Static ref: Integer::parseInt: " + parseInt.apply("42"));

        // Type 2: Instance method on instance  instance::method
        String hello = "Hello World";
        Supplier<String> toLower = hello::toLowerCase;
        System.out.println("Instance ref: hello::toLowerCase: " + toLower.get());

        // Type 3: Instance method on class  ClassName::instanceMethod
        Function<String, String> toUpperRef = String::toUpperCase;
        System.out.println("Class ref: String::toUpperCase: " + toUpperRef.apply("java"));

        // Type 4: Constructor reference  ClassName::new
        Function<String, StringBuilder> sbFactory = StringBuilder::new;
        System.out.println("Constructor ref: StringBuilder::new: " + sbFactory.apply("Built!"));

        System.out.println();

        // ---- 9. STREAMS (Functional Interface Power) ----
        System.out.println("--- 9. Streams — Functional Interfaces in Action ---");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // filter (Predicate), map (Function), forEach (Consumer)
        List<Integer> result = numbers.stream()
            .filter(n -> n % 2 == 0)          // Predicate
            .map(n -> n * n)                   // Function
            .collect(Collectors.toList());

        System.out.println("Even squares: " + result);

        // Complex pipeline
        String names = Arrays.asList("alice", "bob", "charlie", "diana", "eve")
            .stream()
            .filter(s -> s.length() > 3)       // Predicate
            .map(String::toUpperCase)           // Method reference (Function)
            .sorted()                           // natural order
            .collect(Collectors.joining(", ")); // Collector

        System.out.println("Filtered names: " + names);

        System.out.println();

        // ---- 10. Passing behavior as parameter ----
        System.out.println("--- 10. Passing Behavior as Parameter ---");

        List<String> words = Arrays.asList("Banana", "Apple", "Cherry", "Mango");
        processAndPrint(words, s -> s.toUpperCase());       // Transform behavior
        processAndPrint(words, s -> s.substring(0, 3));    // Different behavior, same method!

        System.out.println("\n==========================================");
    }

    // Method that accepts a functional interface as parameter — Higher-Order Function
    static void processAndPrint(List<String> items, StringTransformer transformer) {
        System.out.print("Transformed: ");
        items.forEach(item -> System.out.print(transformer.transform(item) + " "));
        System.out.println();
    }
}
