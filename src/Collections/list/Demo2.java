package Collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo2 {
    public static void main(String[] args) {
        // List 1 initialization
        List<String> list = new ArrayList<>();
        list.add("Aditya");
        list.add("Harsh");
        list.add("Shivanshu");
        list.add("Shubham");
        list.add("Dineash");
        System.out.println("Initial List: " + list);

        // List 2 initialization & bulk operations
        List<String> list2 = new ArrayList<>();
        list2.add("Sneha");
        list2.add("Ram");
        list2.add("Anup");

        list.addAll(list2);
        System.out.println("After addAll: " + list);
        System.out.println("Size after addAll: " + list.size());

        list.removeAll(list2);
        System.out.println("After removeAll: " + list);
        System.out.println("Printing list2: " + list2);

        list2.clear();
        System.out.println("List2 size after clear: " + list2.size());

        // Iterator traversal
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println("Element is: " + iterator.next());
        }
    }
}
