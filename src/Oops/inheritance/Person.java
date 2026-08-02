package oops.inheritance;

/**
 * Person â€” Parent class demonstrating Inheritance and Encapsulation.
 *
 * INTERVIEW DEFINITION â€” Inheritance:
 * --------------------------------------
 * Q: What is Inheritance?
 * A: Inheritance is an OOP mechanism where a child class (subclass) acquires all the
 *    properties (fields) and behaviors (methods) of a parent class (superclass).
 *    It represents an IS-A relationship (Employee IS-A Person).
 *    Achieved using the 'extends' keyword.
 *
 * Q: Types of Inheritance in Java?
 * A: 1. SINGLE Inheritance     â†’ Employee extends Person (one parent, one child).
 *    2. MULTILEVEL Inheritance â†’ A â†’ B â†’ C (grandchild inherits from grandparent).
 *    3. HIERARCHICAL Inheritance â†’ Person â†’ Employee, Person â†’ Student (one parent, many children).
 *    4. MULTIPLE Inheritance   â†’ NOT supported with classes (Diamond Problem).
 *       â†’ Achieved through INTERFACES (a class can implement multiple interfaces).
 *    5. HYBRID Inheritance     â†’ Combination of above, supported via interfaces.
 *
 * Q: Why does Java NOT support Multiple Inheritance with classes?
 * A: Due to the DIAMOND PROBLEM â€” if two parent classes have the same method,
 *    Java cannot decide which one to call â†’ ambiguity â†’ compile error.
 *    Solution: Use INTERFACES (Java 8+ default methods handle this).
 *
 * JAVA TYPE: class (parent/super class)
 * OOP PILLAR: Inheritance + Encapsulation
 *
 * @author Aditya
 * @version 2.0
 * @see Employee
 */
public class Person {

    /**
     * ENCAPSULATION: Fields are private â€” protected from direct access.
     */
    private String name;
    private int age;

    /**
     * Default (no-arg) Constructor.
     *
     * INTERVIEW: Why do we need a default constructor?
     * â†’ If we define a parameterized constructor, Java does NOT auto-provide a default one.
     * â†’ If child class calls super() without arguments, parent must have a no-arg constructor.
     */
    public Person() {
    }

    /**
     * Parameterized Constructor â€” initializes Person with name and age.
     *
     * INTERVIEW: What is 'this' keyword?
     * â†’ 'this' refers to the CURRENT object instance.
     * â†’ Used to distinguish between parameter and instance variable with same name.
     * â†’ this.name = name; â†’ assigns the parameter 'name' to the instance variable 'name'.
     *
     * @param name String â€” person's name
     * @param age  int â€” person's age
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // ======================== GETTERS & SETTERS ========================

    /** @return String â€” the person's name */
    public String getName() {
        return name;
    }

    /** @param name String â€” the name to set */
    public void setName(String name) {
        this.name = name;
    }

    /** @return int â€” the person's age */
    public int getAge() {
        return age;
    }

    /**
     * Setter with VALIDATION â€” age must be positive.
     *
     * @param age int â€” the age to set (must be > 0)
     */
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Age cannot be negative or zero!");
        }
    }

    /**
     * Displays person's details.
     */
    public void displayPerson() {
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
    }
}
