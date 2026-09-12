package Java8.StreamApi;

import java.util.Arrays;
import java.util.List;

public class Demo20 {

    public static void main(String[] args) {

        List<String>city= Arrays.asList("CHE","BLR","DEL","HP","RAJ","AMD","PUJ");

         city.stream().filter(c->c.startsWith("H")).limit(1)
                 .forEach(System.out::println);

    }

}
