package Java8.StreamsInterview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P2_TopKWords {
    public static void main(String[] args) {
        List<String> sentences = List.of(
            "Java Stream API is powerful and elegant",
            "Java Streams provide functional style processing",
            "Powerful Java streams make code concise and readable"
        );

        Set<String> stopWords = Set.of("is", "and", "a", "an", "the", "in", "on", "or");
        int k = 3;

        List<Map.Entry<String, Long>> topKWords = sentences.stream()
            // 1. Tokenize words, convert to lowercase, and clean punctuation
            .flatMap(sentence -> Arrays.stream(sentence.toLowerCase().split("\\W+")))
            // 2. Filter out empty strings & stop words
            .filter(word -> !word.isBlank() && !stopWords.contains(word))
            // 3. Group by word and count occurrences
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            // 4. Stream map entries and apply multi-tier sorting
            .entrySet().stream()
            .sorted(
                Map.Entry.<String, Long>comparingByValue().reversed() // Primary: Highest count first
                         .thenComparing(Map.Entry.comparingByKey())    // Secondary: Alphabetical A-Z
            )
            .limit(k)
            .collect(Collectors.toList());

        System.out.println("=== Top " + k + " Most Frequent Words ===");
        topKWords.forEach(entry -> 
            System.out.println(entry.getKey() + " -> " + entry.getValue())
        );
    }
}
