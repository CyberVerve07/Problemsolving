package Oops.Encapsulation;

// Simple class demonstrating Encapsulation
public class Student {
    // 1. Private variables: accessible only within this class
    private String name;
    private int age;

    // 2. Getter for Name
    public String getName() {
        return name;
    }

    // Setter for Name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for Age
    public int getAge() {
        return age;
    }

    // Setter for Age (with a simple check)
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Age cannot be negative or zero!");
        }
    }
}
