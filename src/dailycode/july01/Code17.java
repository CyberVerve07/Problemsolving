package dailycode.july01;

public class Code17 {
    //Problem Statement
    //Write a Java program to:
    //Create two String variables using literals.
    //Print both Strings.
    //Print the length of both Strings.
    //Convert the first String to uppercase.
    //Convert the second String to lowercase.
    //Concatenate both Strings with a space.
    //Print the final String.
    public static void Main(String[] args) {
        String name1="Aditya";
        String name2="Ram";
        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name1.length());
        System.out.println(name2.length());
        System.out.println(name1.toUpperCase());
        System.out.println(name2.toLowerCase());

         String finalName=name1.concat("Gupta");
        System.out.println(finalName);
        String finalName2=name2.concat("Bhagwan");
        System.out.println(finalName2);

    }
}
