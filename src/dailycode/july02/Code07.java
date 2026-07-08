package dailycode.july02;

public class Code07 {
    //Write a Java program that demonstrates String Pool and Heap Memory.
    //
    //Requirements:
    //
    //Create two Strings using literals.
    //Create two Strings using new String().
    //Concatenate another String using concat().
    //Compare both literal Strings using ==.
    //Compare both object Strings using ==.
    //Compare both object Strings using equalsIgnoreCase().
    public static void main(String[] args) {


        String name = "Sita";               //Create two s
        String name2 = "Ram";


        String s1 = new String(" Ram");
        String s2 = new String("Ram");

        String secondName = name.concat(" Laxmi maa");
        String getSecondName2 = name2.concat(" Shree Hari");
        System.out.println(secondName);
        System.out.println(getSecondName2);


        System.out.println(name==name2);
        System.out.println(secondName==getSecondName2);
        System.out.println(s1==s2);
        System.out.println(s1.equalsIgnoreCase(s2));


    }

}
