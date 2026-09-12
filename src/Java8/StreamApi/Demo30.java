package Java8.StreamApi;

import java.util.*;
import java.util.stream.Collectors;

public class Demo30 {
    public static void main(String[] args) {

        List<HighesPaidEmployee> employees = new ArrayList<>(Arrays.asList(
                new HighesPaidEmployee("Aditya", "IT", 90000),
                new HighesPaidEmployee("Prachi", "HR", 90000),
                new HighesPaidEmployee("Harsh", "IT", 82000),
                new HighesPaidEmployee("Rohit", "Manager", 63000),
                new HighesPaidEmployee("Kanishka", "HR", 38000),
                new HighesPaidEmployee("Gone", "UI/UX", 45000)
        ));

        // Department-wise highest paid employee
        Map<String, Optional<HighesPaidEmployee>> result = employees.stream()
                .collect(Collectors.groupingBy(
                        HighesPaidEmployee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(HighesPaidEmployee::getSalary))
                ));

        
    }
}