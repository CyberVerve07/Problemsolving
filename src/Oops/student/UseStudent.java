//package oops.student;
//
///**
// * UseStudent — Creates a Dav (student) object and demonstrates field access + method calls.
// *
// * INTERVIEW: What is 'extends' here?
// * → UseStudent extends Dav — it INHERITS all non-private fields and methods.
// * → UseStudent IS-A Dav (student).
// * → In this context, 'extends' is used but the inheritance isn't actively utilized.
// *
// * @author Aditya
// * @version 2.0
// * @see Dav
// */
//public class UseStudent extends Dav {
//
//    public static void main(String[] args) {
//        // Create Dav object using default constructor
//        Dav student1 = new Dav();
//
//        // Set attributes directly (public fields)
//        student1.name = "Rahul";
//        student1.age = 20;
//        student1.rollNo = 101;
//
//        // Print student details
//        System.out.println("Name: " + student1.name);
//        System.out.println("Age: " + student1.age);
//        System.out.println("Roll No: " + student1.rollNo);
//
//        // Call methods
//        student1.study();
//        student1.sleep();
//        student1.bunk();
//
//        // hashCode() — inherited from Object class (root of all Java classes)
//        int hashCode = student1.hashCode();
//        System.out.println("HashCode: " + hashCode);
//    }
//}
