package dsa.streamApi;

import java.util.List;

public class Demo13 {
    public static void main(String[] args) {

        List<String> names = List.of("Aditya", "Aman", "Rahul", "Ankit", "Rohit");
        char ch = 'A';

        names.stream()
                .filter(name -> name.startsWith(String.valueOf(ch)))
                .forEach(System.out::println);
    }
}