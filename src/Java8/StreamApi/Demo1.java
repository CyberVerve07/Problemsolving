package Java8.StreamApi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo1 {
 public static void main() {

     List<String> products=new ArrayList<>();


        products.add("Apple");
        products.add("LG");
        products.add("God raj");
        products.add("Samsung");

          //We can add for process


      //using iterator

     Iterator<String>iterator= products.iterator();
      while (iterator.hasNext())
      {
          String product=(String) iterator.next();
          System.out.println(product);
          if (product.startsWith("s")){
              System.out.println("product is :"+product);
              System.out.println();
          }

      }



    }
}
