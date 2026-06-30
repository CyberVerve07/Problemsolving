//import Oops.Person;
//
//class Employee extends Person {
//
//    // Encapsulation
//    private String employeeId;
//    private double salary;
//
//    // Child Constructor
//    Employee(String name, int age, String employeeId, double salary) {
//
//        super(name, age);      // Parent constructor call
//
//        this.employeeId = employeeId;
//
//        if (salary >= 0) {
//            this.salary = salary;
//        } else {
//            this.salary = 0;
//        }
//    }
//
//    void displayEmployee() {
//
//        displayPerson();
//
//        System.out.println("Employee ID : " + employeeId);
//        System.out.println("Salary : " + salary);
//    }
//}
//
//public class person {
//
//    public static void main(String[] args) {
//
//        Oops.Employee e = new Oops.Employee("Aman",24,"EMP101",50000);
//
//        e.displayEmployee();
//    }
