package Java8.JavaStreamApiPractice;

public class Employe1 {
    private  String employeName;
    private  String employeDepartment;
    private  double salary;


     //create an Constructor for give the valve adt obj creation type


    public Employe1(String employeName, String employeDepartment, double salary) {
        this.employeName = employeName;
        this.employeDepartment = employeDepartment;
        this.salary = salary;
    }


    public String getEmployeName() {
        return employeName;
    }

    public String getEmployeDepartment() {
        return employeDepartment;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return employeName+
                employeDepartment
                +getSalary();
    }
}
