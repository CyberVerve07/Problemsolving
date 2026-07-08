package dailycode.july8;

public class Check2 {
    public static void main(String[] args) {
        Employee run=new Employee(609);
        run.setSalary(50000);
        run.setName("Aditya");

        System.out.println("The Employee name is "+run.getName());
        System.out.println("Employee salary is "+run.getSalary());
    }
}
