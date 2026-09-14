package StreamPractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo15 {
    //From a list of integer find the odd numbers and return their square

    public static void main(String[] args) {
        List<Integer>numbers= Arrays.asList(1,2,3,4,5,6,7,8,9,10);

         numbers.stream()
                 .distinct()
                 .filter(num->num%2!=0)
                 .map(num->num*num)
                 .collect(Collectors.toList())
                 .forEach(System.out::println);

    }

}
