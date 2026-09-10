package Java8.StreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo9 {
    static void main() {

          //Store the data by using the Collection

        List<String> city= Arrays.asList("Himachal","Delhi","Bangalore","Ahmadabad","Chennai","Chandigarh","Ajmer");

        //Convert the collection object into three stream

        Stream<String> inputstream=city.stream();
        //Find the name starting with A ->>use the filtering method

           Stream<String>filterdStream=inputstream.filter(c ->c.startsWith("A"))
                //   .map(w->w.toUpperCase())
                   .map(String::toLowerCase);
           //map is transform all the elements to

            //Collect and print the cities

         List<String >cityStartWithA=filterdStream.collect(Collectors.toList());

        System.out.println(cityStartWithA);


    }
}
//intermediate ->taking stream as a input like a chain of the method
 //Terminated->  Terminate the stream count and collect :

//map is work is on one d array
//flatmap work on the 2d array