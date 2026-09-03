package Java8.StreamDSA;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestString {
    static void main() {

        List<String>words= Arrays.asList("cat","elephant","tiger","hippopotamus");



          String longest=words.stream().max(Comparator.comparingInt(String::length)).orElse("");
        System.out.println("Longest word:"+longest);


        
    }
}
