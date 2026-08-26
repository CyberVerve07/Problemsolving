package Collection.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        List<String> cities=new ArrayList<>();

          cities.add("Bangalore");
          cities.add("Delhi");
          cities.add("Mumbai");
          cities.add("Punjab");
          cities.add("Himachal");
          cities.add("Rajasthan");
          cities.add("Gujarat");
          cities.add("Kolkata");
          Iterator<String> itr= cities.iterator();
          while (itr.hasNext()){
              String element=(String) itr.next();
              System.out.println(element);
              cities.add("Bihar");
          }
        Collections.sort(cities);
        System.out.println(cities);
        //Sorting
        Collections.reverse(cities);
        System.out.println(cities);
        //Revers
        //=======================
        //

//          //Concreatehashmap
//        List<String> unlist=Collections.unmodifiableList(cities);
//        //Try to modify
//         unlist.add("Hyderabad");
//        System.out.println(cities);


//      Collections.synchronizedCollection(cities);
//        System.out.println(cities);

        //Collection is the Root interface and Collections are the utility classes in which static methods are contains
        //like sort,rev,unlist:

        //cannot modify the collection while iteration



    }
}
//Fail fast vs fail save
//Fail fast-> if you try to modify  the collection while reading or  iteration ::
//Fail safe-> no exception is throw while iteration : copyonwritearraylist,ConcurrentHashMap

//Modcount:


//Fail fast means iterator detects the unexpected modification structor