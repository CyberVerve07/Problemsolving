package Java8.JavaStreamApiPractice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Demo14 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 45, 23, 67,92,99,29,49,29,349,493,9303,93030,9393,3900000);

        // Return type of stream.max() is Optional<Integer>
        Optional<Integer> maxOpt = numbers.stream()
                .distinct().max(Integer::compare);

        maxOpt.ifPresent(max -> System.out.println("Maximum value: " + max));
    }
}

