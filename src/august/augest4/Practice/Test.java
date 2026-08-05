package august.augest4.Practice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Test {
    public static void main(String[] args) throws IOException {


          Sbi sbi=new Sbi("Aditya","73037073-7432",8308303,"BLR","830383-2383-");
        System.out.println(sbi.getAddress());
        System.out.println(sbi.getAccountId());
        System.out.println(sbi.getIfscCode());

          // for Read the obj
        ObjectOutputStream obb=new ObjectOutputStream(new FileOutputStream("src SBI"));

        //Implemet the
        obb.writeObject(sbi);
        obb.close();
        System.out.println("Serialization is done");


    }
}
