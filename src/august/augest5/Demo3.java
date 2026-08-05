package august.augest5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;




public class Demo3 {
    public static void main(String[] args) {

        try {
            ObjectOutputStream obb = new ObjectOutputStream(new FileOutputStream("txt.java"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Exception is handled ");

    }
}


        //Checked exception is checked by the Compiler and gives the warning to this is the Series exception
    // All the exception is found and handel by the Runtime
 // But some series exception are found by the compiler and give the warning