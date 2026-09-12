package Java8.StreamApi;

public class Employee {
    //We have a list, and we need to find the first person whose highest salary is 50k

    String employeeName;
    double salary;

    //Generate the Constructor


    public Employee(String employeeName, double salary) {
        this.employeeName = employeeName;
        this.salary = salary;
    }


    //Override the to string


    @Override
    public String toString() {
        return "Employee{name='" + employeeName + "', salary=" + salary + "}";
    }
}