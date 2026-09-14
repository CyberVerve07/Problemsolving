package StreamPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Demo21 {

    public static void main(String[] args) {

        List<Employee1> employee1s = new ArrayList<>(Arrays.asList(

                new Employee1("Aditya", "IT", 9000),
                new Employee1("Rohan", "IT", 8000),
                new Employee1("Prachi", "HR", 95000),
                new Employee1("Kritika", "HR", 7000),
                new Employee1("Harsh", "Finance", 12000),
                new Employee1("Kartik", "Finance", 10000),
                new Employee1("Siya", "Sales", 7500),
                new Employee1("Pooja", "Sales", 6500)

        ));
        //Find the first emplotyee whosw sallary is greate than 50 k

        // Your Stream API logic here

        Optional<Employee1> result = employee1s.stream()
                .filter(employee1 -> employee1.salary > 50000)
                .findFirst();
        if (result.isPresent()) {
            System.out.println(result);
        }
        else {
            System.out.println("No employee whose salary is great than 50k ");
        }
    }
}