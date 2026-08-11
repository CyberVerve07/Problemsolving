package Collections;

import java.util.ArrayList;

public class Demo13 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();  // default capacity: 10
        list.add("Java");        // adds at end — O(1) amortized
        list.add("Spring");
        list.add(0, "Maven");    // insert at index — O(n)
        list.remove("Spring");   // remove by value — O(n)
        list.get(1);             // get by index — O(1)
        System.out.println(list.size()); // 2


    }
}
