package Java8.StreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo2 {
    static void main() {

        List<String> brand= Arrays.asList("Deloitte","Mercedes","Oracle","Accenture","Capgemini","Tcs","Infosec");

         //Process the Collection: its step one

  // 2nd step::       //convert the collection list into stream object

          Stream<String>stream=brand.stream();


          //Apply processing logic  terminate and immediate:
        Stream<String> upperstream  = stream.map(word->word.toUpperCase());

        //Collect the result:

     List<String> productions =   upperstream.collect(Collectors.toList());
        System.out.println(productions);


//Stream is a way of processing the collection is fast and efficient way :
    }
}
//Stream api  provides the functional approach to process the collection
//ava Stream API provides a functional approach to process data from collections, arrays,
// or other data sources using operations like filter, map, sorted, and collect.