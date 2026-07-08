package dailycode.july02;

 //Write a Java program to study different String creation techniques and comparison methods.
 //
 //Perform the following operations:
 //Create two Strings using literals.
 //Append " Gupta" using concat().
 //Print the modified Strings.
 //Create two Strings using new String().
 //Compare them using ==.
 //Compare them using equalsIgnoreCase().
public class Code04 {
    public static void main(String[] args) {
        String city1="Delhi";
        String city2="Himachal";
        System.out.println(city1);
        System.out.println(city2);

         String country1=city1.concat(" India");
         String country2=city2.concat(" India");

        System.out.println(country1);
        System.out.println(country2);
        //New String::
        String s1=new String("Hello");
        String s2=new String("World");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1==s2);
        System.out.println(s1.equalsIgnoreCase(s2));



    }
}
