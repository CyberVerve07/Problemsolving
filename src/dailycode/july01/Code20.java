package dailycode.july01;

 //Demonstrate String Immutability
//Problem Statement
//
//Create a String
//
//Backend
//
//Perform
//
//concat(" Developer")
//
//Store the result in another variable.
//
//Print
//
//Original String
//Modified String


public class Code20 {
    public static void Main(String[] args) {
        String name="Backend";
        System.out.println(name);
        String fullName=name.concat("Devolper");
        System.out.println(fullName);

    }

}
