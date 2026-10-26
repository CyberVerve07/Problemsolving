package dsa.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {
        List<List<String>> teamPlayers = Arrays.asList(
                Arrays.asList("Aditya", "Rohit"),
                Arrays.asList("Charlie", "Smith"),
                Arrays.asList("Eva")
        );

        // Using flatMap to merge inner lists into a single stream
        List<String> allPlayers = teamPlayers.stream()
                .flatMap(List::stream) // Converts each List<String> into a Stream<String>
                .collect(Collectors.toList());

        System.out.println(allPlayers);
        // Output: []
    }
}
