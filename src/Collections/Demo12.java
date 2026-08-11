package Collections;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Demo12 {
    public static void main(String[] args) {

        //Collection is a set of interfaces and classes that provide the in build ds and allow us to store modify and
        // manipulate the data elements :

         //list is an interface in Collection list is used to it allow to use the duplicate elements

         //array list is an class
        //Ordered way data store/default size is 10 and // index based acess and duplicacy acess is alllowed


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
