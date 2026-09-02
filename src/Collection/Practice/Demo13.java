package Collection.Practice;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.List;

public class Demo13 implements Comparable {
    public Demo13() {
    }

 private  String name;
    private int employeeId;
   private double salary;
    private String address;

    //Generate the Constructor:


    public Demo13(String name, int employeeId, double salary, String address) {
        this.name = name;
        this.employeeId = employeeId;
        this.salary = salary;
        this.address = address;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        int sortById=Double.compare(this.employeeId,employeeId);


        return 0;
    }

    //Getters of the Fields:
    public String getName() {
        return name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public String getAddress() {
        return address;
    }
}

