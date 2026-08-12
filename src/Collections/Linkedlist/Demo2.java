package Collections.Linkedlist;

import java.util.LinkedList;

public class Demo2 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Aditya");
        list.add("Aditya");
        list.add("Shivanshu");
        list.add("Prashant");
        list.add("Golu brother");


        System.out.println(list.size());
            list.set(3,"Prashant");
        System.out.println(list);  //0 (n)

        list.addLast("Prachi");
        System.out.println(list);   // 0(n)
         list.addFirst("Ashish");
        System.out.println(list);  //O (n)

         list.remove(3);
        System.out.println(list);  //O (n)
         list.removeFirst();
        System.out.println(list);  //O (n)





    }
}
