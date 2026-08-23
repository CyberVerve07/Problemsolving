package august.augest22;

import java.util.ArrayList;
import java.util.List;

public class Question9 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        list.remove(Integer.valueOf(20));
        list.add(1, 50);
        list.remove(2);

        System.out.println(list);
    }
}
