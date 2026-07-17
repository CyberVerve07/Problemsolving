package dailycode.july17.Code1.TCS;

public class HR extends  Employee{
    public HR(String name, int employeeId, double salary) {
        super(name, employeeId, salary);
    }

    @Override
    void calculateSalary() {
        double bonus = 2000;

        double totalSalary = getSalary() + bonus;

        System.out.println("Current Salary : " + getSalary());
        System.out.println("Bonus : " + bonus);
        System.out.println("Total Salary : " + totalSalary);

    }

    @Override
    void getRole() {
        System.out.println(" Hiring the Employee ");

    }
}
