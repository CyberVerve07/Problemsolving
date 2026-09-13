package StreamPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo1 {

    public static void main(String[] args) {

        List<Employee> employee = new ArrayList<>(Arrays.asList(
                new Employee("Aditya", 70000),
                new Employee("Riya", 52000),
                new Employee("Prachi", 72000),
                new Employee("Rohan", 340000),
                new Employee("Golu", 67000),
                new Employee("Kartik", 34000)
        ));

        List<String> result = employee.stream()
                .filter(emp -> emp.salary > 50000) //filter
                .map(emp -> emp.name)//map
                .collect(Collectors.toList());//collect result
        System.out.println(result);
    }
}