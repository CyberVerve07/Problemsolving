package Java8.JavaStreamApiPractice;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo11 {
    //Count the frequency of each character in a String


    public static void main(String[] args) {

        String input="banana";


        Map<Character, Long> reesult = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        System.out.println(reesult);
    }
}
