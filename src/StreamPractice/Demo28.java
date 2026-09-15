package StreamPractice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Demo28 {

    public static void main(String[] args) {

        List<Integer> numbers =
                Arrays.asList(10, 20, 30, 60, 70, 80, 90);


        // =====================================================
        // 1. findFirst()
        // First matching element mile hi result complete
        // =====================================================

        Optional<Integer> first = numbers.stream()
                .filter(n -> {
                    System.out.println("findFirst checking: " + n);
                    return n > 50;
                })
                .findFirst();

        System.out.println("findFirst result = " + first.orElse(null));


        // =====================================================
        // 2. findAny()
        // Koi matching element milte hi result mil sakta hai
        // =====================================================

        Optional<Integer> any = numbers.stream()
                .filter(n -> {
                    System.out.println("findAny checking: " + n);
                    return n > 50;
                })
                .findAny();

        System.out.println("findAny result = " + any.orElse(null));


        // =====================================================
        // 3. anyMatch()
        // Ek bhi element condition satisfy kare -> true
        // =====================================================

        boolean anyMatch = numbers.stream()
                .anyMatch(n -> {
                    System.out.println("anyMatch checking: " + n);
                    return n > 50;
                });

        System.out.println("anyMatch result = " + anyMatch);


        // =====================================================
        // 4. allMatch()
        // Ek bhi element fail hua -> false
        // =====================================================

        boolean allMatch = numbers.stream()
                .allMatch(n -> {
                    System.out.println("allMatch checking: " + n);
                    return n > 5;
                });

        System.out.println("allMatch result = " + allMatch);


        // =====================================================
        // 5. noneMatch()
        // Ek bhi matching element mila -> false
        // =====================================================

        boolean noneMatch = numbers.stream()
                .noneMatch(n -> {
                    System.out.println("noneMatch checking: " + n);
                    return n < 5;
                });

        System.out.println("noneMatch result = " + noneMatch);


        // =====================================================
        // 6. limit()
        // Sirf first 3 elements process
        // =====================================================

        System.out.println("limit() result:");

        numbers.stream()
                .peek(n -> System.out.println("limit checking: " + n))
                .limit(3)
                .forEach(System.out::println);
    }
}