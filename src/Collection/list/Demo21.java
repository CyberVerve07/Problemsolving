package Collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo21 {
    public static void main(String[] args) {
        //We have a list of employee and find the average salary of employee in each department
        List<Employeelist> employeeList = new ArrayList<>(Arrays.asList(
                new Employeelist("Aditya", 50000, "IT"),
                new Employeelist("Aman", 60000, "HR"),
                new Employeelist("Rahul", 70000, "IT"),
                new Employeelist("Ankit", 80000, "HR"),
                new Employeelist("Rohit", 90000, "IT"),
                new Employeelist("Ankit", 80000, "HR"),
                new Employeelist("Prachi", 67000, "CA")
        ));
        Map<String, Double> result = employeeList.stream()
                .distinct()
                .collect(Collectors.groupingBy(emp -> emp.getDepartment(),
                        Collectors.averagingDouble(Employeelist::getSalary)));
        System.out.println(result);

    }
}
