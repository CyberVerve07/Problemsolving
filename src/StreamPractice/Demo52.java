package StreamPractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Demo52 {
    //Given a list of integer remove the duplicate and sort them into and descending order

    public static void main(String[] args) {

        List<Integer> list= Arrays.asList(7,30,29,49,202,40,30,29,89,289,9,29,202,4,494,494,49,49,30,39);

        list.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }
}
