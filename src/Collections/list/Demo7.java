package Collections.list;
//List is an interface in Java's Collection Framework that represents an ordered collection of elements.
// It allows duplicate elements and provides index-based access.
import java.util.ArrayList;

public class Demo7{
    public static void main(String[] args) {
        //Collection List is allow duplicate and ordered :
        //Under list we have array list and linked list :


          //Create a collection obj(Creating which will store the employee name)

        ArrayList<String> employeeName=new ArrayList<>();
        //List is maintain the insertion Order
          employeeName.add("Aditya");
          employeeName.add("Kartik");
          employeeName.add("Ashish");
          employeeName.add("Ashish");
          employeeName.add("Aditya");
          employeeName.add("Harsh");
        System.out.println(employeeName);
        employeeName.remove(3);
        employeeName.remove(4);
        employeeName.get(2); //Read the element
        System.out.println(employeeName);  //Remove the duplicate element



 //Collection framework is a set of classes and interfaces that provide the in build data structure,
        // and we can store ,manipulate or implement the data easily

        //list is allow to maintain the order as well as achieve duplicate
        //List have two types Arraylist and linked list::::::::

         //List have many inbuild methods like add,remove,sort,clone,set,get etc comes under  java.util package

        //List is used to
//maintaining order as well as duplicate

    }

}

  //The java.util package is one of Java's most essential built-in packages, containing the Java Collections Framework,
// date and time facilities, internationalization support, and miscellaneous utility classes. Unlike java.lang,
// it must be explicitly imported using import java.util.*; or by targeting specific classes.
