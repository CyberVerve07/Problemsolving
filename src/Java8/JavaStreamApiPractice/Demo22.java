package Java8.JavaStreamApiPractice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo22 {
    public static void main(String[] args) {
        //We have a list of integer, and we need to find the odd and even numbers into spetate list


        List<Integer>list= Arrays.asList(1,2,3,4,5,6,7,8,9,10);


        Map<Boolean, List<Integer>> result = list.stream()
                .collect(Collectors.partitioningBy(ele -> ele % 2 == 0));
        System.out.println(result);
        
    }
}
