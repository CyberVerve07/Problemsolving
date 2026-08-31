package Java8.StreamsInterview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P3_FirstNonRepeatingChar {
    public static void main(String[] args) {
        String input = "swiss algorithm in java streams";

        Character firstNonRepeating = input.chars()
            .mapToObj(c -> (char) c)
            .filter(c -> !Character.isWhitespace(c)) // Ignore spaces
            .collect(Collectors.groupingBy(
                Function.identity(),
                LinkedHashMap::new, // Mandatory: Preserves insertion order!
                Collectors.counting()
            ))
            .entrySet().stream()
            .filter(entry -> entry.getValue() == 1)
            .map(Map.Entry::getKey)
            .findFirst()
            .orElse(null);

        System.out.println("Input String: \"" + input + "\"");
        System.out.println("First non-repeating character: " + firstNonRepeating);
    }
}
