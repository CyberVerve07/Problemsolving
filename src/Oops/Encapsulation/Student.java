package oops.encapsulation;

/**
 * INTERVIEW DEFINITION — Encapsulation:
 * ----------------------------------------
 * Q: What is Encapsulation?
 * A: Encapsulation is the process of WRAPPING data (fields) and methods that operate on
 *    that data into a SINGLE UNIT (class), and RESTRICTING direct access to the data
 *    using 'private' access modifier. Data is accessed/modified ONLY through public
 *    getter and setter methods.
 *
 * Q: Why do we use Encapsulation?
 * A: 1. DATA HIDING — internal state is hidden from outside world.
 *    2. DATA PROTECTION — prevents unauthorized/accidental modification.
 *    3. VALIDATION — setters can validate data BEFORE storing (e.g., age > 0).
 *    4. FLEXIBILITY — internal implementation can change without affecting external code.
 *    5. MAINTAINABILITY — easier to debug and maintain.
 *
 * Q: How to achieve Encapsulation?
 * A: 1. Declare fields as PRIVATE.
 *    2. Provide PUBLIC getter methods (read access).
 *    3. Provide PUBLIC setter methods (write access + validation).
 *
 * Q: What is Data Hiding?
 * A: Data Hiding means making fields PRIVATE so they cannot be accessed directly.
 *    It is a SUBSET of Encapsulation. Encapsulation = Data Hiding + Controlled Access.
 *
 * JAVA TYPE: class (POJO demonstrating Encapsulation)
 * OOP PILLAR: Encapsulation
 *
 * @author Aditya
 * @version 2.0
 */
public class Student {

    /**
     * Private field — ONLY accessible within this class.
     *
     * INTERVIEW: Why 'private'?
     * → 'private' restricts access to WITHIN THIS CLASS only.
     * → No other class can do: student.name = "xyz"; (compile error!)
     * → Forces use of setName() which can have validation.
     */
    private String name;

    /**
     * Private field — age of the student.
     */
    private int age;

    // ======================== GETTERS ========================

    /**
     * Getter for 'name' — provides READ access to private field.
     *
     * INTERVIEW: What is a Getter?
     * → A public method that RETURNS the value of a private field.
     * → Convention: getFieldName() (e.g., getName(), getAge()).
     * → For boolean: isFieldName() (e.g., isActive()).
     *
     * @return String — the student's name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for 'age' — provides READ access.
     *
     * @return int — the student's age
     */
    public int getAge() {
        return age;
    }

    // ======================== SETTERS ========================

    /**
     * Setter for 'name' — provides controlled WRITE access.
     *
     * INTERVIEW: What is a Setter?
     * → A public method that SETS/UPDATES the value of a private field.
     * → Convention: setFieldName(Type value) (e.g., setName(String name)).
     * → Can include VALIDATION logic before storing the value.
     *
     * @param name String — the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for 'age' — with VALIDATION to prevent invalid data.
     *
     * INTERVIEW: Why validation in setter?
     * → This is the KEY BENEFIT of Encapsulation — we can CONTROL what values are stored.
     * → Without setter, someone could do: student.age = -5; (invalid!)
     * → With setter, we check: age must be positive before storing.
     *
     * @param age int — the age to set (must be greater than 0)
     */
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Age cannot be negative or zero!");
        }
    }
}
