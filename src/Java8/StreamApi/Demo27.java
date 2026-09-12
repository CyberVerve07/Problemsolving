package Java8.StreamApi;

import java.util.*;
import java.util.stream.Collectors;

public class Demo27 {

    public static void main(String[] args) {

        List<DeptEmployee> employees = new ArrayList<>(Arrays.asList(
                //We have an given a list we need to  find the frequency of the employees on the basis of  their departmrnt :

                new DeptEmployee("Rohan", "IT", 90000),
                new DeptEmployee("Rohit", "HR", 90000),
                new DeptEmployee("Suraj", "IT", 80000),
                new DeptEmployee("Harsh", "Finance", 90000),
                new DeptEmployee("Puppy", "HR", 80000),
                new DeptEmployee("Siya", "IT", 82000),
                new DeptEmployee("Ritesh", "Finance", 720000),
                new DeptEmployee("Aditya", "IT", 90000)
        ));

        // Sort by Department
        Map<String, Long> res = employees.stream().collect(Collectors.groupingBy(emp -> emp.employeeDepartment,
                Collectors.counting()));
        System.out.println(res);


    }
}