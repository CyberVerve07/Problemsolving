package Java8.StreamsInterview;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return name + " ($" + salary + ")";
    }
}

public class P1_TopEarnersPerDepartment {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("Alice", "IT", 90000),
            new Employee("Bob", "IT", 120000),
            new Employee("Charlie", "IT", 110000),
            new Employee("David", "HR", 60000),
            new Employee("Eva", "HR", 75000),
            new Employee("Frank", "HR", 70000)
        );

        int topN = 2;

        Map<String, List<Employee>> topEarnersByDept = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.collectingAndThen(
                    Collectors.toList(),
                    list -> list.stream()
                                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                .limit(topN)
                                .collect(Collectors.toList())
                )
            ));

        System.out.println("=== Top " + topN + " Earners Per Department ===");
        topEarnersByDept.forEach((dept, emps) -> 
            System.out.println(dept + ": " + emps)
        );
    }
}
