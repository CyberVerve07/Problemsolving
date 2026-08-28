package Collection.Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo7 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        Iterator<Integer> it = list.iterator();

        while (it.hasNext()) {
            Integer value = it.next();

            if (value == 20) {
                it.remove();
            }
        }

        System.out.println(list);

    }
}
