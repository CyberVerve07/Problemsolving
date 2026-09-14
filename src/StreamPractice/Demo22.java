package StreamPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Demo22 {

    public static void main(String[] args) {

        List<Employee2> employee2s = new ArrayList<>(Arrays.asList(

                new Employee2("Aditya", "IT", 90000),
                new Employee2("Rohan", "IT", 80000),
                new Employee2("Prachi", "HR", 95000),
                new Employee2("Kritika", "HR", 70000),
                new Employee2("Harsh", "Finance", 120000),
                new Employee2("Kartik", "Finance", 100000),
                new Employee2("Siya", "Sales", 75000),
                new Employee2("Pooja", "Sales", 65000)

        ));
//From a list of employee find the 2 highest paid emloyee in the lisy
        // Your Stream API logic here

        //sort this list in the desending order  that will


        List<Employee2> result = employee2s.stream()
                .sorted(Comparator.comparingDouble(emp ->-1* emp.getSalary()))
                .limit(2)
                .collect(Collectors.toList());

        System.out.println(result);

    }
}