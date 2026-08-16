package Collections.list;

import java.util.ArrayList;

public class Demo15 {
    public static void main(String[] args) {
        //An ArrayList allows duplicate values because it is an index-based data structure backed by a standard array.
        // It is designed to track elements by their specific positions,
        // meaning the identity of an element is determined by its index, not its


        ArrayList<String> list = new ArrayList<>();
        {
            list.add("Ram");
            list.add("Ram");
            list.add("Ram");
            System.out.println(list);


        }
    }
}
