package Java8.StreamApi;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Demo22 {
    public static void main(String[] args) {

        //We have a string so return the longest string

        List<String> given= Arrays.asList("JAVA","SPRING","KAFKA","REDIS","MICROSERVICES","DOCKER");

        //find the longest string
        Optional<String> res = given.stream().max(Comparator.comparing(e -> e.length()));

        //We will use the max to finding the highest length  of the String :

        System.out.println(res);

    }
}
