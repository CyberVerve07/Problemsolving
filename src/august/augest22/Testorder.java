package august.augest22;

import java.util.TreeSet;

public class Testorder {
    public static void main(String[] args) {

        TreeSet<Product> set = new TreeSet<>();

        set.add(new Product(500));
        set.add(new Product(300));
        set.add(new Product(500));
        System.out.println(set);
    }
}