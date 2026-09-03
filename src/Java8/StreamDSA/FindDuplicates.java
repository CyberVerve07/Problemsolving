package Java8.StreamDSA;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicates {
    static void main() {

        List<Integer>nums= Arrays.asList(1,2,3,4,5,6,7,1);
        Set<Integer>duplicates=nums.stream().filter(n-> Collections.frequency(nums,n)>1).collect(Collectors.toSet());
        System.out.println(duplicates);
    }
}
