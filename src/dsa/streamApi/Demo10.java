package dsa.streamApi;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo10 {
    public static void main(String[] args) {
        String input = "Banana";

        Map<Character, Long> frequencyMap = input.chars() // Returns IntStream of ASCII/Unicode values
                .mapToObj(c -> (char) c)                  // Cast int to char and auto-box to Character
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        System.out.println(frequencyMap); // Output: {a=3, B=1, n=2}
    }
}