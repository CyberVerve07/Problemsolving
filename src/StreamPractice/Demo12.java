package StreamPractice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo12 {
    //Given an list of integer divide an number into even or odd
    public static void main(String[] args) {


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);


        Map<Boolean, List<Integer>> reslt = numbers.stream()
                .collect(Collectors.partitioningBy(elem -> elem % 2 == 0));
        System.out.println(reslt);

    }
}