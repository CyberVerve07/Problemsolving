package august.augest8;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Demo9d {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // File se data read karne ke liye
        ObjectInputStream obj = new ObjectInputStream(new FileInputStream("Src.Demo9"));

        // File ke andar se object wapas nikalo
        Demo9 demo9 = (Demo9) obj.readObject();

        // Object ko use karo
        demo9.printDetails();

        obj.close();

        System.out.println("Deserialization is done");
    }
}
