package StreamPractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Demo56 {
    //We have a list find the Second-Highest number of a list

    public static void main(String[] args) {
        List<Integer>secondHighest= Arrays.asList(23,49,29,22,94,495,30,330,2903,2034,4923,493,49);

        Optional<Integer> result = secondHighest.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1).findFirst();
        if(result.isPresent()) {

            System.out.println(result);
        }
        else {
            System.out.println("No highest number is found in the list ");
        }

    }

}
