package StreamPractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Demo2 {

    public static void main(String[] args) {

        List<Integer> number =
                Arrays.asList(10, 30, 40, 50, 60, 70, 90, 80, 45, 79, 98, 88, 90);

        int result = number.stream()
                .distinct()//Remove dupliate
                .sorted(Comparator.reverseOrder()) //Sorted in dessinding order
                .skip(1)//skip the first element
                .findFirst()//find first element
                .orElseThrow();// or else throw
        System.out.println(result);
    }
}