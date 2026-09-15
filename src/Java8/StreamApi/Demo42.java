package Java8.StreamApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Demo42 {

    //So we have a list and find the second-Highest number of  list


    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(10, 23, 40, 58, 90, 48);


        Optional<Integer> result = list.stream().distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1).findFirst();

        if (result.isPresent()) {
            System.out.println(result);
        }

else {
            System.out.println("No element is smaller than the existing element ");
        }
    }
}
