package Java8.JavaStreamApiPractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo4 {
    //We have a list and find the 2nd Highest number of a list

    public static void main(String[] args) {

        List<Integer>secondHighest= Arrays.asList(32,49,88,39,32,98,68,58,49,49,403,03,30,394,03,94,3094,30394,303904,5940);

          secondHighest.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .limit(1)
                  .collect(Collectors.toList())
                  .forEach(System.out::println);



    }
}
