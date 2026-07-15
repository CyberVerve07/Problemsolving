package dailycode.july15.employeeManagement;

public class Employee {
    //Create Employee Details
     public  String employeeName;
    private String employeeId;
    private int age;
    private String email;
    private String phoneNo;
    private String department;
    private double salary;

    public Employee(String employeeName,String employeeId, int age, String email, String phoneNo, String department, double salary) {
       this.employeeName=employeeName;
        this.employeeId = employeeId;
        this.age = age;
        this.email = email;
        this.phoneNo = phoneNo;
        this.department = department;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {

        this.employeeId = employeeId;
    }

    public int getAge() {
        return age;
    }

    public int setAge(int age) {

        if (age >= 18) {
            this.age=age;
        } else {
            System.out.println("Age should be Greater the 18 ");

        }


        return age;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
         if (phoneNo.length()==10) {
             this.phoneNo = phoneNo;
         }
         else {
             System.out.println("Phone number length should be 10 digit ");
         }

    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            System.out.println("Salary should be higher then 0");
        }
    }


           //Now create the functions for :: login
       void  login(){
           System.out.println("===================================");
           System.out.println("Login Successful");
           System.out.println(" User is  login" +this.employeeName);
           System.out.println(" Role is "+this.department);
           System.out.println("===================================");
       }


       //Create a function for the logout:"
      void  logout(){
          System.out.println(" Employee is logout Successful::: Have a nice day  ");
      }
                   //Method for display the User Details
             void  displayDetails(){
                 System.out.println("==============================");
                 System.out.println(" Display Employee Details :: ");
                 System.out.println( " Employee name is " +this.employeeName);
                 System.out.println("Enployee  Id is " +this.employeeId);
                 System.out.println(" Employee email is "+this.email);
                 System.out.println("Employee age is "+this.age);
                 System.out.println("Employee PhoneNumber is : "+this.phoneNo);
                 System.out.println("Employee Department is "+this.department);
                 System.out.println("Employee Salary is : "+this.salary);
                 System.out.println("===================================");

             }
//This method is Override:::
   void    calculateSalary(){
       System.out.println(" Calcuate Salary::: ");


    }

       //Method for daily Work
           void  work(){
               System.out.println("Today Work is :::");
           }

            //Method for mark attendence:
     void  present(){
         System.out.println("Marking the Attendence Daily:: ");
     }

       void  companyPolicy(){
           System.out.println("Employee Can;t take levae without Approvel of HR");
           System.out.println("Every friday  Confrence Metting is conduct: ");
           System.out.println("====================================\n" +
                   "Company Policies Accepted\n" +
                   "\n" +
                   "Employee must follow company rules.\n" +
                   "\n" +
                   "Employee must maintain confidentiality.\n" +
                   "\n" +
                   "Employee must work ethically.\n" +
                   "\n" +
                   "====================================");
       }

}