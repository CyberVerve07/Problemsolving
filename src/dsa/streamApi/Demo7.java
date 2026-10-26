package dsa.streamApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Demo7 {
    //We have a list of the string and we need to find the longest string
    public static void main(String[] args) {

        List<String>list= Arrays.asList("Radhe","Krishna","RadheKrishna","RadheKrishna");


        Optional<String> result = list.stream()
                .max(Comparator.comparing(ele -> ele.length()));
        if (result.isPresent())
        System.out.println(result);
else {
            System.out.println("Result is not present:");
        }
    }
}
