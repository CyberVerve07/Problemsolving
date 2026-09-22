package StreamPractice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo57 {
    //We have a list of Integer we need to divide the list into even and odd

    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Map<Boolean, List<Integer>> result = list.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));
        System.out.println(result);
    }
}
