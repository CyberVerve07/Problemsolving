package dsa.streamApi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Demo1 {
    //Wap remove the duplicate value from the list and return the unique value from the list without using the distinct method of stream api

    public static void main(String[] args) {

        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10);


        HashSet<Integer>list2=new HashSet<>(list);

        System.out.println(list2);



    }
}
