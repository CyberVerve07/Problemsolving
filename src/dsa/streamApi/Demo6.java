package dsa.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Demo6 {
    //We have a List of Integer, and we need to divide into odd and even

    public static void main(String[] args) {

        List<Integer>list= Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Map<Boolean, List<Integer>> result = list.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));

        System.out.println("Even numbers:"+result.get(true));
        System.out.println("Odd numbers:  " + result.get(false));



    }
}
