package august.augest5;

import august.augest4.Practice.Employee;

public class Demo9 {
    public static void main(String[] args) {
        try {
            employeeID("Aditya",890,40000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void employeeID(String name, int id, double sallary) throws  IllegalArgumentException {

        System.out.println("Welcome to the Oracle");

        System.out.println("Employee name is "+name);
        System.out.println("User id is "+id);
        System.out.println("User salary is "+sallary);

         if (sallary<=0)
             throw  new IllegalArgumentException("Salary is not in negative ");





    }
}