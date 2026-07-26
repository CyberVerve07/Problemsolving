package oops.student;

/**
 * UseStudent3 — Creates a third Dav student object.
 *
 * NAMING FIX: Variable 'Student3' → 'student3' (camelCase convention).
 *
 * @author Aditya
 * @version 2.0
 * @see Dav
 */
public class UseStudent3 {

    public static void main(String[] args) {
        // NAMING FIX: Variable renamed from 'Student3' to 'student3' (camelCase)
        Dav student3 = new Dav();
        student3.name = "Harsh";
        student3.age = 19;
        student3.rollNo = 6;

        // Print values
        System.out.println("The name of the student is: " + student3.name);
        System.out.println("The age of the student is: " + student3.age);
        System.out.println("The roll no of the student is: " + student3.rollNo);

        // Method calls
        student3.study();
        student3.sleep();
        student3.bunk();
    }
}
