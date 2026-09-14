package StreamPractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo8 {
    //Find all the odd numbers and return their squares
    public static void main(String[] args) {


        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30, 45, 40, 50, 55, 60, 65, 65, 78, 89, 90, 90);

        numbers.stream().distinct()
                .filter(num->num%2!=0)
                .map(n->n*n)
                .forEach(System.out::println);


    }


}
//for finding the odd number the formula is that

 //if (n%2!=0)
//(n%2!=0)

