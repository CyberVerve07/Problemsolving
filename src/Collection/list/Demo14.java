package Collection.list;

import java.util.ArrayList;

public class Demo14 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);          // add
        list.add(1, 20);       // specific index
        list.get(0);           // retrieve
        list.set(0, 50);       // update
      //  list.remove(0);        // remove by index
        list.contains(50);     // search
        list.size();           // size
     //   list.clear();          // remove all
     //   list.isEmpty();        // check empty
        System.out.println(list);

    }
}
