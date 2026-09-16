package Java8.StreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo47 {
    public static void main(String[] args) {

        List<String> list= Arrays.asList("Delhi","Punjab","Bangalore","Kolkata","Mumbai","Himachal");


        //processing the 1 Gb data

           List<String>list1=list.parallelStream().filter(w->w.startsWith("H"))
                   //Parallel Stream is  multi thread  stream
                   //When we have the large amount of data for processing
                   //use the fork join poll
                   //Stream operation are lazy
                   //
                   .collect(Collectors.toList());
        System.out.println(list1);

    }
}
//Find which topic i used in my proiject
// where did you use tha hasmap , exception, steam, multithreading , string buffer builde and alos some more q uestion  luike tahztt
//map vs flatmap