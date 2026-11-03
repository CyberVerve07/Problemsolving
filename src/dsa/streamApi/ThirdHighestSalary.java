package dsa.streamApi;

public class ThirdHighestSalary {
    String employeeName;
    String employeeDepartment;
    double employeeSalary;


      //Create  aConstructor of  the fields


    public ThirdHighestSalary(String employeeName, String employeeDepartment, double employeeSalary) {
        this.employeeName = employeeName;
        this.employeeDepartment = employeeDepartment;
        this.employeeSalary = employeeSalary;
    }

    //Implement the to string method is a String representation


    @Override
    public String toString() {
        return "ThirdHighestSalary{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeDepartment='" + employeeDepartment + '\'' +
                ", employeeSalary=" + employeeSalary +
                '}';
    }
}
