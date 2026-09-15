package Java8.StreamApi;

public class FindFirst {
    String employeName;
    double salary;

    public FindFirst(String employeName, double salary) {
        this.employeName = employeName;
        this.salary = salary;
    }


    public String getEmployeName() {
        return employeName;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return employeName +salary;
    }
}
