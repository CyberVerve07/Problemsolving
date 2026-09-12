package Java8.StreamApi;

import java.util.Arrays;
import java.util.List;

public class Demo13 {
    public static void main(String[] args) {


        List<Integer>num= Arrays.asList(30,20,59,39,89,90,100,10,45,98,78);


          num.stream().sorted().forEach(System.out::println);

    }
}
