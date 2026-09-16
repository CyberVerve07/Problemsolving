package StreamPractice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo26 {
    //Given a list of employee count how many employees are in each Department


    public static void main(String[] args) {

        List<Emloye4>emloye4s=new ArrayList<>(Arrays.asList(
                new Emloye4("Aditya","Manager",50000),
                new Emloye4("Prachi","Hr",40000),
                new Emloye4("Radhika","IT",42000),
                new Emloye4("Shourya","Hr",92000),
                new Emloye4("Ganesh","Hr",49000),
                new Emloye4("Kartik","Manager",90000),
                new Emloye4("Arushi","IT",56000)
        ));


        Map<String, Long> employee = emloye4s.stream()
                .collect(Collectors.groupingBy(emloye4 -> emloye4.department
                        , Collectors.counting()));
        System.out.println(employee);

    }
}
