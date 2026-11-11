package dsa.streamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo14 {
    public static void main(String[] args) {
        List<FindAvgSalaryByDepartment> avg = new ArrayList<>(Arrays.asList(
                new FindAvgSalaryByDepartment("Aditya", 92000, "it"),
                new FindAvgSalaryByDepartment("Kartik", 23000, "Hr"),
                new FindAvgSalaryByDepartment("Ashish", 240000, "It"),
                new FindAvgSalaryByDepartment("Prachi", 67000, "It"),
                new FindAvgSalaryByDepartment("Kritika", 63000, "It"),
                new FindAvgSalaryByDepartment("Anup", 6300, "HotelManager"),
                new FindAvgSalaryByDepartment("Agrim", 23000, "CA")
        ));

        // Find the average salary per department using raw department keys
        Map<String, Double> avgSalaryByDept = avg.stream()
                .collect(Collectors.groupingBy(
                        FindAvgSalaryByDepartment::getDepartment,
                        Collectors.averagingDouble(FindAvgSalaryByDepartment::getSalary)
                ));

        System.out.println(avgSalaryByDept);
    }
}