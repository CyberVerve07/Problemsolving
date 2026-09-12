package Java8.StreamApi;

public class AvgSallary {
    //We  have alist of employye find the avg sallary  of Employee based on the deartment

     String employeeName;
     String department;
     double salary;

      //creata Constructor of it


    public AvgSallary(String employeeName, String department, double salary) {
        this.employeeName = employeeName;
        this.department = department;
        this.salary = salary;
    }

    //Generate the getters methodss


    public String getEmployeeName() {
        return employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}
