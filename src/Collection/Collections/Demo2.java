package Collection.Collections;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Demo2 {
    public static void main(String[] args) {
        // Fail-Safe list
        CopyOnWriteArrayList<String> product = new CopyOnWriteArrayList<>();
        product.add("Shirt");
        product.add("Pents"); // Note: Consider spelling this "Pants"
        product.add("Phone");
        product.add("Key");
        product.add("Chew gum");

        // Iterator traversal
        Iterator<String> itr = product.iterator();
        while (itr.hasNext()) {

            String element = itr.next();
            System.out.println("Current element: " + element);

            if (element.equalsIgnoreCase("Key")) {
                System.out.println("Removing element: " + element);

                product.remove(3);
                System.out.println(product);
            }
        }

        System.out.println("Final list: " + product);
    }
}
//diffrence b/w itr.remove vs list.remove
//utility,sortimg,fail fast,fail safe,iterator vs list iterator, mod count, Hahmap vs concreant hashmap, synchorized vs unsyn map