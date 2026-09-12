package Java8.StreamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Demo25 {

    public static void main(String[] args) {

        // Given a list of employees,
        // sort employees by name and then by salary

        List<Employee> employee = new ArrayList<>(Arrays.asList(
                new Employee("Rohan", 90000),
                new Employee("Rohit", 90000),
                new Employee("Suraj", 80000),
                new Employee("Suraj", 9000),
                new Employee("Puppy", 80000),
                new Employee("Siya", 82000),
                new Employee("Ritesh", 720000),
                new Employee("Aditya", 90000)
        ));

        employee.stream()
                .sorted(Comparator.comparing((Employee e) -> e.employeeName).thenComparingDouble(e -> e.salary))
                .forEach(System.out::println);
    }
}