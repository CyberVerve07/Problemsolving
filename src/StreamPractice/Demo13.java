package StreamPractice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo13 {

    public static void main(String[] args) {

        List<Integer> numbers =
                Arrays.asList(10, 20, 30, 20, 40, 10, 50, 30, 60);

        Map<Integer, Long> frequency = numbers.stream()
                .collect(Collectors.groupingBy(
                        n -> n,
                        Collectors.counting()
                ));

        frequency.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey())
                .forEach(System.out::println);
    }
}