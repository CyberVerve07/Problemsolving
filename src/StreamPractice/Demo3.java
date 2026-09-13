package StreamPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo3 {

    public static void main(String[] args) {

        List<Department>employee=new ArrayList<>(Arrays.asList(
                new Department("Aditya","IT",50000),
                new Department("Rohit","IT",62000),
                new Department("Prachi","HR",90000),
                new Department("Kartik","IT",45000),
                new Department("Rohan","IT",52000),
                new Department("Harts","IT",540000),
                new Department("Siya","Sales",87000),
                new Department("Sales","Marketing",89000),
                new Department("Sona","Sales",34000)
        ));

        Map<String, Double> result = employee.stream().collect(Collectors.groupingBy(emp -> emp.employeeDepartment,
                Collectors.averagingDouble(emp -> emp.salary)));
        System.out.println(result);


    }
}
