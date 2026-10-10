package Java8.JavaStreamApiPractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo20 {
    public static void main(String[] args) {
        //We havena list of integer return the second and 3rd element of the list
        List<Integer>list= Arrays.asList(10,40,30,50,60,80,90,80,72);

        list.stream()
                .skip(1)
                .limit(2)
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }
}
