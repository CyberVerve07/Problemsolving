package august.Day1.Serilization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Share {
    public static void main(String[] args) throws IOException {

          Employee employee=new Employee("Aditya",83,"BLR",70000);


           //used to write custom primitive datatype

        ObjectOutputStream oss=new ObjectOutputStream(new FileOutputStream("src Employee"));

         oss.writeObject(employee);
         oss.close();
        System.out.println("Serialization is done ");


    }
}
