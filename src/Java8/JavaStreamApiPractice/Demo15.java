package Java8.JavaStreamApiPractice;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo15 {
    //Merge the two list and remove the duplicate elements

    public static void main(String[] args) {
        List<Integer>list1= Arrays.asList(1,2,3,4,5);
        List<Integer>list2=Arrays.asList(1,2,3,4,5,6,7,8,9,10);

         //performer the logic

        List<Integer> merged = Stream.concat(list1.stream(), list2.stream())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("The merged list is "+merged);


    }
}
