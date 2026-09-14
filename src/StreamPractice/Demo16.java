package StreamPractice;

import java.util.Arrays;
import java.util.List;

public class Demo16 {
    public static void main(String[] args) {
        //We have a list of Integer return only the 2nd and 3rd element from the list

        List<Integer>list= Arrays.asList(10,20,30,40,50,60);

          list.stream()
                  .distinct()
                  .skip(1)
                  .limit(2)
                  .forEach(System.out::println);

    }
}
