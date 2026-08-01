package dailycode.july.day29;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Readresult {

    public static void main(String[] args)
            throws IOException, ClassNotFoundException {

        // Read the file
        ObjectInputStream ois =
                new ObjectInputStream(
                        new FileInputStream("Result src"));

        // Convert bytes back into object
        Student student = (Student) ois.readObject();

        // Close stream
        ois.close();

        // Print object
        System.out.println(student);
        System.out.println(student.getName());
        System.out.println(student.getMarks());
        System.out.println(student.getRollNo());
    }
}