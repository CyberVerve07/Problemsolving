package July2;

public class code3 {
    //rite a Java program to demonstrate the following String concepts:
    //
    //String Literal
    //String Pool
    //Heap Memory
    //concat()
    //new String()
    //==
    //equalsIgnoreCase()
    //
    //Your program should:
    //
    //Create Strings using literals.
    //Create Strings using the new keyword.
    //Concatenate a surname.
    //Compare object references.
    //Compare String content ignoring case.
    public static void main(String[] args) {
        String name="Aditya";
        String s1=new String("Anil");
        System.out.println(name);
        System.out.println(s1);

         String sname=name.concat(" Gupta");
         String s2=s1.concat(" Gupta");
        System.out.println(sname);
        System.out.println(s2);
        System.out.println(s1==s2);
        System.out.println(name.equalsIgnoreCase(s1));






    }
}
