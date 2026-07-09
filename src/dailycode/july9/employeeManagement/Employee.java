package dailycode.july9.employeeManagement;

public class Employee {
    // Question 2: Employee Management
    //
    // Parent Class:
    // Employee
    //
    // Private Variables:
    // - id
    // - name
    // - salary
    //
    // Methods:
    // - getters/setters
    // - displayDetails()
    //
    // Child Class:
    // Developer
    //
    // Private Variable:
    // - programmingLanguage
    //
    // Method:
    // - writeCode()
    //
    // Condition:
    // - Salary cannot be negative.
    // - ID should be initialized using constructor only.

    private int id;
    private String name;
    private double salary;

    public Employee(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Salary cannot be negative.");
        }
    }

    public void displayDetails() {
        System.out.println("Employee ID: " + this.id);
        System.out.println("Employee Name: " + this.name);
        System.out.println("Employee Salary: " + this.salary);
    }
}
