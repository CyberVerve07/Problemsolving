package august.Day1.Serilization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) throws IOException {

        Student student=new Student("Aditya",62,"A");

          //Now Create a Serilization

        ObjectOutputStream  oss=new ObjectOutputStream(new FileOutputStream("src/student"));

          //Now  assign

         oss.writeObject(student);
         oss.close();
        System.out.println("Serialization is done na ");





    }
}
