package Java8.JavaStreamApiPractice;

public class Employe2 {
    String name;
    String department;
    double salary;

    //Create a constructor of it


    public Employe2(String name, String department, double salary) {

        this.name = name;
        this.department = department;
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
