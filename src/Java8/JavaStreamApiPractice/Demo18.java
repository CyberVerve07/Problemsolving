package Java8.JavaStreamApiPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Demo18 {
    public static void main(String[] args) {

 //We have a list of integer we need  remove the duplicate and sort in desending order 

        List<Integer>list= Arrays.asList(10,50,90,80,87,67,10,20,80,3,39,20,90,00,33,00,33,4,5,4,30,40093,404,0);
        
        
        //Performing the stream api operation

        List<Integer> result = list.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(result);

    }
}
