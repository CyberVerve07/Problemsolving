package august.augest4.Practice;

import java.util.function.Predicate;

public class Swelam {
    public static void main(String[] args) {
        Employee employee =() ->"Aditya";
        System.out.println(employee.getName());

        Employee hr=()->"Prachi";
        System.out.println(hr.getName());
        //Lambda expression is a feature introduced in java8 basically help to achieve the functional
        //programming in java it is basically used for code shorter
        // Create a obj without create subclass
        // we can't use the method name  return type and  access modifier to declare it
        // Its makes code more shoter and usable
        //If new Requirement is given we can easily implement without breaking the old one
        //Function interface have only one abstract method


    }
}
