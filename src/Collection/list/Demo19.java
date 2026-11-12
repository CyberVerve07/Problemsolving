package Collection.list;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Demo19 {
    public static void main(String[] args) {
        //Find the Second-highest salary of the employee from the given array of salaries
        List<Employeelist> employee=new ArrayList<>(Arrays.asList(
                new Employeelist("Aditya", 50000, "IT"),
                new Employeelist("Aman", 60000, "HR"),
                new Employeelist("Rahul", 70000, "IT"),
                new Employeelist("Ankit", 80000, "HR"),
                new Employeelist("Rohit", 90000, "IT"),
                new Employeelist("Anikit", 80000, "HR")
        ));

        Optional<Employeelist> result = employee.stream()
                .distinct()
                .sorted(Comparator.comparingDouble(Employeelist::getSalary).reversed())
                .skip(1)
                .findFirst();

        System.out.println(result);

    }
}
