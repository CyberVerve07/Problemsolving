package august.augest6;
import java.io.*;

public class Demo1 {
    public static void main(String[] args) throws IOException {
//Try with Resources :
        //Autoable
        try (ObjectInputStream obb = new ObjectInputStream(new FileInputStream("august augest6 Demo1" ));) {

        } catch (FileNotFoundException f) {
            System.out.println("File is not Found :");
        } catch (IOException a) {

        }

    }

    public static class Demo3 {

        public static void main(String[] args) {

            try {

                System.out.println("1");

                String s = null;

                s.length();

            }
            catch (NullPointerException e){

                System.out.println("2");

            }
            finally{

                System.out.println("3");

            }

            System.out.println("4");

        }

    }
}

//The try-with-resources statement in Java is an exception handling mechanism that automatically
// closes resources
// (like files, streams, or database connections) when the try block finishes.