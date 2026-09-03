package Java8.StreamDSA;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Reverse {
    public static void main(String[] args) {
        String sentence = "Java Spring Boot";

        // Step 1: Split by whitespace, Step 2: Reverse each word, Step 3: Join with a space
        String result = Arrays.stream(sentence.split("\\s+"))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));

        System.out.println(result); // Output: avaJ gnipdrS tooB (or whatever word-level reverse is intended)
    }
}