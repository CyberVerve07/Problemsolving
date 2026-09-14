package StreamPractice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo24 {

    // Find unique elements which occur only once and sort them

    public static void main(String[] args) {

        List<Integer> list =
                Arrays.asList(10, 20, 30, 40, 10, 20, 30, 40, 50);

        list.stream()
                .collect(Collectors.groupingBy(
                        num -> num,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .sorted()
                .forEach(System.out::println);
    }
}