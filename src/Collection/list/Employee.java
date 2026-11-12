package Collection.list;

import java.util.List;

public class Employee {

    private  String name;
    private double salary;
    private String department;
    //Create an Constructor of it


    public Employee(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    //Create an getter methods


    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    //Adding the toString method to print the object in a readable format


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}

