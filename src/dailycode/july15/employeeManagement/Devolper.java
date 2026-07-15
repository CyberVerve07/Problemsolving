package dailycode.july15.employeeManagement;

public class Devolper extends Employee{


    public Devolper(String employeeName, String employeeId, int age, String email, String phoneNo, String department, double salary) {
        super(employeeName, employeeId, age, email, phoneNo, department, salary);
    }

    @Override
    void calculateSalary() {
        double diwaliBonus = 5000;
        double deploy = 9000;

        double finalSalary = getSalary() + diwaliBonus + deploy;

        System.out.println("===== Devloper  Salary =====");
        System.out.println("Base Salary            : " + getSalary());
        System.out.println("Diwali Bonus Allowance  : " + diwaliBonus);
        System.out.println("Deploy  Bonus           : " + deploy);
        System.out.println("Final Salary           : " + finalSalary);
    }


    @Override
    void work() {
        System.out.println("Devolper is Writing the code::");
        System.out.println("Devolper is doing work honestly:");
    }

    @Override
    void present() {
        System.out.println("Devolper is marking Attendence at 10::Am "+this.employeeName);
    }
}
