package august.augest22;

import java.util.TreeSet;

public class Question7 {
    public static void main(String[] args) {

        TreeSet<Integer> set = new TreeSet<>();

        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);

        System.out.println(set.lower(30));  //lower method  20 because 30 is lower than 20
        System.out.println(set.floor(30));  //floor method : return the greatest element in the set
    }
}
