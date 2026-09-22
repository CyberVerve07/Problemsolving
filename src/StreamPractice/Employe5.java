package StreamPractice;

public class Employe5 {
    private  String name;
    private String department;
    private double salary;
    private double mobNo;

    //Create an Constructor to it


    public Employe5(String name, String department, double salary, double mobNo) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.mobNo = mobNo;
    }

     //Now provide the Getter to it


    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public double getMobNo() {
        return mobNo;
    }

    @Override
    public String toString() {
        return "Employe5{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", mobNo=" + mobNo +
                '}';

    }
}
