package Java8.JavaStreamApiPractice;

import java.util.*;
import java.util.stream.Collectors;

public class Demo12 {
    public static void main(String[] args) {
        //Find all the duplicate element in the list

        List<Integer>nums= Arrays.asList(1,2,3,1,2,3,5,6,7,8,9,98,10,28);


        Set<Integer> duplicates = new HashSet<>();

        nums.stream()
                .filter(n -> !duplicates.add(n))
                .forEach(System.out::println);
    }
}
