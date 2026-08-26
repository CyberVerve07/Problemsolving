package Collection.Collections;

import java.util.*;

public class Demo4 {
    public static void main(String[] args) {
        List<String> product = new ArrayList<>();
        product.add("I phone");
        product.add("MacBook");
        product.add("Royal infield key");
        product.add("500 Cash");
        product.add("Chew Gum");

        System.out.println("Original: " + product);

        // Sorting the list alphabetically
        Collections.sort(product);
        System.out.println("Sorted: " + product);

        System.out.println("\n--- Traversing Forward using ListIterator ---");
        ListIterator<String> listItr = product.listIterator();

        while (listItr.hasNext()) {
            String element = listItr.next(); // No casting needed
            System.out.println(element);
        }

        System.out.println("\n--- Traversing Backward using ListIterator ---");
        // The iterator is now at the end of the list, so we can traverse backwards
        while (listItr.hasPrevious()) {
            String element = listItr.previous();
            System.out.println(element);
        }
    }
}