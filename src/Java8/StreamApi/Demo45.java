package Java8.StreamApi;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Demo45 {
    // We have a list of String and we need to find the longest String


    public static void main(String[] args) {

        List<String> list = Arrays.asList("Core_Java","Kafka","Spring","Spring boot","Docker","Kubernetes8");


        Optional<String> result = list.stream()
                .distinct()
                .max(Comparator.comparingDouble(elem -> elem.length()));

        System.out.println(result);
    }






}
