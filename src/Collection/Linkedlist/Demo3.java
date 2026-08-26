package Collection.Linkedlist;
import java.util.LinkedList;

public class Demo3 {

    public static void main(String[] args) {
        LinkedList<Integer> list=new LinkedList<>();
          list.add(90);
          list.add(78);
          list.add(90);
          list.add(93);
          list.add(83);
        System.out.println(list);
        System.out.println(list.contains(4));
        list.remove(1);
        System.out.println(list.getFirst());
        System.out.println(list);

    }
}
