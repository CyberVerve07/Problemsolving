package Java8.JavaStreamApiPractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Demo6 {

    //We have a list of String find the longest String
    public static void main(String[] args) {


        List<String> city = Arrays.asList("Himachal", "Rajasthan", "Punjab", "Kolkata", "Mumbai", "Delhi","Andhra","Bangalore");

        Optional<String> result = city.stream()
                .max(Comparator.comparing(ele -> ele.length()));
        System.out.println(result);

    }

}
