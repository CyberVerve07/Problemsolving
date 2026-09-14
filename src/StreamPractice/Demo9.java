package StreamPractice;

import org.w3c.dom.ls.LSInput;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo9 {
    public static void main(String[] args) {
        //Given an list remove the duplicate element and print into in assending order


        List<Integer>numbers= Arrays.asList(10,20,10,30,40,50,60,70,90,30,30,380,300,200,30,300,300,3080,38884,044,488,4893,904940,4994,84,4904,84,94);


        List<Integer> result = numbers.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());


        System.out.println(result);
    }
}
