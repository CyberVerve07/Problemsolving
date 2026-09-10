package Java8.StreamApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Demo16 {
    public static void main(String[] args) {

        //We have give the list and in that we need to  remove the duplicate element ans also make the  list sorted

        List<Integer>numbers= Arrays.asList(10,39,49,10,39,9,78,3,4,5,2,4,4,5,78,93,7,38);

         //so first i want to convert the list into and stream anad after that perform thge operations

           numbers.stream()
                   .distinct()
                   .sorted(Comparator.reverseOrder())
                   .forEach(System.out::println);



    }
}
