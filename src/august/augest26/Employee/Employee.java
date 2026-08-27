package august.augest26.Employee;

import org.jetbrains.annotations.NotNull;

public class Employee implements  Comparable<Employee>{


    public Employee(String name, int employeeID, String emailAddress) {
        this.name = name;
        this.employeeID = employeeID;
        this.emailAddress = emailAddress;
    }

    String name;
     int employeeID;
     String emailAddress;



    @Override
    public int compareTo(Employee o) {
        int res=Integer.compare(this.employeeID,o.employeeID);
        return res;
    }

}
