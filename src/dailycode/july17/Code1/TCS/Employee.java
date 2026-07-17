package dailycode.july17.Code1.TCS;
//Imagine you're working at Infosys/TCS/Amazon. The company wants a backend module to manage employees.
public abstract class Employee {
    public Employee(String name, int employeeId, double salary) {
        this.name = name;
        this.employeeId = employeeId;
        this.salary = salary;
    }

    private String name;
    private int employeeId;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
         if (salary<0) {
             this.salary = salary;
         }
         else {
             System.out.println("Salary can't be negative:");
         }
    }
     void displayEmployee(){
         System.out.println("=============================");
         System.out.println(" Employee name is "+getName());
         System.out.println("Employee id is "+getEmployeeId());

         System.out.println("Employee Base Salary is "+getSalary());
         System.out.println("=====================================");
         System.out.println();

     }

     final  void  showCompanyPolicy(){
         System.out.println(  "All employees must work 8 hours daily.");
     }

      void companyName(){
          System.out.println("Company name ");
          System.out.println("Oracle");
      }
        abstract void calculateSalary();


      abstract  void getRole();



}