package Collections;

import java.util.ArrayList;
import java.util.Collections;

public class Demo6 {
    public static void main(String[] args) {
        //Arraylist various methods

        ArrayList<Integer> list = new ArrayList<>();
        list.add(30);
        list.add(39);
        list.add(20);
        list.add(3);
        list.add(52);
        list.add(7);
        list.add(50);
        //Sorting
        Collections.sort(list);
        System.out.println(list);



          //Sorting in Descending order


         Collections.sort(list.reversed());
        System.out.println(list);


    }
}
