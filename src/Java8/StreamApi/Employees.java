package Java8.StreamApi;//	Given a list of employees, use filter() to find employees with salary greater than 10 LPA and
//	map() to get only their names.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Employee {

    String employeeName;
    double employeeSalary;

    //Create a constructor :


    public Employee(String employeeName, double employeeSalary, List<Employee> employees) {
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employees = employees;
    }



    List<Employee> employees = Arrays.asList(
            new Employee("Aditya", 30),
            new Employee("Prachi", 9),
            new Employee("Harsh", 15),
            new Employee("Rahul", 8),
            new Employee("Anup", 20)
    );

}

