package Collection.list;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.List;

public class Demo18 {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Aditya", 50000, "IT"));
        employees.add(new Employee("Aman", 60000, "HR"));
        employees.add(new Employee("Rahul", 70000, "IT"));
        employees.add(new Employee("Ankit", 80000, "HR"));
        employees.add(new Employee("Rohit", 90000, "IT"));

        for (Employee e : employees) {
            System.out.println(e);
            if (e.getDepartment().equals("IT")) {
                System.out.println("IT Employee: " + e.getName());
            }
        }


    }
}
