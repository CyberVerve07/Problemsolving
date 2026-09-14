package StreamPractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Demo17 {
    //Find the second-highest number of a list

    public static void main(String[] args) {


        List<Integer> numbers= Arrays.asList(90,22,24,5,38,8,39,39,90,38,55,89);

          numbers.stream()
                  .distinct().
        sorted(Comparator.reverseOrder())
                  .skip(1)
                  .limit(1)
                  .forEach(System.out::println);




    }
}
