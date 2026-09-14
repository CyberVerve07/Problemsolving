package StreamPractice;

public class Employee2 {

    private String name;
    private  String department;
    private  double salary;
     //Generate an Constrcutor


    public Employee2(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    //Creata an getters methods


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
        return name
                +department
                + salary;
    }
}
