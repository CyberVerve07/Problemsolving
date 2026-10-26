package dsa.streamApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FindSecondHighestNumber {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 84, 90, 30, 24, 4, 304, 50, 98);

        Optional<Integer> secondHighest = numbers.stream()
                .distinct()                         // 1. Deduplicate first to reduce sort overhead
                .sorted(Comparator.reverseOrder())  // 2. Sort remaining elements descending
                .skip(1)                            // 3. Bypass the largest element
                .findFirst();                       // 4. Terminal operation returning Optional

        secondHighest.ifPresentOrElse(num -> System.out.println("Second highest: " + num),
                () -> System.out.println("List does not contain at least two distinct numbers.")
        );
    }
}