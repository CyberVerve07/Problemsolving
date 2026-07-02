package July2;

public class code5 {
    //Problem Statement
    //
    //You are given two names.
    //
    //Perform the following tasks:
    //
    //Append a surname using concat().
    //Print the new names.
    //Create two String objects using the new keyword containing the same text.
    //Check whether both objects refer to the same memory location.
    //Check whether both objects contain the same text (case-insensitive).
    public static void main(String[] args) {

        String name1="Aditya";
        String name2="Radha";


         String surName1=name1.concat(" Gupta");
         String surName2=name2.concat(" Radha");
        System.out.println(surName1);
        System.out.println(surName2);

          String s1=new String("Java");
          String s2=new String("Java");
        System.out.println(s1==s2);
        System.out.println(s1.equalsIgnoreCase(s2));

    }
}
