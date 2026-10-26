package dsa.streamApi;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class PartitionEvenOdd {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.partitioningBy(num -> (num & 1) == 0)); // Bitwise check or num % 2 == 0

        System.out.println("Even numbers:"+partitioned.get(true));
        System.out.println("Odd numbers:  " + partitioned.get(false));
    }
}