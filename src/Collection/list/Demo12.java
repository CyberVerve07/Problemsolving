package Collections.list;

import java.util.ArrayList;

public class Demo12 {
    public static void main(String[] args) {

        // Collection is a framework of interfaces and classes providing built-in data structures
        // that allow us to store, modify, and manipulate data elements.

        // List is an interface in Collection framework that allows duplicate elements.

        // ArrayList is a class implementing List interface.
        // It stores data in an ordered way, default initial capacity is 10, and allows index-based access and duplicate elements.


        ArrayList<Integer> num=new ArrayList<>();   //Default size is 10

         num.add(29);
         num.add(203);
         num.add(879);
         num.add(823);
         num.add(739);

        System.out.println(num);

        ArrayList<Integer>num2=new ArrayList<>();
        num2.add(90);
        num2.add(89);
        num2.add(798);
        
         num.addAll(num2);
        System.out.println(num);
        System.out.println(num.size());
        System.out.println(num.contains(739));
        System.out.println(num.get(4));


    }
}
