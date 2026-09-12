package Java8.StreamApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo28 {
    public static void main(String[] args) {

        List<Transcation>list=new ArrayList<>(Arrays.asList(
                new Transcation("HomeExpensive",200000),
                new Transcation("Shopping",250000),
                new Transcation("Shopping",150000),
                new Transcation("Shopping",85000),
                new Transcation("HomeExpensive",50000),
                new Transcation("HomeExpensive",30000),
                new Transcation("HomeExpensive",30000)
        ));

        Map<String, Double> collect = list.stream()
                .collect(Collectors.groupingBy(transcation -> transcation.getIteam(),
                Collectors.summingDouble(trx -> trx.transaction)));//After summing the int 

        System.out.println(collect);


    }
}
