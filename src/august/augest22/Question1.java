package august.augest22;

import august.augest8.ShallowTest;

import java.util.ArrayList;

public class Question1 {
    //Write a Java program using ArrayList<Integer> to:
    //
    //Add 10, 20, 30, 40, 50
    //Print the list
    //Print the element at index 2
    //Print the first and last element
    public static void main(String[] args) {

        ArrayList<Integer> num =new ArrayList<>();
        num.add(10);
        num.add(20);
        num.add(30);
        num.add(40);
        num.add(50);

        System.out.println(num);
        System.out.println(num.get(2));
        System.out.println(num.getFirst());
        System.out.println(num.getLast());



    }
}
