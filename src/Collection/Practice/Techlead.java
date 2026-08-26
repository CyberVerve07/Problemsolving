package Collection.Practice;

public class Techlead extends Demo10 {
    public Techlead(String employeeId, String employeeName, String address, String phoneNO, double salary) {
        super(employeeId, employeeName, address, phoneNO, salary);
    }

    @Override
    void work() {
        System.out.println("Techlead is viewing the project and assign the tasks to the interns ");
    }
}
