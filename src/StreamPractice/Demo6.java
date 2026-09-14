package StreamPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Demo6 {
    public static void main(String[] args) {
        //Given a list of integer remove duplicate and sort in an descending order

        List<Integer>numbers= Arrays.asList(10,20,30,20,40,50,60,89);


        List<Integer> result = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(result);

    }
}
