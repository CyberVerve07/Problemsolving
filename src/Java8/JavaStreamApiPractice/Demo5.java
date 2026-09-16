package Java8.JavaStreamApiPractice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo5 {
    public static void main(String[] args) {
        //We have a list and fid the numbers into even and odd

        List<Integer>numbers= Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Map<Boolean, List<Integer>> result = numbers.stream()
                .collect(Collectors.partitioningBy(elem -> elem % 2 == 0));

        System.out.println(result);

    }
}
