package dailycode.july17.Code1.TCS;

public class SoftwareEngineer extends Employee{
    public SoftwareEngineer(String name, int employeeId, double salary) {
        super(name, employeeId, salary);
    }



    @Override
    void calculateSalary() {
            double bonus = 10000;

            double totalSalary = getSalary() + bonus;

            System.out.println(" Current Salary : " + getSalary());
            System.out.println(" Bonus : " + bonus);
            System.out.println(" Total Salary : " + totalSalary);
        }

    @Override
    void getRole() {
        System.out.println( "Software Developer::");
    }
}


