package Collection.Practice.Task1;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Employee> employees = new TreeSet<>();

        // 1. Normal Employee
        employees.add(new Employee("Amit", "EMP001", 50000.0));
        // 2. Normal Employee (Higher Salary)
        employees.add(new Employee("Rahul", "EMP005", 80000.0));
        // 3. Normal Employee (Lower Salary)
        employees.add(new Employee("Priya", "EMP003", 40000.0));

        // 4 & 5: Two employees with the SAME salary but DIFFERENT IDs
        employees.add(new Employee("Vikas", "EMP004", 60000.0));
        employees.add(new Employee("Neha", "EMP002", 60000.0)); // EMP002 EMP004 se pehle aayega

        // 6. Duplicate Employee (SAME salary AND SAME id as Amit)
        // TreeSet isko automatically reject kar dega kyunki compareTo() 0 return karega.
        employees.add(new Employee("Duplicate Amit", "EMP001", 50000.0));

        // Printing the final sorted employees
        System.out.println("Final Sorted Employees in TreeSet:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}