package august.augest8;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class UcoTest {
    public static void main(String[] args) throws IOException {
        UcoBank ucoBank=new UcoBank("Prachi","4873037234","BLR",40000,
                "prachi@1323gmail.com","32038shdu38id");

         ucoBank.getUSerDetails();

   //Serialization

        ObjectOutputStream obb=new ObjectOutputStream(new FileOutputStream("Src UCOBank"));

 //Serialization

        obb.writeObject(ucoBank);
        obb.close();
        System.out.println("Serialization is Done ");





    }
}
