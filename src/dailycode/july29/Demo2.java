package dailycode.july29;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Demo2 {

    public static void main(String[] args)
            throws IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Order src"));

        Order order = (Order) ois.readObject();

        ois.close();

        System.out.println(order);

    }
}
