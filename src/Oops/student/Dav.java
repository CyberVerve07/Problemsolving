package oops.student;

/**
 * Dav — Student class demonstrating Object creation, Constructors, and Access Modifiers.
 *
 * INTERVIEW DEFINITION — Class and Object:
 * -------------------------------------------
 * Q: What is a Class?
 * A: A class is a BLUEPRINT/TEMPLATE that defines the properties (fields) and
 *    behaviors (methods) of an object. It does NOT occupy memory until an object is created.
 *    Think of it like an architectural blueprint for a house.
 *
 * Q: What is an Object?
 * A: An object is an INSTANCE of a class — it is a real entity that occupies memory.
 *    Created using the 'new' keyword: Dav student = new Dav();
 *    Think of it like the actual house built from the blueprint.
 *
 * INTERVIEW DEFINITION — Constructors:
 * ----------------------------------------
 * Q: What is a Constructor?
 * A: A special method that is called AUTOMATICALLY when an object is created.
 *    Rules:
 *    - Same name as the class.
 *    - NO return type (not even void).
 *    - Called only ONCE per object creation.
 *    Types:
 *    1. DEFAULT Constructor — no parameters, auto-provided if no constructor defined.
 *    2. PARAMETERIZED Constructor — takes parameters to initialize fields.
 *    3. COPY Constructor — takes another object of same class as parameter.
 *
 * INTERVIEW DEFINITION — Access Modifiers:
 * -------------------------------------------
 * Q: What are Access Modifiers?
 * A: Keywords that control the visibility/scope of classes, methods, and fields:
 *    - private: ONLY within this class.
 *    - default (no keyword): Within this PACKAGE only.
 *    - protected: Within this package + subclasses in other packages.
 *    - public: Accessible from EVERYWHERE.
 *
 * BUG FIX: Parameterized constructor was NOT assigning 'gf' field — now fixed.
 *
 * JAVA TYPE: class (POJO)
 * OOP PILLAR: Encapsulation (private fields, getters/setters)
 *
 * @author Aditya
 * @version 2.0
 */
public class Dav {

    /** Public fields — accessible from any class (used for learning; in production, make private) */
    public String name;
    public int age;
    public int rollNo;

    /** Private field — only accessible within this class (Encapsulation/Data Hiding) */
    private String gf;

    // ======================== GETTERS & SETTERS ========================

    /**
     * Getter for name.
     *
     * @return String — student's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for private field 'gf'.
     *
     * @return String — the gf value
     */
    public String getGf() {
        return gf;
    }

    /**
     * Setter for private field 'gf'.
     *
     * @param gf String — the value to set
     */
    public void setGf(String gf) {
        this.gf = gf;
    }

    // ======================== CONSTRUCTORS ========================

    /**
     * Default (no-arg) Constructor.
     * Called when: new Dav()
     */
    public Dav() {
        System.out.println("Constructor is called.");
    }

    /**
     * Parameterized Constructor — initializes student with all fields.
     *
     * BUG FIX: 'gf' parameter was accepted but NEVER assigned — now properly assigned.
     * Previous code: this.gf was missing → gf would always be null.
     *
     * @param name   String — student's name
     * @param age    int — student's age
     * @param rollNo int — student's roll number
     * @param gf     String — value for gf field
     */
    public Dav(String name, int age, int rollNo, String gf) {
        this.name = name;
        this.age = age;
        this.rollNo = rollNo;
        this.gf = gf; // BUG FIX: Was missing — gf was never assigned!
    }

    // ======================== METHODS ========================

    /**
     * Student is studying.
     */
    void study() {
        System.out.println(name + " is studying.");
    }

    /**
     * Student is sleeping.
     */
    void sleep() {
        System.out.println(name + " is sleeping.");
    }

    /**
     * Student is bunking class.
     */
    void bunk() {
        System.out.println(name + " is bunking class.");
    }

    /**
     * Student is eating lunch.
     */
    void lunch() {
        System.out.println(name + " is eating lunch.");
    }

    /**
     * Private method — only accessible within this class.
     *
     * INTERVIEW: Can we call private methods from outside?
     * → NO! Private methods are ONLY accessible within the same class.
     * → This is DATA HIDING — internal behavior hidden from outside.
     */
    private void gfChatting() {
        System.out.println(name + " is chatting.");
    }
}
