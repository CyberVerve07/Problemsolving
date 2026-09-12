package Java8.StreamApi;

public class HighesPaidEmployee {
    String name;
    String department;
    double salary;
    //Give a list of employee find the highest paid employee in each department

    //Generate a Constructor


    public HighesPaidEmployee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    //Create a getters methods


    public String getName() {
        return name;
    }
    public String getDepartment() {
        return department;
    }
    public double getSalary() {
        return salary;
    }
}
