package Collections.Set.TreeSet;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Employee> employees = new TreeSet<>();

        employees.add(new Employee(50000));
        employees.add(new Employee(30000));
        employees.add(new Employee(70000));

    }
}
