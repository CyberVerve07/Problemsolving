package dsa.streamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortEmployessByTheirName {
    //We have a list of Employee and we need to sort by their name and their salary

    private  String employeeName;
    private  double employeeSalary;
    private  String employeeDepartment;
    private  int employeePhoNo;

     //Create a Constructor of it


    public String getEmployeeName() {
        return employeeName;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public int getEmployeePhoNo() {
        return employeePhoNo;
    }

    public SortEmployessByTheirName(String employeeName, double employeeSalary, String employeeDepartment, int employeePhoNo) {
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeDepartment = employeeDepartment;
        this.employeePhoNo = employeePhoNo;


        //Create the Getter method  of it



    }
    class main{
        public static void main(String[] args) {
            List<SortEmployessByTheirName>list=new ArrayList<>(Arrays.asList(
                    
            ))

        }
    }

}
