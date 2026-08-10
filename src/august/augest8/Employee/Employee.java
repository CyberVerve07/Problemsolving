package august.augest8.Employee;

public class Employee {

     private String employeeName;
     private  String getEmployeeEmail;
     private String address;
     private double employeeSalary;
     private  String employeeId;
     private  String employeePhoneNo;


       //Create constructor for initialization the values during Object Creation


    public Employee(String employeeName, String getEmployeeEmail, String address, double employeeSalary, String employeeId, String employeePhoneNo) {
        this.employeeName = employeeName;
        this.getEmployeeEmail = getEmployeeEmail;
        this.address = address;
        this.employeeSalary = employeeSalary;
        this.employeeId = employeeId;
        this.employeePhoneNo = employeePhoneNo;
        //this keyword is used to refer the current value of an obj : eh this.employeename=employee
    }

      //Generate getters and setters for access control


    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getGetEmployeeEmail() {
        return getEmployeeEmail;
    }

    public void setGetEmployeeEmail(String getEmployeeEmail) {
        this.getEmployeeEmail = getEmployeeEmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeePhoneNo() {
        return employeePhoneNo;
    }

    public void setEmployeePhoneNo(String employeePhoneNo) {
        if (employeePhoneNo.equals(10)) {
            this.employeePhoneNo = employeePhoneNo;}
        else {
            System.out.println("Phone no is least contain the 10 letters ");
        }


    }

    void showDetails(){
        System.out.println("Employee name is "+getEmployeeName());
        System.out.println("Employee id is :"+getEmployeeId());
        System.out.println("Employee address is "+getAddress());
        System.out.println("Employee email is:"+getEmployeeEmail);
        System.out.println("Employee sallary is :"+getEmployeeSalary());
        System.out.println("Employee phone number is "+getEmployeePhoneNo());

    }
     void login(){
         System.out.println("Employee is login");
     }
     void logout(){
         System.out.println("Employee is logout");
     }
}

