package august;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class UcoSerilize {


    public static void main(String[] args) throws IOException {
        UcoBank ucoBank=new UcoBank("Aditya","Shahpur Branch","Near shahpur Ground","Kangra",900000);


        //Creating the serialization:

        ObjectOutputStream obb=new ObjectOutputStream(new FileOutputStream("src UcoBank"));

        //Now assign

         obb.writeObject(ucoBank);
         obb.close();
        System.out.println("Serialization is done na  ");





    }





}
