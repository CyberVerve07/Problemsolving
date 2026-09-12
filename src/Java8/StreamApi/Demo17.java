package Java8.StreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo17 {
    //From the list  of Integer find the odd numbers  and return the squares


    public static void main(String[] args) {

        List<Integer>list= Arrays.asList(1,2,3,4,5,6);

        list.stream().filter(n->n%2!=0)
                .map(n->n*n)
                .collect(Collectors.toList())
                .forEach(System.out::println);






    }
}
