package Collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo20 {
    public static void main(String[] args) {

        List<Employee2>employee=new ArrayList<>(Arrays.asList(
                new Employee2("101","Aditya","IT",50000),
                new Employee2("102","Aman","HR",60000),
                new Employee2("103","Rahul","IT",70000),
                new Employee2("104","Ankit","HR",80000),
                new Employee2("105","Rohit","IT",90000),
                new Employee2("106","Ankit","HR",80000),
                new Employee2("107","Rohit","IT",90000),
                new Employee2("108","Ankit","HR",80000)
        ));
        //Find the Second highest salary in each department and print the employee details

        employee.stream()
                .collect(Collectors.groupingBy(Employee2::getDepartment))
                .forEach((department, employees) -> {

                    employees.stream()
                            .sorted((e1, e2) ->
                                    Double.compare(e2.getSalary(), e1.getSalary()))
                            .map(Employee2::getSalary)
                            .distinct()
                            .skip(1)
                            .findFirst()
                            .ifPresent(secondSalary -> {

                                employees.stream()
                                        .filter(e -> e.getSalary() == secondSalary)
                                        .forEach(System.out::println);
                            });
                });




    }
}
