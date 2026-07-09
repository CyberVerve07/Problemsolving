package student;

public class UseStudent extends  Dav{
    public static void main(String[] args) {
        // Dav class ka object create kiya
        Dav student1 = new Dav();

        // Attributes set karo
        student1.name = "Rahul";
        student1.age = 20;
        student1.rollNo = 101;

        // Print karo
        System.out.println("Name: " + student1.name);
        System.out.println("Age: " + student1.age);
        System.out.println("Roll No: " + student1.rollNo);

        // Methods call karo
        student1.study();
        student1.sleep();
        student1.bunk();
        int i = student1.hashCode();
        System.out.println(i);
    }
}
