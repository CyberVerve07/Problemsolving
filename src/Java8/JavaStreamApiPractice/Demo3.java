package Java8.JavaStreamApiPractice;

import java.util.Arrays;
import java.util.List;

public class Demo3 {

    //We have a list of Integer and return the 2nd and 3rd element of the list

    public static void main(String[] args) {

        List<Integer>list= Arrays.asList(20,30,40,50,60,70,80,90,100);


          list.stream()
                  .skip(1)
                  .limit(2)
                  .forEach(System.out::println);


    }
}
