package Java8.StreamDSA;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergetwoList {
    static void main() {
        List<Integer>list1= Arrays.asList(1,2,3,4);
        List<Integer>list2=Arrays.asList(5,6,7,8,9);

          List<Integer>merdge= Stream.concat(list1.stream(),list2.stream().distinct()).collect(Collectors.toList());
        System.out.println(merdge);
    }
}
