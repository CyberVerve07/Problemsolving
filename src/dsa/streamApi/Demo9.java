package dsa.streamApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Demo9 {
    //Find the Second Highest number of the List using the string

    public static void main(String[] args) {

        List<Integer> num= Arrays.asList(10,40,66,50,30,20,20,40,30,20,55,99);

        Optional<Integer> result = num.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1).
                findFirst();
        System.out.println("The Second highest number is :"+result);

    }
}
