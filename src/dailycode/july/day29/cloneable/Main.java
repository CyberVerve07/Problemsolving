package dailycode.july.day29.cloneable;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
//Employee e2 = e1.clone();
        Student student=new Student();
          Object student1=student.clone();
student.name="Aditya";
student.rollno="62";

        System.out.println(student.name);
        System.out.println(student.rollno);


    }
}
