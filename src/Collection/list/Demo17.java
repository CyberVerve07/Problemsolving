package Collection.list;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Demo17 extends CopyOnWriteArrayList {
    public static void main(String[] args) {

        List<Integer>list=new CopyOnWriteArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        //So while iterating the list and trying to modify the l
        // ist at the same time it will not throw ConcurrentModificationException as it is fail safe


        for (Integer integer : list) {
            System.out.println(integer);
            list.add(4); // This will not throw ConcurrentModificationException
        }
    }

}
