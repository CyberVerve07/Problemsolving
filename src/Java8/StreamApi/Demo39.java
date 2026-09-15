package StreamPractice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Demo39 {

    public static void main(String[] args) {
//Find the repeating elements


        List<Integer> numbers = Arrays.asList(
                10, 20, 30, 20, 40, 10, 50, 30, 60
        );

        numbers.stream()
                .filter(num -> Collections.frequency(numbers, num) > 1)  //filter the elements
                .distinct()
                .forEach(System.out::println);
    }
}