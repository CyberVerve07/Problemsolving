package July3;

public class code5 {
    //Problem:
    //
    //Create an Employee class.
    //
    //Fields:
    //
    //id
    //name
    //salary
    //
    //Use a parameterized constructor to initialize all values.
    //
    //Create two employees and print their details.
    //
    //Concepts Tested:
    //
    //Constructor
    //Object initialization
    public  int id;
    public  String name;
    public double salary;

    code5(int  id,String name,double salary){
        this.id=id;
        this.name=name;
        this.salary=salary;


    }
     void  employee1(){
         System.out.println("The details of first employee is ");
         System.out.println("____________________________");
         System.out.println("Name is " +name);
         System.out.println("Employee id is "+id);
         System.out.println("Salary of the Employee is "+salary);
     }
     void  employee2(){
         System.out.println("The details of second employee is");
         System.out.println("______________________________");
         System.out.println("Name of the employee is " +name);
         System.out.println("Employee id is :"+id);
         System.out.println("Employee Salary is "+salary);

     }


}
