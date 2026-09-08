package Collection.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Demo10 {
    static void main() {

        //Code for Remove the duplicate element in List

        List<Integer>list= Arrays.asList(200,400,200,400,500,900,700,900,700);
        System.out.println(list);


        //USe the hashset for removing the duplia=cate elements

          HashSet<Integer> remove =new HashSet<>(list);

        System.out.println(remove);
    }
}
