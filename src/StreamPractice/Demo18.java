package StreamPractice;

import august.augest3.Exception.Liabrary;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo18 {
    //We have a list of integer divide the numbers into even and odd


    public static void main(String[] args) {

        List<Integer>numbers= Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Map<Boolean, List<Integer>> result = numbers.stream()
                .collect(Collectors.partitioningBy(ele -> ele % 2 == 0));
        System.out.println(result);


    }
}
