package StreamPractice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Demo5 {

    public static void main(String[] args) {

        List<String> items = Arrays.asList(
                "Java", "Spring", "Java", "Kafka",
                "Spring", "Java", "Redis"
        );

        Optional<Map.Entry<String, Long>> result = items.stream()
                .collect(Collectors.groupingBy(
                        item -> item,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());

        result.ifPresent(entry ->
                System.out.println(entry.getKey() + " -> " + entry.getValue())
        );
    }
}