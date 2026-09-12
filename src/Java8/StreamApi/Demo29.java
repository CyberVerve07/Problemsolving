package Java8.StreamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo29 {

    public static void main(String[] args) {

        // Find the average salary of employees based on department

        List<AvgSallary> employees = new ArrayList<>(Arrays.asList(

                new AvgSallary("Aditya", "IT", 90000),
                new AvgSallary("Rohan", "IT", 80000),
                new AvgSallary("Rohit", "IT", 70000),
                new AvgSallary("Prachi", "HR", 60000),
                new AvgSallary("Siya", "HR", 50000),
                new AvgSallary("Harsh", "Finance", 100000),
                new AvgSallary("Kartik", "Finance", 120000)
        ));

        // Your Stream API implementation here

        Map<String, Double> average = employees.stream().collect(Collectors.groupingBy(e -> e.getDepartment(),
                Collectors.averagingDouble(avg -> avg.getSalary())

        ));

        System.out.println(average);
    }
}