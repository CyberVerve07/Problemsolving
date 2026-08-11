package august.augest8;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Demo9s {
    public static void main(String[] args) throws IOException {
         Demo9 demo9=new Demo9("Aditya","990323","BLR",75000,"adityamahajan7289@gmail.com");

         demo9.printDetails();


          //implementing the serialization

        ObjectOutputStream obj=new ObjectOutputStream(new FileOutputStream("Src.Demo9"));


         //write the obj
        obj.writeObject(demo9);

         obj.close();
        System.out.println("Serialization is done :");



    }
}
