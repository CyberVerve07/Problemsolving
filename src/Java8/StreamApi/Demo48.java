package Java8.StreamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Demo48 {
    public static void main(String[] args) {

        List<Employee7> employee7s = new ArrayList<>(Arrays.asList(
                new Employee7("Aditya", 70000, "It"),
                new Employee7("Abhishake", 9000, "Hr"),
                new Employee7("Prachi", 230000, "Hr"),
                new Employee7("Kartik", 32000, "Manager"),
                new Employee7("Prajwal", 92000, "IT"),
                new Employee7("Aman", 23000, "It")
        ));

        // Fix: reversed() lagakar descending order kiya aur findFirst() se result nikala
        Optional<Employee7> thirdHighest = employee7s.stream()
                .distinct()
                .sorted(Comparator.comparingDouble((Employee7 emp) -> emp.salary).reversed())
                .skip(2)
                .findFirst();

        if (thirdHighest.isPresent()) {
            System.out.println("3rd Highest Salary Employee: " + thirdHighest.get());
        } else {
            System.out.println("Insufficient data for 3rd highest salary.");
        }
    }
}