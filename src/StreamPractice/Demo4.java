package StreamPractice;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Demo4 {

    public static void main(String[] args) {

        List<HighestPaidEmployee> employees = new ArrayList<>(Arrays.asList(

                new HighestPaidEmployee("Aditya", "IT", 90000),
                new HighestPaidEmployee("Rohan", "IT", 82000),
                new HighestPaidEmployee("Rachid", "HR", 95000),
                new HighestPaidEmployee("Kartik", "HR", 88000),
                new HighestPaidEmployee("Harsh", "Finance", 120000),
                new HighestPaidEmployee("Kartik", "Finance", 100000),
                new HighestPaidEmployee("Siya", "Sales", 75000)

        ));

        // Find highest paid employee in each department

        Map<String, Optional<HighestPaidEmployee>> result = employees.stream().collect(Collectors.groupingBy(emp -> emp.employeeDepartment,
                Collectors.maxBy(Comparator.comparingDouble(HighestPaidEmployee::getSalary))));


        result.forEach((department, employee) ->
                System.out.println(department + " -> " + employee.get())
        );
    }
}