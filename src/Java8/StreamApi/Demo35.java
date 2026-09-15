package Java8.StreamApi;

import java.util.Map;
import java.util.stream.Collectors;

public class Demo35 {
    public static void main(String[] args) {

        String input="RadheKrishna";


        Map<Character, Long> result = input.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(result);

    }
}
