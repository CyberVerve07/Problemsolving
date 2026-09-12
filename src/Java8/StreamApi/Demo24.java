package Java8.StreamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo24 {
    public static void main(String[] args) {

        // so from a list of employee find the top 2 highest paid employye

        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee("Aditya", 12000),
                new Employee("Kartik", 90000),
                new Employee("Suraj", 80000),
                new Employee("Harsh", 50000),
                new Employee("Harshit", 100000)
        ));

        List<Employee> result = employees.stream()
                .sorted(Comparator.comparingDouble(e ->-1* e.salary))
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(result);
    }

}
