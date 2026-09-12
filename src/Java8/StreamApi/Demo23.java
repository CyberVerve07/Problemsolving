package Java8.StreamApi;

import august.augest3.Exception.Liabrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Demo23 {
    public static void main(String[] args) {

        List<Employee> employee=new ArrayList<>(Arrays.asList(

                new Employee("Aditya",50000),
                new Employee("Prachi",70000),
                new Employee("Gulshan_Bhai",80000),
                new Employee("Sultan-Bhai",890000),
                new Employee("Harsh",830000)
        ));

        Optional<Employee> result = employee.stream().filter(e -> e.salary > 50000)
                .findFirst();
        if (result.isPresent()){
            System.out.println(result.get());

        }


//findFirst() is a terminal operation that returns an Optional containing the first element that matches
//the stream conditions.
// If no element matches, it returns an empty Optional.
    }
}
