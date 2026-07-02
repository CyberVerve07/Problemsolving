package July2;

public class code11 {
    //Write a Java program that demonstrates the following String concepts in a single program:
    //
    //String Literal
    //String Pool
    //Heap Memory
    //String Immutability
    //concat()
    //new String()
    //==
    //equalsIgnoreCase()
    //
    //The program should also include comments explaining:
    //
    //Where each object is stored (Stack, Heap, or String Pool).
    //Why == and equalsIgnoreCase() produce different results.
    //Why concat() returns a new String instead of modifying the original one.
    public static void main(String[] args) {
        String name="Ram";
        String name2="Shyam";
        System.out.println(name);
        System.out.println(name2);

        String fullName=name.concat("Ram"); //WE use concant cause string is immmutable we caant modity it::
        String fullName2=name2.concat(" Mahva");
        System.out.println(fullName);
        System.out.println(fullName2);

          //New string
        String s1=new String(" Raj");
        String s2=new String("Kumar");
        System.out.println(s1==s2); //false diffren rference addres in heap
        System.out.println(name.equals(name2));
        System.out.println(name.equalsIgnoreCase(name2));
        System.out.println(s1.equalsIgnoreCase(s2));


    }
}
