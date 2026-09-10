package Java8.StreamApi;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo11 {
    static void main() {

         //Given a list of integers, use filter() to find all numbers greater than 50.


        List<Integer>numbers= Arrays.asList(39,87,67,34,23,12,87,377,980,37);

              //Convert the Collection into the  stream

        Stream<Integer>integerStream=numbers.stream();
        //filter
           Stream<Integer>filter=integerStream.filter(number->number>50);

            //use the for each for terminate the stream result :

           filter.forEach(integer -> System.out.println(integer));



    }
}
