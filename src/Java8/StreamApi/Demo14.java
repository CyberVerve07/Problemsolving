package Java8.StreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo14 {

    static void main() {

        // Given List<List<String>>, use flatMap()
        // to convert it into a single List<String>.

        List<List<String>> names = Arrays.asList(
                Arrays.asList("Aditya", "Rahul"),
                Arrays.asList("Prachi", "Harsh"),
                Arrays.asList("Anup", "Kanshika")
        );

        List<String> result = names.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());

        System.out.println(result);
    }
}