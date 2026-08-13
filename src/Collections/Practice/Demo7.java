package Collections.Practice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo7 {
    public static void main(String[] args) {


       ArrayList<String> list=new ArrayList<>(Arrays.asList("A","B", "C","D"));
        ArrayList <String>sub= (ArrayList) list.subList(1,3);
        list.remove(0);
        System.out.println(list);

    }
}
