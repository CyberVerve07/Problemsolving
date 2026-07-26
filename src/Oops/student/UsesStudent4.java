package oops.student;

/**
 * UsesStudent4 — Demonstrates Parameterized Constructor usage.
 *
 * NAMING FIX: Variable 'Student4' → 'student4' (camelCase convention).
 *
 * @author Aditya
 * @version 2.0
 * @see Dav
 */
public class UsesStudent4 {

    public static void main(String[] args) {
        // Using parameterized constructor — all fields initialized at creation
        // NAMING FIX: Variable renamed from 'Student4' to 'student4' (camelCase)
        Dav student4 = new Dav("Abhishek", 30, 44, "Prachi");

        student4.study();
        student4.lunch();
        System.out.println("Name: " + student4.getName());
    }
}
