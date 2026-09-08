package Collection.Collections;

import java.util.*;

public class Demo9 {

    static void main() {

        // Remove duplicate elements from the list

        List<Integer> list = Arrays.asList(10, 20, 10, 30, 20, 40, 30);

        System.out.println(list);

        HashSet<Integer> remove = new HashSet<>(list);

        System.out.println(remove);
    }
}