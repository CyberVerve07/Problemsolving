package StreamPractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Demo11 {
    public static void main(String[] args) {
        //Find the Second-highest number of a list
        List<Integer>numbers= Arrays.asList(10,10,10);

        Optional<Integer> result = numbers.stream()


                .distinct().
                sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();

        if (result.isPresent()) {
            System.out.println(result);
        }



    }
}
