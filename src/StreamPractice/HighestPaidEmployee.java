package StreamPractice;

public class HighestPaidEmployee {
    //Highest Paid Employee in Each Department 🔥

       String employeeName;
       String employeeDepartment;
       double salary;

         //generate an Constructor


    public HighestPaidEmployee(String employeeName, String employeeDepartment, double salary) {
        this.employeeName = employeeName;
        this.employeeDepartment = employeeDepartment;
        this.salary = salary;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "HighestPaidEmployee{" +
                "name='" + employeeName + '\'' +
                ", department='" + employeeDepartment + '\'' +
                ", salary=" + salary +
                '}';
    }
}
