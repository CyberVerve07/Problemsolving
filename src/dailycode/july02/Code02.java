package dailycode.july02;

public class Code02 {
    public static void main(String[] args) {
//        Write a Java program to demonstrate different ways of creating String objects.
//
//        Requirements:
//
//        Create two Strings using String literals.
//        Concatenate " Gupta" with both Strings using the concat() method.
//                Print the concatenated Strings.
//                Create two more Strings using the new keyword.
//                Compare them using:
//==
//        equalsIgnoreCase()
//        Print all the outputs.
        String name="Aditya";
        String name2="Siya";

          String surName=name.concat(" Gupta");
          String surName2=name2.concat(" Ram");
        System.out.println(surName);
        System.out.println(surName2);


          String s1=new String("Prachi");
          String s2=new String("Sharma");
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));


    }
}
