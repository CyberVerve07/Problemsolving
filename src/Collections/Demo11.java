package Collections;

import java.util.ArrayList;

public class Demo11 {
    //Problem 1 — Basic Add & Print
    //
    //Create an ArrayList<Integer> and store 10 integers in it.
    //
    //Requirements:
    //
    //Add 10 numbers.
    //Print the complete list.
    //Print the size of the list.
    //Print the first and last element.
    //
    //Focus: add(), size(), get().
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();

         list.add(20);
        list.add(30);
        list.add(40);
        list.add(39);
        list.add(49);
        list.add(38);
        list.add(39);
        list.add(240);
        list.add(23);
        list.add(220);
        list.add(240);


        System.out.println(list);
        System.out.println(list.size());
        System.out.println("First element: " + list.get(0));
        System.out.println("Last element: " + list.get(list.size() - 1));


    }
}
