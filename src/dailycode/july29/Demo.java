package dailycode.july29;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Demo {
    public static void main(String[] args) throws IOException{

        //Create the object of the Class
        Order order=new Order("830983-03221","I phone 17",83000);


        //Write the data into the Streams
        ObjectOutputStream obb=new ObjectOutputStream(new FileOutputStream("Order src"));

            //how to Serialized using the writeObject
        obb.writeObject(order);
        obb.close();
        System.out.println("Serialization is done ? : ");

    }
}
