package Collection.Collections;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Demo12 {

    static void main() {

        // Find common elements in two lists

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);


        // Store list1 elements in HashSet
        HashSet<Integer> set = new HashSet<>(list1);

        // Store common elements
        HashSet<Integer> result = new HashSet<>();

        for (Integer num : list2) {

            if (set.contains(num)) {
                result.add(num);
            }
        }

        System.out.println(result);
    }
}