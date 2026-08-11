package august.augest8;

public class Demo10 {
    public static void main(String[] args) {

         try {
             Class.forName("august.augest8.Demo10"); //Class.for name in java is used to
             // dynamically load or link a class
             ////In Java, Class.forName() is a static method used to dynamically load, link, and initialize a class
             //            // at runtime by providing its fully qualified string name.


         } catch (ClassNotFoundException e) {
             throw new RuntimeException(e);
         }
         finally {
             System.out.println("Program closed");
         }


    }
}
