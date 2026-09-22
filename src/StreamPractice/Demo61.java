package StreamPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo61 {

    public static void main(String[] args) {

        List<Employe7> list = new ArrayList<>(Arrays.asList(

                new Employe7("Vivek", "Engineering", 78000),
                new Employe7("Ananya", "Marketing", 56000),
                new Employe7("Siddhartha", "Finance", 125000),
                new Employe7("Meera", "HR", 68000),
                new Employe7("Arjun", "Engineering", 98000),
                new Employe7("Kavya", "Sales", 72000),
                new Employe7("Nikhil", "Finance", 115000),
                new Employe7("site", "Marketing", 64000),
                new Employe7("Varun", "Engineering", 87000),
                new Employe7("Tanvi", "HR", 59000),
                new Employe7("Abhishek", "Sales", 91000),
                new Employe7("Sneha", "Finance", 135000),
                new Employe7("Yash", "Engineering", 83000),
                new Employe7("Ritika", "Marketing", 61000),
                new Employe7("Manav", "Sales", 76000)

        ));

        // From a list of employees find the top 2 highest paid employees


        List<Employe7> result = list.stream().
                sorted(Comparator.comparingDouble(Employe7::getSalary).reversed())
                .limit(2).toList();
        System.out.println(result);


    }
}