package august.augest22;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Question6 {
    public static void main(String[] args) {
        List<String> iteams = new ArrayList<String>();
        iteams.add("Apple");
        iteams.add("Banana");
        iteams.add("Grapes");
        iteams.add("Orange");
        iteams.add("Guava");

        //Traverse the list by using the iterator

        Iterator<String> itr = iteams.iterator();

        while (itr.hasNext()) {

            String fruit = itr.next();
            System.out.println(fruit);

        }
    }
}