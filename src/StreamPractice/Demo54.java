package StreamPractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo54 {
    //We have a list of Integer find the 2nd and 3 element in the list and

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 9, 7, 38, 59, 33, 5, 59, 46, 894, 94);

        list.stream()
                .distinct()
                .skip(1)
                .limit(2)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}