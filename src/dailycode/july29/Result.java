package dailycode.july29;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Result {
    public static void main(String[] args)throws IOException{

        //Create the object
        Student student=new Student("Prachi","30",96);

        //Write
        ObjectOutputStream obb=new ObjectOutputStream(new FileOutputStream("Result src"));

        //Call by object

         obb.writeObject(student);
         obb.close();
        System.out.println("Done na ");


    }
}
