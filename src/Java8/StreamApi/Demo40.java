package Java8.StreamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Demo40 {
    public static void main(String[] args) {

        List<EmployeeSecondHighestSalary>employe=new ArrayList<>(Arrays.asList(

                new EmployeeSecondHighestSalary("Aditya","IT",72000),
                new EmployeeSecondHighestSalary("Rohan","Manager",6200),
                new EmployeeSecondHighestSalary("Prachi","HR",32000),
                new EmployeeSecondHighestSalary("Prajwal","IT",45000),
                new EmployeeSecondHighestSalary("Ganesh","Manager",39000),
                new EmployeeSecondHighestSalary("Bola","IT",55000),
                new EmployeeSecondHighestSalary("Kartik","Manager",90000)
        ));

        //Find the Second highest sallary of the employee:

        employe.stream()
                .sorted(Comparator.comparingDouble(EmployeeSecondHighestSalary::getSalary).reversed())
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);


        //

    }
}
