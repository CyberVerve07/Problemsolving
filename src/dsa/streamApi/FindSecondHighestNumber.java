package dsa.streamApi;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Demo6 {
    //Find the Second-highest number of the list

    public static void main(String[] args) {

        List<Integer>list= Arrays.asList(10,84,90,30,24,4,304,50,98);

        Stream<Integer> limit = list.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .skip(1)
                .limit(1);
        System.out.println(limit);


    }
}
