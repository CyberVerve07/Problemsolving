package StreamPractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Demo14 {
    public static void main(String[] args) {
//Give a list of integer remove duplicate and sort it into the desending orde


        List<Integer>numbers= Arrays.asList(10,20,30,40,50,10,20,30,40,50);

          numbers.stream()
                  .distinct()
                  .sorted(Comparator.reverseOrder())
                  .forEach(System.out::println);


    }
}
