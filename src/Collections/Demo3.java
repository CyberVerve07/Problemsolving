package Collections;

import java.util.ArrayList;
import java.util.List;

public class Demo3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Hello");          // Index 0
        list.add("World");          // Index 1
        list.add("Java");  // Index 2

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

        // Corrected: Replacing index 2 element
        list.set(2,"Language");
        System.out.println(list); // [Hello, World, Language]
        list.toArray();
    }

}