package dailycode.july15.employeeManagement;

public  class Tester extends  Employee{

    public Tester(String employeeName, String employeeId, int age, String email, String phoneNo, String department, double salary) {
        super(employeeName, employeeId, age, email, phoneNo, department, salary);
    }

    @Override
    void calculateSalary() {
         double solveBugs=9000;
          double productionReady=10000;

            double finalSalary =getSalary() +solveBugs+productionReady;

        System.out.println("===== Tester   Salary =====");
        System.out.println("Base Salary            : " + getSalary());
        System.out.println("Bugs Solving Allowance  : " + solveBugs);
        System.out.println(" Run Code on Production Te Bonus           : " + productionReady);
        System.out.println("Final Salary           : " + finalSalary);

    }

    @Override
    void work() {
        System.out.println("Test is Test the Code ::");
    }

    @Override
    void present() {
        System.out.println("Tester is marking Attendence  at 9:50AM:"+this.employeeName);
    }
}