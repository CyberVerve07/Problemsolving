package dailycode.july15.employeeManagement;

public class Hr extends  Employee{
    public Hr( String employeeName,String employeeId, int age, String email, String phoneNo, String department, double salary) {
        super(  employeeName,  employeeId, age, email, phoneNo, department, salary);


    }


    void calculateSalary() {


            double recruitmentAllowance = 5000;
            double hiringBonus = 2000;

            double finalSalary = getSalary() + recruitmentAllowance + hiringBonus;

            System.out.println("===== HR Salary =====");
            System.out.println("Base Salary            : " + getSalary());
            System.out.println("Recruitment Allowance  : " + recruitmentAllowance);
            System.out.println("Hiring Bonus           : " + hiringBonus);
            System.out.println("Final Salary           : " + finalSalary);
        }

    @Override
    void work() {
        System.out.println("HR is Find the  new Employess:::");
    }

    @Override
    void present() {
        System.out.println("Hr is Makring attendence in 9:00AM: "+this.employeeName);

    }
}
