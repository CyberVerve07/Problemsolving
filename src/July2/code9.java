package July2;

public class code9 {
    public static void main(String[] args) {
        //Write a Java program to compare two String objects created using the new keyword.
        //
        //Your program should:
        //
        //Use ==.
        //Use equalsIgnoreCase().
        //Explain why both results are different.

        String name=new String("Aditya");
        String name2=new String( "Aditya");
        System.out.println(name==name2);
        System.out.println(name.equalsIgnoreCase(name2));// Because object are create in heap diffrent,diffrent locations:
        // and equal igo case comape the string value that we pass

    }
}
