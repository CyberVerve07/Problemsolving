package august.august2;

// Address class to demonstrate deep cloning vs shallow cloning
class Address implements Cloneable {
    String city;
    String state;

    public Address(String city, String state) {
        this.city = city;
        this.state = state;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // Shallow clone of Address
    }

    @Override
    public String toString() {
        return city + ", " + state;
    }
}

// Person class implementing marker interface Cloneable
class Person implements Cloneable {
    String name;
    int age;
    Address address;

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // Shallow Copy implementation
    public Person shallowClone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }

    // Deep Copy implementation
    public Person deepClone() throws CloneNotSupportedException {
        Person clonedPerson = (Person) super.clone();
        // Manually clone referenced mutable objects for deep copy
        clonedPerson.address = (Address) this.address.clone();
        return clonedPerson;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", address=" + address + "}";
    }
}

public class CloneableDemo {
    public static void main(String[] args) {
        System.out.println("=== MARKER INTERFACE: CLONEABLE DEMO ===");
        try {
            Address addr = new Address("Delhi", "Delhi");
            Person p1 = new Person("Rahul", 22, addr);

            System.out.println("Original Person (p1): " + p1);

            // 1. Shallow Copy Demo
            Person p2 = p1.shallowClone();
            System.out.println("\n--- Shallow Copy Created (p2) ---");
            p2.name = "Amit";
            p2.address.city = "Mumbai"; // Modifying nested object in shallow copy affects original!

            System.out.println("After modifying p2:");
            System.out.println("p1 (Original): " + p1);
            System.out.println("p2 (Shallow Clone): " + p2);

            // 2. Deep Copy Demo
            Address addr2 = new Address("Jaipur", "Rajasthan");
            Person p3 = new Person("Vikas", 25, addr2);
            Person p4 = p3.deepClone();

            System.out.println("\n--- Deep Copy Created (p4) ---");
            p4.address.city = "Udaipur"; // Modifying nested object in deep copy does NOT affect original!

            System.out.println("After modifying p4:");
            System.out.println("p3 (Original): " + p3);
            System.out.println("p4 (Deep Clone): " + p4);

        } catch (CloneNotSupportedException e) {
            System.err.println("Cloning not supported: " + e.getMessage());
        }
    }
}
