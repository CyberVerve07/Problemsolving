package Collection.Set.TreeSet;

import java.util.TreeSet;

public class Drive2 {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();

        set.add(50);
        set.add(10);
        set.add(30);
        set.add(20);
        set.add(10);

        System.out.println(set);
        //In Tree Set to determine the uniqueness equals method is not sufficent we here we use the Comparable
    }
}
