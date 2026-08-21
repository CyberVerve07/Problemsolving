package Collections.Set.TreeSet.Task2;

public class Employee implements  Comparable {
     String employeeID;
     String employeeName;
     String department;
     double salary;


      //Create a Constructor :


    public Employee(String employeeID, String employeeName, String department, double salary) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.department = department;
        this.salary = salary;
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
