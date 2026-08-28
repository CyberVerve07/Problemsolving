package Collection.Practice;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Demo12 {

    public static void main(String[] args) {

        Map<String, Integer> product = new ConcurrentHashMap<>();

        product.put("I Phone", 85000);
        product.put("Washing Machine", 30000);
        product.put("LG AC", 50000);
        product.put("Royal Enfield", 250000);
        product.put("MacBook", 150000);

        // Thread 1
        Thread t1 = new Thread(() -> {
            product.put("Samsung TV", 60000);
            System.out.println("Thread 1: " + product);
        });

        // Thread 2
        Thread t2 = new Thread(() -> {
            product.put("Dell Laptop", 70000);
            System.out.println("Thread 2: " + product);
        });

        // Thread 3
        Thread t3 = new Thread(() -> {
            product.remove("LG AC");
            System.out.println("Thread 3: " + product);
        });

        t1.start();
        t2.start();
        t3.start();
    }
}