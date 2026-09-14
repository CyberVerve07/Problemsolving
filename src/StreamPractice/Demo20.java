package StreamPractice;

import java.util.Arrays;
import java.util.List;

public class Demo20 {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList(
                "Java", "Spring", "Kafka", "Redis", "Docker", "K8:", "Aditya");

        int maxLength = strings.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);

        strings.stream()
                .filter(str -> str.length() == maxLength)
                .forEach(System.out::println);
    }
}