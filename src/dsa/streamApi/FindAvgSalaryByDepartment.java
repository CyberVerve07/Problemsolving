package dsa.streamApi;

public class FindAvgSalaryByDepartment {
    private String employee;
    private double salary;
    private String department;
    //Create a Constructor of it


    public FindAvgSalaryByDepartment(String employee, double salary, String department) {
        this.employee = employee;
        this.salary = salary;
        this.department = department;
    }


    //Create the getters methods


    public String getEmployee() {
        return employee;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }
}
