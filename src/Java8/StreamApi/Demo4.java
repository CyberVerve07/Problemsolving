package Java8.StreamApi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Demo4 {
    static void main() {

        List<Integer>list=new ArrayList<>();

        //Convert the list into the stream:

        Stream<Integer> stream = list.stream();

          list.forEach(elem-> System.out.println(elem));


    }
}
