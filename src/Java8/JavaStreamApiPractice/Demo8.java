package Java8.JavaStreamApiPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Demo8 {

    public static void main(String[] args) {

        List<Employe2> employe2s = new ArrayList<>(Arrays.asList(

                new Employe2("Aditya", "IT", 70000),
                new Employe2("Rohan", "HR", 45000),
                new Employe2("Prachi", "Finance", 85000),
                new Employe2("Harsh", "IT", 55000),
                new Employe2("Kartik", "Sales", 65000),
                new Employe2("Riya", "HR", 72000),
                new Employe2("Aman", "IT", 48000),
                new Employe2("Pooja", "Finance", 95000),
                new Employe2("Rahul", "Sales", 52000),
                new Employe2("Neha", "HR", 61000),
                new Employe2("Vikas", "IT", 90000),
                new Employe2("Kartik", "Finance", 78000),
                new Employe2("Sahil", "Sales", 88000),
                new Employe2("Simran", "HR", 39000),
                new Employe2("Manisha", "IT", 82000),
                new Employe2("Anjali", "Finance", 67000),
                new Employe2("Rohit", "Sales", 91000),
                new Employe2("Nisha", "HR", 83000),
                new Employe2("Deepak", "IT", 44000),
                new Employe2("Kiran", "Finance", 56000)
//Find the 2 highest paid employee
        ));

        // Your Stream API logic here

        List<Employe2> result = employe2s.stream()

                .sorted(Comparator.comparingDouble(emp ->-1* emp.salary))
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(result);

    }
}