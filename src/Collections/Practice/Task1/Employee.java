package Collections.Practice.Task1;

public class Employee implements Comparable<Employee> {
    private String name;
    private String id;
    private double salary;

    public Employee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Employee other) {
        // Step 1: Salary comparison (Ascending)
        int salaryComparison = Double.compare(this.salary, other.salary);

        if (salaryComparison != 0) {
            return salaryComparison;
        }

        // Step 2: Salary same hone par ID comparison (Ascending)
        return this.id.compareTo(other.id);
    }

    @Override
    public String toString() {
        // Console par hex address ki jagah readable data print karne ke liye
        return "Employee{id='" + id + "', name='" + name + "', salary=" + salary + "}";
    }
}