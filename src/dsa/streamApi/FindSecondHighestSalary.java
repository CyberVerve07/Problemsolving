package dsa.streamApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class Employee {
    private final String employeeName;
    private final double salary;
    private final String department;

    public Employee(String employeeName, double salary, String department) {
        this.employeeName = employeeName;
        this.salary = salary;
        this.department = department;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}

public class FindSecondHighestSalary {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Aditya", 1000, "IT"),
                new Employee("Ashish", 2000, "IT"),
                new Employee("Prachi", 3000, "HR"),
                new Employee("Kartik", 40000, "Manager"),
                new Employee("Vikram", 40000, "Manager") // Added duplicate top salary to prove edge-case handling
        );

        // Approach 1: Get the exact second-highest salary value (Handles duplicates accurately)
        Optional<Double> secondHighestSalary = employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();

        secondHighestSalary.ifPresentOrElse(salary -> System.out.println("Second Highest Salary: " + salary),
                () -> System.out.println("Not enough distinct salaries.")
        );

        // Approach 2: Get the Employee object with the second-highest salary (Assuming unique salaries)
        Optional<Employee> secondHighestEmployee = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1)
                .findFirst();

        secondHighestEmployee.ifPresent(emp -> System.out.println("Employee Details: " + emp));
    }
}