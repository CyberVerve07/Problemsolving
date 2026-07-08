package dailycode.july02;

public class Question6 {
    //Problem Statement
    //
    //Implement a Java program that demonstrates the difference between:
    //
    //String literals
    //String objects created using new
    //Reference comparison
    //Content comparison
    //
    //The program should print:
    //
    //The concatenated Strings.
    //The result of ==.
    //The result of equalsIgnoreCase().
    public static void main(String[] args) {
        String name1="Aditya";
        String name2="Ram ji ko ";
        String surName=name1.concat(" Gupta");
        String surName2=name2.concat(" Dannd vat Parnamm");
        System.out.println(surName);
        System.out.println(surName2);
        //
        String s1=new String("Jai Shree Ram");
        String s2=new String(" Jai Shree hari vansh");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(surName==surName2);
        System.out.println(surName.equalsIgnoreCase(surName2));
        System.out.println(s1==s2);
        System.out.println(s1.equalsIgnoreCase(s2));

    }
}
