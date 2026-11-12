package Collection.list;

public class Employeelist {
    private  String employeeName;
    private  double salary;
    private  String department;
    //Create an Constructor of it

    public Employeelist(String employeeName, double salary, String department) {
        this.employeeName = employeeName;
        this.salary = salary;
        this.department = department;
    }

    //create an Getter methods


    public String getEmployeeName() {
        return employeeName;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }
    //Create an to string method to print the object in a readable format


    @Override
    public String toString() {
        return "Employeelist{" +
                "employeeName='" + employeeName + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
