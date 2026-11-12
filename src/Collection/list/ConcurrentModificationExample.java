package Collection.list;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentModificationExample {

    public static void main(String[] args) {

        List<Integer>list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

          //While iteration the Concurrent modification error id thrown due to fail fast

        for (Integer integer : list) {
            System.out.println(integer);
            list.add(4); // This will throw ConcurrentModificationException
        }
    }
}
