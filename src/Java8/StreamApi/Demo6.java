package Java8.StreamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo6 {
    public static void main(String args[]){

        List<String>list= Arrays.asList("KodeWala accedmy","Banglore at BTM","June Batch:") ; //Create a list

         //Convert into an stream

        Stream<String> stream = list.stream();

           //print the list

           //USe the lambda expression to print each element iteam :

           stream.forEach(iteam-> System.out.println(list));


    }
}
