package Java8.JavaStreamApiPractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Demo1 {
    //Given a list of Integer and remove the duplicate elements and sort in decending order

    public static void main(String[] args) {

        List<Integer>list= Arrays.asList(10,34,50,33,90,10,34,89,98,99,98,7);

list.stream()
        .distinct()
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.toList())
        .forEach(System.out::println);

    }

}
