package Java8.JavaStreamApiPractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo21 {
    public static void main(String[] args) {

        //We have a list and find the 2nd highest element of the list
        //Perform the logic

         List<Integer>list1=Arrays.asList(1,4,5,7,8,9,90,98,90,2,3,4,5,4,32,5,93);

          //Performing the logig finding the Second-highest number

        Stream<Integer> result = list1.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                        .limit(1);
        System.out.println(result);



    }
}