package Collections.Practice;

public class SoftwareEnginear extends Demo10 {

    public SoftwareEnginear(String employeeId, String employeeName, String address, String phoneNO, double salary) {
        super(employeeId, employeeName, address, phoneNO, salary);
    }

    @Override
    void work() {
        System.out.println("Devolper is Writting the code ");
    }
}
