package Collection.list;

public class Employee2 {
    //Create a list of employees with Employee ID, Name, Department, and Salary,
    // and find the second-highest salary in each department using the Stream API.

    private String employeeId;
    private String name;
    private String department;
    private double salary;
    //Cereate an Constructor of it

      public Employee2(String employeeId,String name,String department,double salary){
          this.employeeId=employeeId;
          this.name=name;
          this.department=department;
          this.salary=salary;
      }

      //Create an getter method


    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    //Create an toString method to print the object in a readable format

    @Override
    public String toString() {
        return "Employee2{" +
                "employeeId='" + employeeId + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
