package dsa.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo4 {
    public static void main(String[] args) {
        //find the odd number and  square them.
        List<Integer>list= Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        list.stream()
                .filter(n->n%2==0)
                .map(n->n*n)
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }
}
