package Java8.JavaStreamApiPractice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Demo17 {
    public static void main(String[] args) {



        //Creata a list of employess

         List<Employe4> secondHighestSalary=new ArrayList<>(Arrays.asList(
                 new Employe4("Aditya","IT",23000),
                 new Employe4("Rasdhe","HR",90000),
                 new Employe4("Rashid","IT",43000),
                 new Employe4("Loin","Manager",82000),
                 new Employe4("Vishwash","Manager",89000)
         ));

         //Now the requirements is to find the second highest salary

        List<Employe4> ressult = secondHighestSalary.stream()
                .distinct()
                .sorted(Comparator.comparingDouble(emp -> emp.getSalary()))
                .skip(2)
                .limit(1)
                .collect(Collectors.toList());
        System.out.println(ressult);

    }
}
