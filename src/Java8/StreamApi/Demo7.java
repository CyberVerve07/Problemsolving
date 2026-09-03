package Java8.StreamApi;

import java.sql.ClientInfoStatus;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo7 {
    public static void main(String args[]){
        //Perform the chained operation on the Stream :

        List<String>iteams= Arrays.asList("Core java","Spring","Spring Boot","Kafka","Redis","Kubernetes","Docker","Microsrvvicies");

        //Convert the list into a Stream

  List<String> result=iteams.stream()
          .filter(iteam->iteam.length()>5)//Use lambda to filter
          .map(iteam->iteam.toUpperCase())//chained operation filter map->
          .sorted()//another chained operation
          .collect(Collectors.toList());

   //Print the results

         result.forEach(r-> System.out.println(r));

          //Perform the chained operation in the strem


        System.out.println("Paraller Stram output:");

         iteams.parallelStream().forEach(iteam-> System.out.println(Thread.currentThread().getName()+"_"+iteam));

    }
}  //Paraller processing

