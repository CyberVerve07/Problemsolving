package StreamPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo62 {

    // From a list of employees,
    // sort employees by their name and salary

    public static void main(String[] args) {

        List<Employee8> list = new ArrayList<>(Arrays.asList(

                new Employee8("Aarav", "IT", 85000),
                new Employee8("Diya", "HR", 72000),
                new Employee8("Kabir", "Finance", 95000),
                new Employee8("Aarav", "Sales", 65000),
                new Employee8("Mehul", "IT", 88000),
                new Employee8("Diya", "Finance", 91000),
                new Employee8("Rhea", "Marketing", 76000),
                new Employee8("Kabir", "IT", 82000),
                new Employee8("Anaya", "HR", 69000),
                new Employee8("Mehul", "Finance", 105000),
                new Employee8("Rhea", "Sales", 73000),
                new Employee8("Anaya", "IT", 81000)

        ));

        // Your Stream API logic here
        List<Employee8> result = list.stream()
                .sorted((e1, e2) -> {
                    int nameCompare = e1.getName().compareTo(e2.getName());

                    if (nameCompare == 0) {
                        return Double.compare(e1.getSalary(), e2.getSalary());
                    }

                    return nameCompare;
                })
                .toList();

        System.out.println(result);
    }
}