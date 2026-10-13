package Java8.JavaStreamApiPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Demo23 {
    public static void main(String[] args) {
        //Write a java Program Remove the duplicate element wihout using the distin method

        List<Integer>list= Arrays.asList(1,3,2,1,3,2,4,5,4,5);

        //So i will convert the list into and Hashset

        HashSet<Integer> result=new HashSet<>(list);

        System.out.println(result);

}
}
