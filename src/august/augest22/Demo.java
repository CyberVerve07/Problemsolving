package august.augest22;

class Student {
    int marks;

    Student(int marks) {
        marks = marks;
    }
}

public class Demo {
    public static void main(String[] args) {
        Student s = new Student(90);
        System.out.println(s.marks);
    }
}