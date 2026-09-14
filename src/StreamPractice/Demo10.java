package StreamPractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Demo10 {
    public static void main(String[] args) {

        //We have a list of integer and get only 2nd and 3rd element of the list

        List<Integer>numbers= Arrays.asList(10,20,30,40,50,60,70);

        numbers.stream()
                .limit(3)
                .skip(1).
                collect(Collectors.toList()).forEach(System.out::println);

    }
}
