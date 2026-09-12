package Java8.StreamApi;

public class DeptEmployee {

    String employeeName;
    String employeeDepartment;
    double salary;

    // Constructor
    public DeptEmployee(String employeeName, String employeeDepartment, double salary) {
        this.employeeName = employeeName;
        this.employeeDepartment = employeeDepartment;
        this.salary = salary;
    }

    // To print object properly
    @Override
    public String toString() {
        return "DeptEmployee{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeDepartment='" + employeeDepartment + '\'' +
                ", salary=" + salary +
                '}';
    }
}