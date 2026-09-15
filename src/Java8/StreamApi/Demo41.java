package Java8.StreamApi;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Demo41 {
    public static void main(String[] args) {

        List<Integer>list= Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //So in this list return the 2nd and 3rd element


         list.stream().skip(1).limit(2).collect(Collectors.toList())
                 .forEach(System.out::println);


    }
}
