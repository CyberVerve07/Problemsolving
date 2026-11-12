package Collection.list;

import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafe extends CopyOnWriteArrayList {


    public static void main(String[] args) {

        CopyOnWriteArrayList<Object> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        for(Object obj:list){list.add(4); //) This will not throw ConcurrentModificationException{
            System.out.println(obj);
            list.add(4); // This will not throw ConcurrentModificationExceptionlist.add(4); // This will not throw ConcurrentModificationException
         //   System.out.println(list);
        }


    }

    }

