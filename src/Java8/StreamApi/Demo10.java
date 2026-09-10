package Java8.StreamApi;

import jdk.dynalink.linker.LinkerServices;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo10 {
    static void main() {

        List<List<String>> city= Arrays.asList(Arrays.asList("Bangalore","Chennai"),
                Arrays.asList("Hyderabad","Ahmadabad","Ajmer"),Arrays.asList("Delhi"));

        //flat map is used to convert the 2d array to one d array :

        System.out.println(city);

         List <String>output=city.stream().flatMap(list->list.stream().filter(w->w.startsWith("A"))).map(word->
                 word.toUpperCase()).collect(Collectors.toList());


        System.out.println(output);

    }



}
