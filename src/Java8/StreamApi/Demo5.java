package Java8.StreamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Demo5 {
    static void main() {

        //Stream in java is a introducing in java 8:
        //Stream is an Api frameWork
        //Stream is used to precess the Collection not  to store the data
        //In stream we have two operation
        //Intermediate ->>> Don't perform operation until it is not required
        //Terminate ->> Ends the Stream Pipeline :
        // theree are severals ways to create a Stream in java


          //The first operation is to process the elemenst  of the list


         List<Integer>numbers= Arrays.asList(5,1,2,4,6,7,8,9);
        Collections.sort(numbers);
        System.out.println(numbers);


            numbers.stream()

                    .filter(n->n%2==0);//Oeration 1 for keep Even Numbers:
        numbers.stream()
        .map(n->n*10);  //Operation is to perform the operation is divided by 10;

        numbers.forEach(n-> System.out.println(n));//Operation 3 is to print the result :



    }
}
