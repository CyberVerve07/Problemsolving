package StreamPractice;

import java.util.*;
import java.util.stream.Collectors;

public class Demo60 {

    // Find the first employee whose salary is greater than 50K

    public static void main(String[] args) {

        List<Employe6> employees = new ArrayList<>(Arrays.asList(

                new Employe6("Nitin", "IT", 70000),
                new Employe6("Rohan", "HR", 45000),
                new Employe6("Prachi", "Finance", 85000),
                new Employe6("Harsh", "IT", 40000),
                new Employe6("Kartik", "Sales", 65000),
                new Employe6("Riya", "HR", 55000),
                new Employe6("Aman", "IT", 48000),
                new Employe6("Pooja", "Finance", 92000),
                new Employe6("Rahul", "Sales", 35000),
                new Employe6("Neha", "HR", 61000)

        ));

        // Your Stream API logic here

        Optional<Employe6> result = employees.stream()
                .filter(emp -> emp.getSalary() > 50000)
                .distinct()
                .findFirst();
         if (result.isPresent()){
             System.out.println(result);
         }
         else {
             System.out.println("No Employee whosw sallary is greate than 50k");
         }


    }
}