package Java8.StreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo44 {
    public static void main(String[] args) {
        //You have a list of integer a dived it into an even and odd

        List<Integer>list= Arrays.asList(1,2,3,4,5,6,7,8,9,10);


        Map<Boolean, List<Integer>> result = list.stream()
                .collect(Collectors.partitioningBy(ele -> ele % 2 == 0));
        System.out.println(result);

    }
}
//When ever divide or separate the list use the Partition by method instead of List

