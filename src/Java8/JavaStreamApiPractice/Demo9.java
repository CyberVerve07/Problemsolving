package Java8.JavaStreamApiPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Demo9 {

    // Find the highest paid employee in each department

    public static void main(String[] args) {

        List<Employe3> employe3s = new ArrayList<>(Arrays.asList(

                new Employe3("Aditya", "IT", 90000),
                new Employe3("Rohan", "IT", 120000),
                new Employe3("Prachi", "HR", 95000),
                new Employe3("Kritika", "HR", 88000),
                new Employe3("Harsh", "Finance", 150000),
                new Employe3("Kartik", "Finance", 100000),
                new Employe3("Siya", "Sales", 75000),
                new Employe3("Pooja", "Sales", 85000),
                new Employe3("Rahul", "IT", 110000),
                new Employe3("Neha", "HR", 105000),
                new Employe3("Vikas", "Finance", 130000),
                new Employe3("Anjali", "Sales", 70000)

        ));

        // Find the highest paid employee in each department

        Map<String, Optional<Employe3>> result = employe3s.stream()
                .collect(Collectors.groupingBy(
                        Employe3::getDepartment,
                        Collectors.maxBy(
                                Comparator.comparingDouble(Employe3::getSalary)
                        )
                ));

        result.forEach((department, employee) ->
                System.out.println(department + " -> " + employee.orElse(null))
        );
    }
}