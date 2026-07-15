package dailycode.july15.employeeManagement;

public class Manager extends Employee{

    public Manager(String employeeName, String employeeId, int age, String email, String phoneNo, String department, double salary) {
        super(employeeName, employeeId, age, email, phoneNo, department, salary);
    }

    @Override
    void calculateSalary() {
         double bonus=3000;
          double projectComplete=40000;

        double finalSalary = getSalary() + bonus+projectComplete;

        System.out.println("===== Manager  Salary =====");
        System.out.println("Base Salary            : " + getSalary());
        System.out.println("Bonus Allowance  : " + bonus);
        System.out.println(" Team Lead  Bonus           : " + projectComplete);
        System.out.println("Final Salary           : " + finalSalary);



    }

    @Override
    void work() {
        System.out.println("Manager work on the new Project assigning ");
    }

    @Override
    void present() {
        System.out.println("Manager is Marking attendenc at 10:08AM: "+this.employeeName);
    }
}