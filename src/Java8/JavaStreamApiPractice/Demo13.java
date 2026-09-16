package Java8.JavaStreamApiPractice;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Demo13 {

    // Reverse each word in the sentence

    public static void main(String[] args) {

        String sentence = "Ram Ram ";

        String result = Arrays.stream(sentence.split(" "))
                .map(word -> new StringBuilder(word)
                        .reverse()
                        .toString())
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }
}