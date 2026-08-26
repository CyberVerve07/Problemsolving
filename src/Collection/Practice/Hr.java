package Collection.Practice;

public class Hr extends  Demo10{
    public Hr(String employeeId, String employeeName, String address, String phoneNO, double salary) {
        super(employeeId, employeeName, address, phoneNO, salary);
    }

    @Override
    void work() {
        System.out.println("HR is finding the New Employees ");
    }
}
