package Java8.JavaStreamApiPractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo19 {
    public static void main(String[] args) {
        //From a list of integer find all the odd number and  return the square

        List<Integer>list= Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //Implement the stream logic

         list.stream()
                 .filter(num->num%2==0)
                 .map(num->num*num)
                 .collect(Collectors.toList())
                 .forEach(System.out::println);

    }
}
