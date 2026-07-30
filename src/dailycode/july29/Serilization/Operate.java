package dailycode.july29.Serilization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Operate {
    public static void main(String[] args) throws  IOException {

        Hdfc hdfc=new Hdfc("123456789", "Darian ", 1000.0, "Savings");


        //Write the operation
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("src/dailycode/july29/Serilization/hdfc.txt"));
        oos.writeObject(hdfc);
        oos.close();
        System.out.println("Object serialized successfully.");

    }
}
