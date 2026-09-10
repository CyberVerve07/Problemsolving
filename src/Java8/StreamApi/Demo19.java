package Java8.StreamApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Demo19 {

    public static void main(String[] args) {

        // Find the second-highest number of a list

        List<Integer> list = Arrays.asList(
                10, 10, 20, 30, 89, 98, 90, 39, 90,
                394, 949, 399, 3885, 5784, 8489, 384
        );

        Optional<Integer> result = list.stream()
                .distinct() //remove the duplicate
                .sorted(Comparator.reverseOrder()) //to sort the elemnts
                .skip(1)//skip the number
                .findFirst();


        System.out.println(result);
    }
}