package Collection.Practice;

public  abstract class Demo10 {

     private  String employeeId;
     private  String employeeName;
     private  String address;
     private String  phoneNO;
     private  double salary;

      //Create Constructor for the employee :


    public Demo10(String employeeId, String employeeName, String address, String phoneNO, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.address = address;
        this.phoneNO = phoneNO;
        this.salary = salary;
    }

      //Now Generate the Getters and Setters  of employess class

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNO() {
        return phoneNO;
    }

    public void setPhoneNO(String phoneNO) {
        this.phoneNO = phoneNO;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


      //Create a abstract method :

      abstract  void  work();
    //It is implemenst by  all the fields of employess:


       //Generate a concreat meathod


      void  printDetails(){
          System.out.println("::::::::::::::::::::::::::::::::");
          System.out.println("Employee name is "+employeeName);
          System.out.println("Employee id is "+getEmployeeId());
          System.out.println("Employee address is "+getAddress());
          System.out.println("Employee phoneNo is "+getPhoneNO());
          System.out.println("Employee salary is "+getSalary());
          System.out.println(":::::::::::::::::::::::::::::::::::");
      }



}
//In java abstract class have concrete and abstract method
//AN abstract class is usefully when we want to share the common state and implementation between the among subclasses
//Abstract class have Constructor and instance variables :