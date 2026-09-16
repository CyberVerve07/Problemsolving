package Java8.JavaStreamApiPractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo2 {
    public static void main(String[] args) {
//From a lost of interger find all the odd numbers and return their squares

        List<Integer>list= Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        list.stream()
                .filter(n->n%2!=0)
                .map(n->n*n)
                .collect(Collectors.toList())
                .forEach(System.out::println);




    }
}
