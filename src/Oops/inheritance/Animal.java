package oops.inheritance;

/**
 * Animal — Parent class for inheritance demo (Dog extends Animal).
 *
 * BUG FIX: Fields were 'public' — changed to 'private' with proper getters/setters.
 * → Public fields break Encapsulation — anyone could do animal.name = null;
 *
 * INTERVIEW: What is the 'this' keyword?
 * → 'this' refers to the current object instance.
 * → this.name = name → distinguishes instance variable from parameter.
 *
 * JAVA TYPE: class (parent/super class)
 * OOP PILLAR: Inheritance + Encapsulation
 *
 * @author Aditya
 * @version 2.0
 * @see Dog
 */
public class Animal {

    /** BUG FIX: Changed from 'public' to 'private' for proper Encapsulation */
    private String name;
    private int age;

    /**
     * Default (no-arg) constructor.
     */
    Animal() {
    }

    /**
     * Parameterized constructor — initializes animal with name and age.
     *
     * @param name String — the animal's name
     * @param age  int — the animal's age
     */
    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // ======================== GETTERS & SETTERS ========================

    /** @return String — the animal's name */
    public String getName() {
        return name;
    }

    /** @param name String — the name to set */
    public void setName(String name) {
        this.name = name;
    }

    /** @return int — the animal's age */
    public int getAge() {
        return age;
    }

    /** @param age int — the age to set */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Displays the animal's eating behavior.
     */
    void eat() {
        System.out.println("Animal is eating food: " + name);
    }
}
