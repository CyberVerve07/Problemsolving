package Collections.Practice;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo3 {
    public static void main(String[] args) {
        ArrayList<Integer>list1=new ArrayList<>(Arrays.asList(10,20,30,9));
        ArrayList<Integer>list2=new ArrayList<>(Arrays.asList(10,20,30));
        System.out.println(list1.equals(list2));
        System.out.println(list1.contains(290));


    }
}
