package Java8.JavaStreamApiPractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Demo10 {
    //Find the Second-highest number in the list

    public static void main(String[] args) {

        List<Integer>number= Arrays.asList(10,20,30,40,50,60,70);

         number.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .limit(1)
                 .forEach(System.out::println);




    }
}
