package dailycode.july8;

import javax.xml.namespace.QName;

public class Employee {

    //Question 3: Employee
    //
    //Create an Employee class using encapsulation.
    //
    //Private Variables:
    //- id
    //- name
    //- salary
    //
    //Methods:
    //- setName(), getName()
    //- setSalary(), getSalary()
    //- getId()
    //
    //Conditions:
    //- Salary cannot be negative.
    //- ID should be assigned using constructor only.
    //- ID cannot be changed later.
    //*/


      private int id;
      private String name;
      private  double salary;
      //Method

       Employee(int id){
           System.out.println("Your id is :"+id);
           this.id=id;
       }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary; // Sirf tabhi set karo jab salary positive ho!
        } else {
            System.out.println("Error: Salary cannot be negative!");
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }



}
