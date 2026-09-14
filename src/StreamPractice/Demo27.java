package StreamPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo27 {
    public static void main(String[] args) {

        List<Transaction>transactions=new ArrayList<>(Arrays.asList(
                new Transaction("Food",200),
                new Transaction("Shopping",800),
                new Transaction("Food",400),
                new Transaction("Shopping",400),
                new Transaction("Travell",700),
                new Transaction("Shopping",900),
                new Transaction("Phone bills",900),
                new Transaction("Room Rent",7500),
                new Transaction("Food",800)

        ));

        Map<String, Double> result = transactions.stream()
                .collect(Collectors.groupingBy(trx -> trx.getIteam(),
                        Collectors.summingDouble(Transaction::getPrice)));
        System.out.println(result);


    }
}
