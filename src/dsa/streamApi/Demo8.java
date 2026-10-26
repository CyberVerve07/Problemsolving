package dsa.streamApi;

import java.util.Arrays;
import java.util.List;

public class Demo8 {
    //map is a method in strea used for one to one transformation

    public static void main(String[] args) {

        List<String>list= Arrays.asList("Ram","Sita","Ram");

         list.stream()
                 .map(String::length)
                 .forEach(System.out::println);
    }
}
