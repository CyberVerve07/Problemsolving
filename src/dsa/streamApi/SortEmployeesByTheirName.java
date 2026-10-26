package dsa.streamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortEmployeesByTheirName {

    private String employeeName;
    private double employeeSalary;
    private String employeeDepartment;
    private long employeePhoneNo; // Phone numbers exceed 32-bit signed int max (2,147,483,647)

    public SortEmployeesByTheirName(String employeeName, double employeeSalary, String employeeDepartment, long employeePhoneNo) {
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeDepartment = employeeDepartment;
        this.employeePhoneNo = employeePhoneNo;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public long getEmployeePhoneNo() {
        return employeePhoneNo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + employeeName + '\'' +
                ", salary=" + employeeSalary +
                ", department='" + employeeDepartment + '\'' +
                ", phone=" + employeePhoneNo +
                '}';
    }

    public static void main(String[] args) {
        List<SortEmployeesByTheirName> employees = new ArrayList<>(Arrays.asList(
                new SortEmployeesByTheirName("Aditya", 75000.0, "IT", 9876543210L),
                new SortEmployeesByTheirName("Kartik", 90000.0, "Finance", 9876543211L),
                new SortEmployeesByTheirName("Ashish", 60000.0, "IT", 9876543212L),
                new SortEmployeesByTheirName("Aditya", 85000.0, "Operations", 9876543213L), // Duplicate name to test secondary sort
                new SortEmployeesByTheirName("Prachi", 95000.0, "HR", 9876543214L),
                new SortEmployeesByTheirName("Ashish", 72000.0, "Engineering", 9876543215L) // Duplicate name to test secondary sort
        ));

        // Sort by Name (Ascending), then by Salary (Descending) for identical names
        List<SortEmployeesByTheirName> sortedEmployees = employees.stream()
                .sorted(Comparator.comparing(SortEmployeesByTheirName::getEmployeeName)
                        .thenComparingDouble(SortEmployeesByTheirName::getEmployeeSalary).reversed())
                .collect(Collectors.toList());

        sortedEmployees.forEach(System.out::println);
    }
}