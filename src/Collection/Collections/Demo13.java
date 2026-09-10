package Collection.Collections;

import java.util.LinkedHashSet;
import java.util.Set;

public class Demo13 {
    static void main() {

        String str = "programming";

        Set<Character> set = new LinkedHashSet<>();

        for (char ch : str.toCharArray()) {
            set.add(ch);
        }

        System.out.println(set);
    }
}
