package Exceptions;

public class Demo7 {
    //Claascast exception is a runtime exception which occurs when we try to cast an object to a subclass of which it is not an instance.
    public static void main(String[] args) {
        Object obj = new Integer(10);
        try {
            String str = (String) obj; // This will throw ClassCastException
        } catch (ClassCastException e) {
            System.out.println("Error: " + e.getMessage());
        }
        }
}
