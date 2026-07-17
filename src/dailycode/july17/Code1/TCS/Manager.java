package dailycode.july17.Code1.TCS;

public class Manager extends  Employee{
    public Manager(String name, int employeeId, double salary) {
        super(name, employeeId, salary);
    }

    @Override
    void calculateSalary() {
        double bonus = 20000;

        double totalSalary = getSalary() + bonus;

        System.out.println(" Current Salary : " + getSalary());
        System.out.println(" Bonus : " + bonus);
        System.out.println(" Total Salary : " + totalSalary);

    }

    @Override
    void getRole() {
        System.out.println("Project Manager heap ");

    }
}
