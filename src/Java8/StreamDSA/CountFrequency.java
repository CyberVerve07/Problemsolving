package Java8.StreamDSA;

import java.util.Map;
import java.util.stream.Collectors;

public class CountFrequency {
    static void main() {

        String input="banana";

          //Count the frequency of each character in String :

        Map<Character, Long>freq= (Map<Character, Long>) input.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(c->c,Collectors.counting()));
        System.out.println(freq);


    }
}
