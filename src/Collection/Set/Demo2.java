package Collections.Set;

import java.util.HashSet;
import java.util.Set;

public class Demo2 {
    public static void main(String[] args) {

//        Set<String>set=new HashSet<>();
//        set.add("Chen");
//        set.add("BLR");
//        set.add("Kol");
//        set.add("Mumbai");
//        set.add("Delhi");
//        set.add("BlR");
//        set.add("Mumbai");
//
//        System.out.println(set);}
//Bitwise & operator is used for creating the formula :::

//Hash set is a Set interface that stores unique elements and use Hashmap internally :
        HashSet<String> set = new HashSet<>();

        set.add("Apple");
        set.add("Mango");
        set.add("Apple");
        set.add("Banana");
        System.out.println(set);
        //HashSet does not guarantee any iteration order.

    }
}