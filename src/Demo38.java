import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo38 {
    public static void main(String[] args) {

        //Find all even numbers and return their squares as a List<Integer>.
        //
        //Expected:


        List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,7,8,9,10);


        List<Integer> result = numbers.stream()
                .filter(num -> num % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println(result);

    }
}
