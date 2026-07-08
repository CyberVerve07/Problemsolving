package Oops.Encapsulation;

// Class student ::
public class Student {
    // 1. Private variables: Bs class ka andar honge acess ::
    private String name;
    private int age;

    // 2. Getter for Name
    public String getName()
    {
        return name;
    }

    // Setter for Name
    public void setName(String name)
    {
        this.name = name;
    }

    // Getter for Age ,age get ka liya
    public int getAge() {

        return age;
    }

    // Setter for Age (agar age 0 h to age can not be negative show kra ga
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Age cannot be negative or zero!");
        }
    }
}
