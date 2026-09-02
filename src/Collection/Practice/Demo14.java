package Collection.Practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Demo14  {
    static void main() {

        CopyOnWriteArrayList<String> product = new CopyOnWriteArrayList<>();

        product.add("I phone");
        product.add("Samsung:");
        product.add("Lg");
        product.add("Realm");
        product.add("Xiaomi");
        product.add("Motorola");

        System.out.println(product);


        for (String irt:product){
            product.add("God raj");
            System.out.println(product);
        }

        

    }



}
