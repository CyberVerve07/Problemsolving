package StreamPractice;

import java.util.Arrays;
import java.util.List;

public class Demo7 {
    public static void main(String[] args) {
        //code for finding the even number

        List<Integer>numbers= Arrays.asList(10,20,30,23,24,49,58,78,48,49,48,30,38,38,30,39,39,39,30,30,303,49,48,80,48,48,3);

        numbers.stream()
                .distinct()
                .filter(num->num%2==0)
                .map(n->n*n)
                .forEach(System.out::println);



    }
}
