package revise;

//package revise;
//
///*
// * ============================================================
// *  TOPIC: UPCASTING
// * ============================================================
// *
// *  DEFINITION (Interview Answer):
// *  Upcasting is the process of assigning a child class (subclass)
// *  object reference to a parent class (superclass) reference variable.
// *  It is done IMPLICITLY (automatically) by Java compiler.
// *
// *  WHY WE USE IT IN JAVA:
// *  1. Achieves POLYMORPHISM Ã¢â‚¬â€ parent ref can hold any child object.
// *  2. Allows writing GENERIC code that works with multiple types.
// *  3. Used heavily in COLLECTIONS, method parameters, and APIs.
// *  4. Enables RUNTIME METHOD DISPATCH (dynamic method binding).
// *
// *  KEY POINTS:
// *  - Always SAFE (no ClassCastException risk).
// *  - Done automatically; no explicit cast needed.
// *  - After upcasting, you can ONLY call methods of parent class
// *    (child-specific methods are hidden unless overridden).
// *  - Overridden methods of CHILD are still called (runtime polymorphism).
// *
// *  REAL WORLD ANALOGY:
// *  A Dog IS-A Animal. So you can say: Animal a = new Dog();
// *  You're treating Dog as a generic Animal.
// * ============================================================
// */
//
//class Animal {
//    String name = "Animal";
//
//    void sound() {
//        System.out.println("Animal makes a sound");
//    }
//
//    void breathe() {
//        System.out.println("Animal breathes");
//    }
//}
//
//class Dog extends Animal {
//    String name = "Dog"; // field hiding (NOT overriding)
//
//    public Dog(String buddy) {
//
//    }
//
//    @Override
//    void sound() {
//        // Overridden method Ã¢â‚¬â€ will be called even after upcasting
//        System.out.println("Dog barks: Woof Woof!");
//    }
//
//    void fetch() {
//        // Child-specific method Ã¢â‚¬â€ NOT accessible via parent reference
//        System.out.println("Dog fetches the ball");
//    }
//}
//
//public class R1_UpCasting {
//    public static void main(String[] args) {
//
//        System.out.println("========== UPCASTING DEMO ==========\n");
//
//        // --- Normal (No Upcasting) ---
//        Dog dog = new Dog();
//        System.out.println("Without Upcasting:");
//        dog.sound();    // Dog barks
//        dog.fetch();    // Dog-specific method
//        System.out.println("Name field: " + dog.name); // "Dog"
//
//        System.out.println();
//
//        // --- UPCASTING: parent ref = child object ---
//        // No explicit cast needed Ã¢â‚¬â€ Java does it automatically
//        Animal animal = new Dog(); // <-- UPCASTING
//
//        System.out.println("With Upcasting (Animal ref = new Dog()):");
//
//        // Runtime Polymorphism: overridden method of DOG is called
//        animal.sound();    // Output: Dog barks (NOT Animal makes a sound)
//
//        // Parent method Ã¢â‚¬â€ accessible
//        animal.breathe();  // Output: Animal breathes
//
//        // Field is NOT polymorphic Ã¢â‚¬â€ parent field is accessed
//        System.out.println("Name field: " + animal.name); // "Animal" (field hiding)
//
//        // animal.fetch(); // COMPILE ERROR Ã¢â‚¬â€ fetch() not in Animal class
//
//        System.out.println();
//
//        // --- PRACTICAL USE: Generic method (power of upcasting) ---
//        System.out.println("Practical Use Ã¢â‚¬â€ Generic Method:");
//        makeSound(new Dog());    // Can pass any Animal subclass
//        makeSound(new Animal()); // Works for Animal too
//
//        System.out.println("\n=====================================");
//    }
//
//    // This method accepts ANY Animal or its subclass Ã¢â‚¬â€ thanks to upcasting
//    static void makeSound(Animal a) {
//        a.sound(); // Calls the appropriate overridden version at runtime
//    }
//}

