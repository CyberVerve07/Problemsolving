package Java8.StreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo26 {
    public static void main(String[] args) {
        //Find the Frequency of each element

         List<Integer> numbers= Arrays.asList(1,2,1,2,3,2,3,4,5,5,3,6,7,6,6,5,7,9,7,8,8,9);

          //Convert the list into  Stream


        Map<Integer, Long> result = numbers.stream().collect(Collectors.groupingBy(elem -> elem, Collectors.counting()));

        System.out.println(result);

    }

}
//For finding the frequenct we will use the grouping  method and after that we use the Coolector,counting ::


