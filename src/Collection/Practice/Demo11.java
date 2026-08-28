package Collection.Practice;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Demo11 {
    public static void main(String[] args) {

        Map<String, Integer> product = new ConcurrentHashMap<>();


         product.put("I phone",85000);
         product.put("Washing machine",30000);
         product.put("Lg AC:",50000);
         product.put("Royal infield",250000);
         product.put("MackBook",150000);


        System.out.println(product);




    }
}