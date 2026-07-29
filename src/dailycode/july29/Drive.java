package dailycode.july29;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Drive {
    //Serilization is the process of converting the object into the bytestrweam and save it into ram, file,db,
    //or share it by using internet it is a marker inteface ::


    public static void main(String[] args) throws IOException {

        Account account = new Account(
                "Aditya",
                "838230983",
                50000,
                "BLR"
        );

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Aditya.ser"));

        oos.writeObject(account);

        oos.close();

        System.out.println("Serialization Done.");
    }
}