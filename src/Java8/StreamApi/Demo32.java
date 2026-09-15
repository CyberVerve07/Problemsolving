package Java8.StreamApi;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo32 {
    // Write a code to find the  length of the given List


    public static void main(String[] args) {

        List<String> city= Arrays.asList("Delhi","Punjab","Ahmadabad","Maharashtra","Himachal","Bangalore");


        Map<Integer, List<String>> result = city.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(result);

    }


}
