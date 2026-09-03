package Java8.StreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo8 {
    static void main() {
        //Performing the Intermediate Operartions:

        List<String>words= Arrays.asList("Hi","Hello","Java","Spring","Spring Boot");

         //Create a Stream and filter

        Stream<String>output=words.stream().filter(w->w.length()>=3);//Lambda keep the word with 3


         //Terminal operation using the labda to print the each element

         output.forEach(wo-> System.out.println(words));

    }
}
