package Java8.StreamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Demo46 {
    public static void main(String[] args) {
//Find the  first employee whose sallary is greate the 50k
        List<FindFirst>employe=new ArrayList<>(Arrays.asList(
                new FindFirst("Aditya",50000),
                new FindFirst("Prachi",45000),
                new FindFirst("Ashish",89000),
                new FindFirst("Harsh",55000),
                new FindFirst("Kartik",72000)
        ));

        Optional<FindFirst> result = employe.stream()
                .filter(emp -> emp.salary > 50000)
                .findFirst();
        System.out.println(result);


    }
}
