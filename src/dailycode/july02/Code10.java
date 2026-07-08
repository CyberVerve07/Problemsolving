package dailycode.july02;

public class Code10 {
    //Implement a Java program to simulate a simple user profile.
    //
    //Requirements:
    //
    //Store first name and father's name using String literals.
    //Append a surname using concat().
    //Create another user using the new keyword.
    //Compare both users using:
    //==
    //equalsIgnoreCase()
    //
    //Print all results.
    public static void main(String[] args) {
        String firstName="Aditya";
        String fatherName="Anil";

         String surName=firstName.concat(" Gupta");
         String surname2=fatherName.concat(" Gupta");
        System.out.println(surName);
        System.out.println(surname2);

          String s1=new String(" Mohit");
          String s2=new String("Shohan");
        System.out.println(s1==s2);
        System.out.println(s1.equalsIgnoreCase(s2));
        System.out.println();

    }
}
