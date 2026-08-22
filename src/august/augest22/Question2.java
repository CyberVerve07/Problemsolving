package august.augest22;

import java.util.ArrayList;
import java.util.List;

public class Question2 {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
            numbers.add(10);
            numbers.add(20);
            numbers.add(30);
            numbers.add(40);
            numbers.add(50);
            //Remove the element at index 1.
        //Then remove the first occurrence of value 20.
        //Print the final list.

        System.out.println(numbers.remove(1));
        System.out.println(numbers.remove(1));
        System.out.println(numbers);

    }
}