package StreamPractice;

import java.util.Arrays;
import java.util.List;

public class Demo50 {
    public static void main(String[] args) {

        List<String> list = Arrays.asList(
                "Java", "Spring", "API", "Java", "Kafka"
        );

        long result = list.stream()
                .filter(s -> s.length() >= 4)
                .distinct()
                .map(String::toUpperCase)
                .count();

        System.out.println(result);
    }
}
