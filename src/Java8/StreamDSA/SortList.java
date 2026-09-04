package Java8.StreamDSA;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortList {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "orange", "Kiwi");
        // Corrected stream pipeline with valid syntax, proper comparator placement, and correct casing
        words.stream()
                .sorted(Comparator.comparingInt(w -> w.length()))
                .forEach(word -> System.out.println(word));
    }
}