package Java8.StreamApi;

import java.util.Arrays;
import java.util.List;

public class Demo3 {
    static void main(String[] args) {



        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> result = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 10)
                .toList();
        System.out.println(result);
    }
}
