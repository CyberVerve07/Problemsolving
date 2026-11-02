package dsa.streamApi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Demo11 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 8, 9, 4, 3, 2, 1, 3, 5, 7, 8, 3, 4, 5, 6, 7);

        Set<Integer> seen = new HashSet<>();

        Set<Integer> duplicates = numbers.stream()
                .filter(n -> !seen.add(n)) // add() returns false if 'n' is already in 'seen'
                .collect(Collectors.toSet());

        System.out.println(duplicates); // Output: [1, 3, 4, 5, 7, 8]




    }
}