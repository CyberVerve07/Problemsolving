package Collection.list;

import java.util.ArrayList;
import java.util.List;

public class Demo16 {
    public static void main(String[] args) {
        List<String> names=new ArrayList<>();
        names.add("Aditya");
        names.add("Aman");
        names.add("Pawan");
        names.add("Kartik");
        names.add("Shyam");

         for (String name:names){
             System.out.println(name);
             names.remove("Aditya"); // This will throw ConcurrentModificationException
             System.out.println(name);
         }
//So this is mainly accured while the iterating of the list and trying to modify the list at the same time. So to avoid this we can use CopyOnWriteArrayList which is
// fail safe and will not throw ConcurrentModificationException
    }
}
