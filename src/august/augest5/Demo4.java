package august.augest5;

public class Demo4 {
    public static void main(String[] args) {

        try {

               //In Java, Class.forName() is a static method used to dynamically load, link, and initialize a class
            // at runtime by providing its fully qualified string name.
            // It returns a Class object descriptor
            // corresponding to that loaded class, which serves as the
            // foundational entry point for Java Reflection

            Class.forName("august.augest5.Demo");  //File name is found not Exception is handled
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println("Program Closed ");
        }


    }
}
