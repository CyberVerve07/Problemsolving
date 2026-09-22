package StreamPractice;

import Collection.Set.linkedHashSet.LinkedHashSetDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo51 {
    public static void main(String[] args) {

        List<Employe5> employe5List=new ArrayList<>(Arrays.asList(
                new Employe5("Aditya","It",70000,981839393),
                new Employe5("Kartik","IT",9200,83039303),
                new Employe5("Harsh","Hr",90000,749484904),
                new Employe5("Parv","UI/UX",93000,940494044)
        ));

        //Now find the second-highest salary of the employee

        Stream<Employe5> result = employe5List.stream()
                .distinct()
                .sorted(Comparator.comparingDouble(Employe5::getSalary).reversed())
                .skip(1)
                .limit(1);
        System.out.println(result);
    }
}
