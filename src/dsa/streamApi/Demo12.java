package dsa.streamApi;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Demo12 {
    public static void main(String[] args) {


        List<ThirdHighestSalary>thirdHighestSalaries= new ArrayList<>(Arrays.asList(
                new ThirdHighestSalary("Aditya","It",70000),
                new ThirdHighestSalary("Aryan","Manager",90000),
                new ThirdHighestSalary("Kartik","Bank",98000),
                new ThirdHighestSalary("Radhe","Hr",78000),
                new ThirdHighestSalary("Ashish","It",230000),
                new ThirdHighestSalary("Prachi","It",34000)

        ));

        //Performing the stream logic find the 3rd highest salary:

          thirdHighestSalaries.stream()
                  .distinct()
                  .sorted(Comparator.comparingDouble(emp-> emp.employeeSalary*-1))
                  .skip(2)
                  .findFirst()
                  .ifPresent(System.out::println);
    }
}
