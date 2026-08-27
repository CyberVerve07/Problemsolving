package august.augest26.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriveEmployee {
    public static void main(String[] args) {

         Employee employee1=new Employee("Aditya",980,"adityamahajan7287@gmai.com");
         Employee employee2 =new Employee("Prachi",700,"prachi@gmail.com");
         Employee employee3=new Employee("Shyam",500,"shyam@gmail.com");
         Employee employee4=new Employee("Nitin",900,"nitin@9048");
         Employee employee5=new Employee("Ritesh",8734,"ritesh@6484gmail.com");
         Employee employee6=new Employee("Ashish",9832,"ashish@gmail.ciom");

        List<Employee>employees=new ArrayList<>();

          employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);


        Collections.sort(employees);

          for (int i=0;i< employees.size();i++){
               Employee emp=employees.get(i);

              System.out.println("Employees name is"+emp.name+" Employee id is: "+emp.employeeID+"Employee email id is"+emp.emailAddress);




          }



    }
}
