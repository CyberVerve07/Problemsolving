package dailycode.july01;

public class Code23 {
    //Write a Java program that demonstrates all the following String concep
    public static void Main(String[] args) {
        String name = "Aditya";
        String name2 = "Ram";
        String name3 = "Golu";
        String name4 = "Madhav";
        System.out.println(name);
        System.out.println(name2);
        System.out.println(name3);
        System.out.println(name4);

        System.out.println(name==name2);
        System.out.println(name3==name4)
        ;
        System.out.println(name.length());

        System.out.println(name2.length());
        System.out.println(name3.length());
        System.out.println(name4.toUpperCase());
        System.out.println(name3.toLowerCase());
        System.out.println(name.toLowerCase());


          String fullName=name.concat(" Gupta");
        System.out.println(fullName);
        String fullName2=name2.concat(" JI");
        System.out.println(fullName2);
        String fullNAme3=name.concat("Brothe");
        System.out.println(fullNAme3);
        String fullName4=name.concat((" Shyam"));
        System.out.println(fullName4);

    }
}