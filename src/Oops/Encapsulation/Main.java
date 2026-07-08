package Oops.Encapsulation;

public class Main {
    public static void main(String[] args) {   //Main method
        System.out.println("--- Encapsulation Demo ---");

        // Create Student object
        Student s = new Student();

        // Set values using Setters
        s.setName("Aditya");
        s.setAge(20);

        // Get values using Getters
        System.out.println("Name: " + s.getName());
        System.out.println("Age: " + s.getAge());

        // Trying to set invalid age
        System.out.println("\nTrying to set invalid age (-5)...");
        s.setAge(-5);
        System.out.println("Age after invalid set: " + s.getAge());
    }
}
