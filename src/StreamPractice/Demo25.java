package StreamPractice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo25 {
    public static void main(String[] args) {
        //find the frequency of the List :
        List<Integer> list= Arrays.asList(10,10,10,20,20,30,40,50,60,10,20,40,50,60);

        Map<Integer, Long> result = list.stream().collect(Collectors.groupingBy(elem -> elem,
                Collectors.counting()));
//By grouping and performing the Collectors . counting method :

        System.out.println(result);



    }
}
