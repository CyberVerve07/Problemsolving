package Java8.StreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo12 {
    static void main() {
         //2.	to uppercase.Given a list of employee names, use map() to convert all names


        List<String> employee= Arrays.asList("Aditya","Prachi","Harsh","Rahul","Anup","Kanshika");

           //Convert the Collection into a stream

        Stream<String> stream = employee.stream().map(e->e.toUpperCase());

         stream.forEach(System.out::println);


    }
}
