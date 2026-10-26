package dsa.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo5 {
    public static void main(String[] args) {
        //Find 2d and 3rd element of the list

        List<Integer>list= Arrays.asList(10,20,30,40,50,60,70,80);


          list.stream()
                  .skip(1)
                  .limit(2)
                  .collect(Collectors.toList())
                  .forEach(System.out::println);

    }
}
