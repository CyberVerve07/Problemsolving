package dsa.streamApi;

import jdk.dynalink.linker.LinkerServices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Demo2 {
    public static void main(String[] args) {

        //Wap to remove the duplicate and sort them into descending order
        List<Integer> list= Arrays.asList(1,2,3,4,5,5,4,3,2,1,4,5,5,3,5,5,3,2,2,32,3,4,2);

        list.stream()
                .distinct()     //remove the duplicate
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList())
                .forEach(System.out::println);


    }
}
