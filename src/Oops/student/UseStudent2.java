package oops.student;

/**
 * UseStudent2 — Creates a second Dav student object.
 *
 * NAMING FIX: Variable 'Student2' → 'student2' (camelCase convention).
 * → Java variable names MUST start with lowercase letter (camelCase).
 * → Uppercase starting letter is reserved for CLASS NAMES (PascalCase).
 *
 * @author Aditya
 * @version 2.0
 * @see Dav
 */
public class UseStudent2 extends Dav {

    public static void main(String[] args) {
        // NAMING FIX: Variable renamed from 'Student2' to 'student2' (camelCase)
        Dav student2 = new Dav();
        student2.name = "Ashish";
        student2.age = 24;
        student2.rollNo = 20;

        // Print the data
        System.out.println("The student name is: " + student2.name);
        System.out.println("Student age is: " + student2.age);
        System.out.println("Student roll no is: " + student2.rollNo);

        // Method calls
        student2.study();
        student2.bunk();
        student2.sleep();
    }
}
