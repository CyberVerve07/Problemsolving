package Java8.StreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo21 {
    public static void main(String[] args) {

         //We have a number of Integer Divide number into even and odd

        List<Integer>number= Arrays.asList(10,30,50,40,3,7,9,8);

        //When ever we need to split a data into two parts we have a special method called par

        Map<Boolean, List<Integer>> collect = number.stream().collect(Collectors.partitioningBy(e -> e % 2 == 0));

        System.out.println(collect);
        //So the elements satisy this condition comes under this and that not comes under false




    }
}
