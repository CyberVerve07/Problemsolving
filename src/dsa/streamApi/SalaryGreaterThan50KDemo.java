package dsa.streamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Employee1 {
    private final String employeeName;
    private final double salary;
    private final String employeeDepartment;

    public Employee1(String employeeName, double salary, String employeeDepartment) {
        this.employeeName = employeeName;
        this.salary = salary;
        this.employeeDepartment = employeeDepartment;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + employeeName + '\'' +
                ", salary=" + salary +
                ", department='" + employeeDepartment + '\'' +
                '}';
    }
}

public class SalaryGreaterThan50KDemo {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee("Aditya", 45000.0, "IT"),
                new Employee("Ashish", 52000.0, "IT"),
                new Employee("Prachi", 68000.0, "HR"),
                new Employee("Kartik", 50000.0, "Operations"), // Boundary test
                new Employee("Vikram", 85000.0, "Finance"),
                new Employee("Rohit", 32000.0, "Support")
        ));

        // TODO: Write your Stream operation here
        //From a list of employe find the first employee whose salary is greater than 50k

         employees.stream()
                 .filter(emp->emp.getSalary()>50000)
                 .findFirst().ifPresent(System.out::println);


    }
}