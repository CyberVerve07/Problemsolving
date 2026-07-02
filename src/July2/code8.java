package July2;

public class code8 {
    //Write a Java program to demonstrate String immutability.
    //
    //Requirements:
    //
    //Create a String using a literal.
    //Concatenate another word using concat().
    //Store the result in a new variable.
    //Print both variables.
    //Explain why the original String remains unchanged.
    public static void main(String[] args){
     String name="Aditya";
        System.out.println(name);
        String newName=name.concat(" Gupta");
        System.out.println(newName);
        //Because string is immutable in java we can't change original string in java we need a new obj to modify it





    }
}