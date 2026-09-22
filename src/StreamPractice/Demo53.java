package StreamPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo53 {
    //From a list of Integer find all the Odd numbers and return their squares

    public static void main(String[] args) {
        List<Integer>list= Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        list.stream()
                .filter(num->num%2!=0)
                .map(n->n*n)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
