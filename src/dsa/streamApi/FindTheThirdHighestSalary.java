package dsa.streamApi;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindTheThirdHighestSalary {
    private String employeeName;
    private String employeeDepartment;
    private double employeeSalary;

    public FindTheThirdHighestSalary(String employeeName, String employeeDepartment, double employeeSalary) {
        this.employeeName = employeeName;
        this.employeeDepartment = employeeDepartment;
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + employeeName + '\'' +
                ", department='" + employeeDepartment + '\'' +
                ", salary=" + employeeSalary +
                '}';
    }

    public static void main(String[] args) {
        // Find the 3rd Highest salary of the Employees
        List<FindTheThirdHighestSalary> employees = new ArrayList<>(Arrays.asList(
                new FindTheThirdHighestSalary("Aditya", "IT", 89000.0),
                new FindTheThirdHighestSalary("Kartik", "Finance", 120000.0),
                new FindTheThirdHighestSalary("Vikram", "IT", 120000.0), // Tied highest
                new FindTheThirdHighestSalary("Ashish", "Engineering", 95000.0),
                new FindTheThirdHighestSalary("Prachi", "HR", 72000.0),
                new FindTheThirdHighestSalary("Neha", "Marketing", 60000.0),
                new FindTheThirdHighestSalary("Rohan", "Operations", 45000.0)
        ));

        // TODO: Stream logic

        Optional<FindTheThirdHighestSalary> result = employees.stream()
                .sorted(Comparator.comparingDouble(emp -> -1 * emp.getEmployeeSalary()))
                .distinct()
                .skip(2)
                .findFirst();
        System.out.println("The 3rd highest paid employee is "+result)
        ;
    }
}