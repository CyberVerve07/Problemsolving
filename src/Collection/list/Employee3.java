package Collection.list;

public class Employee3 {
    private String employeeName;
    private String employeeDepartment;
    private double employeeSalary;
    //Create an Constructor of it

     public Employee3(String employeeName,String employeeDepartment,double employeeSalary) {
        this.employeeName = employeeName;
        this.employeeDepartment = employeeDepartment;
        this.employeeSalary = employeeSalary;
    }
    //Create an Getter methods

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    //Create the to String method to print the object in a readable format

    @Override
    public String toString() {
        return "Employee3{" + "employeeName='" + employeeName + '\'' + ", employeeDepartment='" + employeeDepartment + '\'' + ", employeeSalary=" + employeeSalary +
                '}';
    }
}

