package StreamPractice;

public class Employe6 {
    private String name;
    private String department;
    private  double salary;

    //Create an Constructor

    public Employe6(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    //Create an Getter methods


    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employe6{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
