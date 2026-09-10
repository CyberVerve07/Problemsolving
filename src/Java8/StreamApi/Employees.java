package Java8.StreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Employee {
    String employeeName;
    double employeeSalary;

    public Employee(String employeeName, double employeeSalary) {
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
    }
}

//	Given a list of employees, use filter() to find employees with salary greater than 10 LPA and map()
//	to get only their names.
public class Employees {
    static void main() {

        List<Employee> employees = Arrays.asList(
                new Employee("Aditya", 30000),
                new Employee("Prachi", 1200000),
                new Employee("Harsh", 15000),
                new Employee("Rahul", 800000),
                new Employee("Anu", 200000)
        );

        // Yahan stream lagana hai



        employees.stream().filter(e->e.employeeSalary>1000000).map(p->p.employeeName)
                .forEach(System.out::println);



    }
}