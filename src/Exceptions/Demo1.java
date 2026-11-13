package Exceptions;

public class Demo1 {
    //In java null pointer exception is a runtime exception which occurs when we try to access the object which is not initialized or null.
    public static void main(String[] args) {
        String name = null;
        System.out.println(name.length());
    }
}
