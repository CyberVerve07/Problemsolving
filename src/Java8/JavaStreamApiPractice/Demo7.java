package Java8.JavaStreamApiPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Demo7 {

    // From a list of employees, find the first employee
    // whose salary is greater than 50k

    public static void main(String[] args) {

        List<Employe1> employe1s = new ArrayList<>(Arrays.asList(

                new Employe1("Aditya", "IT", 7000),
                new Employe1("Rohan", "HR", 45000),
                new Employe1("Prachi", "Finance", 8000),
                new Employe1("Harsh", "IT", 4000),
                new Employe1("Kartik", "Sales", 6500)

        ));

        // Your Stream API logic here

        Optional<Employe1> result = employe1s.stream().filter(emp -> emp.getSalary() > 50000)
                .findFirst();
        if (result.isPresent()) {

            System.out.println(result);

        }else
            System.out.println("No employee salary is great then 50k");
    }
}