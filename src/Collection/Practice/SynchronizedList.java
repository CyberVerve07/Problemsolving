package Collection.Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedList {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

         List<String >synchronizedList= Collections.synchronizedList(list);

           synchronizedList.add("Java");
           synchronizedList.add("spring");
           synchronizedList.add("Boot");

            //Display the synchronized list
        System.out.println("Synchronized list:"+synchronizedList);  //Display the Synchronized list;

          synchronized (synchronizedList){// //Iterating over the Synchrnoized list

          for (String item:synchronizedList){
              System.out.println("list item "+item);
          }




    }
}}