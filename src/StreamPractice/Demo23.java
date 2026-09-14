package StreamPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Demo23 {
    public static void main(String[] args) {
        List<Employe3> employee3s = new ArrayList<>(Arrays.asList(
                new Employe3("Aditya", "IT", 90000),
                new Employe3("Rohan", "IT", 80000),
                new Employe3("Prachi", "HR", 95000),
                new Employe3("Kritika", "HR", 70000),
                new Employe3("Harsh", "Finance", 120000),
                new Employe3("Kartik", "Finance", 100000),
                new Employe3("Siya", "Sales", 75000),
                new Employe3("Pooja", "Sales", 65000)
        ));
        // Sort employees by salary and then by name
        employee3s.stream()
                .sorted(
                        Comparator.comparingDouble(Employe3::getSalary)
                                .thenComparing(Employe3::getName)
                )
                .forEach(System.out::println);
    }
}