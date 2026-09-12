package Java8.StreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo18 {
    public static void main(String[] args) {

        //We have a list and  find only the 2nd and 3rd element and return the String

        List<Integer>list= Arrays.asList(10,20,30,40,50);

         list.stream().skip(1)
                 .limit(2).collect(Collectors.toList())
                 .forEach(System.out::println);

    }
}



