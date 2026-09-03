package Java8.StreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo8 {
    static void main() {

        List<Integer> num= Arrays.asList(10,20,30,40,50,60,70,80,90,100);
         num.stream().filter(n->(n%2==0)).forEach(a-> System.out.println(a));


    }
}
