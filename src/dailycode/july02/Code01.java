package dailycode.july02;

public class Code01 {
    public static void main(String[] args) {
        String name="Aditya";
        String fatherName="Anil";
      String surName=  name.concat(" Gupta");// Litters.. Stores in SCP,
      String surName2= fatherName.concat(" Gupta"); //Result of concat is going to heap :
        System.out.println(surName);
        System.out.println(surName2);


        // Create new String obj:
        String a=new String("Banglore"); //3 object:
        String a1=new String("Banglore");
        System.out.println(a==a1);
        System.out.println(a.equalsIgnoreCase(a1));//Compare obj memory address:


    }
}
