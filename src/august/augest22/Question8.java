package august.augest22;

import java.util.ArrayList;
import java.util.List;

public class Question8 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("A");
        list.remove("A");

        System.out.println(list);
    }
}
