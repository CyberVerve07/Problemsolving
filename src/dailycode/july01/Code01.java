package dailycode.july01;

import java.util.Locale;

public class Code01 {
    public static void Main(String[] args) {
        //String is a non_primat.. ds that are used to print combination of multiple characters
        //String is also a class in java
        //There are two ways to crete the object of string in java using new :: and using literals
        //String are immutable???-> Once obj is created we can not change::
        String name="Aditya";
        String address="Himachal";
        String name2="Ram";
        String address2="Himachal";
        String name3="Krishna";
        String name4 ="Radha";

        //
        //  print using multiple methods
        System.out.println(name==name2);
        System.out.println(address==address2);
        System.out.println(name.length());
        System.out.println(name2.toUpperCase());
        System.out.println(address.length());
        System.out.println(name3.toLowerCase());
        System.out.println(name4.length());
        //Any modification to a string results in a new object
       String fullAddress= address.concat(" Pradesh");
        System.out.println(fullAddress);


    }
}
