package Exceptions;

public class Demo3 {
    //Classnotfound exception is a checked exception which occurs when we try to load a class which is not found in the classpath.
    public static void main(String[] args) {
        try {
            Class.forName("com.example.NonExistentClass");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Class not found.");
        }
    }
}
