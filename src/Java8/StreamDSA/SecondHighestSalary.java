package Java8.StreamDSA;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SecondHighestSalary {
    static void main() {

        List<Integer>nums= Arrays.asList(30,50,50,20,20,40,20,400,290,290,939,4900,2903,920);
        Optional<Integer>secondMax=nums.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println("Second highest sallary is "+secondMax.get());

    }
}
