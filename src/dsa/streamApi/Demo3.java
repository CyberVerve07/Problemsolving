package dsa.streamApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Demo3 {
    public static void main(String[] args) {
        //Write a program remove the duplicate elements in the list and sort in desending order

        List<Integer>list= Arrays.asList(1,2,3,4,5,6,4,5,3,2,10,20,10,20);

         list.stream()
                 .distinct()
                 .sorted(Comparator.reverseOrder())
                 .forEach(System.out::println);

    }
}
