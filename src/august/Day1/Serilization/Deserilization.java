package august.Day1.Serilization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Deserilization {
    public static void main(String[] args) {

          try {
              ObjectOutputStream ois=new ObjectOutputStream(new FileOutputStream("src/student"));
          } catch (FileNotFoundException e) {



          } catch (IOException e) {
              throw new RuntimeException(e);
          }


    }
}
