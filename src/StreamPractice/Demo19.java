package StreamPractice;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Demo19 {
    //We have a list of String find the longest String in the list


    public static void main(String[] args) {


        List<String> strings = Arrays.asList("Java", "Spring", "Kafka", "Redis", "Docker", "K8:","Aditya");

        Optional<String> result = strings.stream()
                .max(Comparator.comparing(ele -> ele.length()));
        System.out.println(result);


    }

}
