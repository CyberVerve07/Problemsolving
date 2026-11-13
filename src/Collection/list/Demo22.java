package Collection.list;

import java.util.*;
import java.util.stream.Collectors;

public class Demo22 {
    public static  void main(String[] args) {

        List<Eemployee4> employee=new ArrayList<>(Arrays.asList(
                new Eemployee4("Aditya","It",82000),
                new Eemployee4("KArtik","Bank",23000),
                new Eemployee4("Suresh","Finance",50000),
                new Eemployee4("Prachi","Bank",23000),
                new Eemployee4("Rohit","It",82000),
                new Eemployee4("Ashish","It",32000),
                new Eemployee4("Ankit","Finance",50000),
                new Eemployee4("Anup","Bank",23000),
                new Eemployee4("Ronit","It",82000)
        ));

        //Find the highet paid emplooyee in each department and print the employee details
        Map<String, Optional<Eemployee4>> result = employee.stream()
                .distinct()
                .collect(Collectors.groupingBy(Eemployee4::getEmployeeDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Eemployee4::getSalary))));
        System.out.println(result);;


    }


}
