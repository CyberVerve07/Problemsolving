package august.augest8;

import dailycode.july.day24.Employee;
import dailycode.july.day24.serialization.Address;

public class Demo1Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address=new Address("19mall Road","BLR","BLR","84943");
        Demo1 demo1=new Demo1("Aditya","383083",75000,address);


        System.out.println(demo1.employeeName);
        System.out.println(demo1.employeeId );
        System.out.println(demo1.employeeSalary);
        System.out.println(address);
        System.out.println("======================");

         demo1.employeeId="8944933";

//         Demo1 demo2=demo1;
//        System.out.println(demo2);   bad way for Cloning;
try {
    Demo1 demo2 = (Demo1) demo1.clone();  //Shallow copy in Java : Implementing Clonable is required and also required method to be overridden
    System.out.println(demo2.toString());
    System.out.println(address);
    System.out.println(demo1);
    System.out.println(demo2);

} catch (CloneNotSupportedException e) {
    throw new RuntimeException(e);
}
    }
}
