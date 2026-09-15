package Java8.StreamApi;

public class EmployeeSecondHighestSalary {

    private  String employeName;
    private String employeeDepartment;
    private double salary;

    public EmployeeSecondHighestSalary(String employeName, String employeeDepartment, double salary) {
        this.employeName = employeName;
        this.employeeDepartment = employeeDepartment;
        this.salary = salary;
    }
    //Generate the Getters ::::::



    public String getEmployeName() {
        return employeName;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public double getSalary() {
        return salary;
    }
}
