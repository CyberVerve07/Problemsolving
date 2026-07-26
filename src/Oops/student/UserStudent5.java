package oops.student;

/**
 * UserStudent5 — Demonstrates setter usage for private field.
 *
 * NAMING FIX: Variable 'Student5' → 'student5' (camelCase convention).
 *
 * @author Aditya
 * @version 2.0
 * @see Dav
 */
public class UserStudent5 extends Dav {

    public static void main(String[] args) {
        // NAMING FIX: Variable renamed from 'Student5' to 'student5' (camelCase)
        Dav student5 = new Dav("Aditya", 15, 67, "Riya");

        // Using setter to modify private field — Encapsulation in action
        student5.setGf("Prachi");
        System.out.println("Updated successfully via setter.");
    }
}
