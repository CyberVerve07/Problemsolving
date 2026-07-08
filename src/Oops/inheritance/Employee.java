package oops.inheritance;

public class Employee extends Person {
    // Encapsulation
    private String employeeId;
    private double salary;

    // Child Constructor
    public Employee(String name, int age, String employeeId, double salary) {
        super(name, age);      // Parent constructor call
        this.employeeId = employeeId;
        if (salary >= 0) {
            this.salary = salary;
        } else {
            this.salary = 0;
        }
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Salary cannot be negative!");
        }
    }

    public void displayEmployee() {
        displayPerson();
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Salary : " + salary);
    }

    public static void main(String[] args) {
        Employee e = new Employee("Aman", 24, "EMP101", 50000);
        e.displayEmployee();
    }
}
