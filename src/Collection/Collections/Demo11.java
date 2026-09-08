package Collection.Collections;

import java.util.HashMap;
import java.util.Map;

public class Demo11 {

    static void main() {

        int[] arr = {1, 2, 2, 3, 1, 4, 2, 3};

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}

//Count the frequeny of the number  of giv en array
