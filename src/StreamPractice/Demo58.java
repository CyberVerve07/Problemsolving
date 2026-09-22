package StreamPractice;

import javax.swing.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Demo58 {
    //We have a list and need to find the longest String of a list
    public static void main(String[] args) {
        List<String>list= Arrays.asList("Java","CoreJava","Spring","SpringBoot");

        Optional<String> max = list.stream()
                .distinct()
                .max(Comparator.comparing(elem -> elem.length()));
        System.out.println(max);


    }
}
