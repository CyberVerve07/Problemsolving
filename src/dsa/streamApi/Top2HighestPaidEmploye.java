package dsa.streamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Top2HighestPaidEmploye {
    private String employeeName;
    private String employeeDepartment;
    private double salary;

    public Top2HighestPaidEmploye(String employeeName, String employeeDepartment, double salary) {
        this.employeeName = employeeName;
        this.employeeDepartment = employeeDepartment;
        this.salary = salary;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + employeeName + '\'' +
                ", department='" + employeeDepartment + '\'' +
                ", salary=" + salary +
                '}';
    }

    public static void main(String[] args) {
        List<Top2HighestPaidEmploye> employees = new ArrayList<>(Arrays.asList(
                new Top2HighestPaidEmploye("Aditya", "IT", 65000.0),
                new Top2HighestPaidEmploye("Ashish", "IT", 95000.0),
                new Top2HighestPaidEmploye("Prachi", "HR", 72000.0),
                new Top2HighestPaidEmploye("Kartik", "Finance", 120000.0),
                new Top2HighestPaidEmploye("Vikram", "Engineering", 150000.0), // Tie check
                new Top2HighestPaidEmploye("Neha", "Marketing", 48000.0),
                new Top2HighestPaidEmploye("Rohan", "Engineering", 88000.0)
        ));

        // TODO: Write your Stream API code below to extract the top 2 highest paid employees
employees.stream()
        .distinct()
        .sorted(Comparator.comparingDouble(emp->-1* emp.getSalary()))  //When we  reverse the order we need to multiply with the minus 1
        .limit(2)
        .forEach(System.out::println);

    }
}