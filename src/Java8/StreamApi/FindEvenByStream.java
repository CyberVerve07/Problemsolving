package Java8.StreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class FindEvenByStream {

    static void main() {
        List<Integer> num= Arrays.asList(11,22,33,44,55,66,77,88,99,100);
//         num.stream().filter(n->(n%2==0)).forEach(a-> System.out.println(a));

       List<Integer> solution =  num.stream().filter(i->(i&1)==0).collect(Collectors.toList());
        System.out.println(solution);
    }
}
