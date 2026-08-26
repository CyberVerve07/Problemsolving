package Collection.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Demo3 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("OS");
        list.add("Databases");
        list.add("Core java");
        list.add("Advance Java");
        list.add("Spring");
        list.add("Spring boot");
        list.add("Hibernate");
        list.add("Kafka");
        list.add("Redis");
        list.add("System Design");

Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);
          //reverse vs reverse order
//        Collections.reverse(list);
//        System.out.println(list);
//
//           //reverse order
//         Collections.sort(list);
//        System.out.println(list);
//
//          //Traversing by using the iterator
//
//        Iterator<String> itr=list.iterator();
//
//          while (itr.hasNext()){
//              String element=(String) itr.next();
//              System.out.println(element);
//
//






          }





    }

