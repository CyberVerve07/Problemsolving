package oops.inheritance;

/**
 * Person — Parent class demonstrating Inheritance and Encapsulation.
 *
 * INTERVIEW DEFINITION — Inheritance:
 * --------------------------------------
 * Q: What is Inheritance?
 * A: Inheritance is an OOP mechanism where a child class (subclass) acquires all the
 *    properties (fields) and behaviors (methods) of a parent class (superclass).
 *    It represents an IS-A relationship (Employee IS-A Person).
 *    Achieved using the 'extends' keyword.
 *
 * Q: Types of Inheritance in Java?
 * A: 1. SINGLE Inheritance     → Employee extends Person (one parent, one child).
 *    2. MULTILEVEL Inheritance → A → B → C (grandchild inherits from grandparent).
 *    3. HIERARCHICAL Inheritance → Person → Employee, Person → Student (one parent, many children).
 *    4. MULTIPLE Inheritance   → NOT supported with classes (Diamond Problem).
 *       → Achieved through INTERFACES (a class can implement multiple interfaces).
 *    5. HYBRID Inheritance     → Combination of above, supported via interfaces.
 *
 * Q: Why does Java NOT support Multiple Inheritance with classes?
 * A: Due to the DIAMOND PROBLEM — if two parent classes have the same method,
 *    Java cannot decide which one to call → ambiguity → compile error.
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
     * ENCAPSULATION: Fields are private — protected from direct access.
     */
    private String name;
    private int age;

    /**
     * Default (no-arg) Constructor.
     *
     * INTERVIEW: Why do we need a default constructor?
     * → If we define a parameterized constructor, Java does NOT auto-provide a default one.
     * → If child class calls super() without arguments, parent must have a no-arg constructor.
     */
    public Person() {
    }

    /**
     * Parameterized Constructor — initializes Person with name and age.
     *
     * INTERVIEW: What is 'this' keyword?
     * → 'this' refers to the CURRENT object instance.
     * → Used to distinguish between parameter and instance variable with same name.
     * → this.name = name; → assigns the parameter 'name' to the instance variable 'name'.
     *
     * @param name String — person's name
     * @param age  int — person's age
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // ======================== GETTERS & SETTERS ========================

    /** @return String — the person's name */
    public String getName() {
        return name;
    }

    /** @param name String — the name to set */
    public void setName(String name) {
        this.name = name;
    }

    /** @return int — the person's age */
    public int getAge() {
        return age;
    }

    /**
     * Setter with VALIDATION — age must be positive.
     *
     * @param age int — the age to set (must be > 0)
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
