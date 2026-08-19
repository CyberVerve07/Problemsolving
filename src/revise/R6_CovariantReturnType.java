package revise;

/*
 * ============================================================
 *  TOPIC: COVARIANT RETURN TYPE
 * ============================================================
 *
 *  DEFINITION (Interview Answer):
 *  Covariant Return Type allows an overriding method in a child class
 *  to return a MORE SPECIFIC (subtype) type than the return type
 *  declared in the parent class's method.
 *  Introduced in Java 5.
 */

// ===================== BASIC EXAMPLE =====================

class AnimalFactory {
    public Animal create() {
        System.out.println("Creating generic Animal...");
        return new Animal();
    }
}

class DogFactory extends AnimalFactory {
    @Override
    public Dog create() {
        System.out.println("Creating specific Dog...");
        return new Dog();
    }
}

// ===================== CLONE EXAMPLE =====================

class Prototype implements Cloneable {
    String data;

    Prototype(String data) {
        this.data = data;
    }

    @Override
    public Prototype clone() {
        try {
            return (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Prototype[data=" + data + "]";
    }
}

// ===================== BUILDER PATTERN =====================

class PersonBuilder {
    String name;
    int age;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public String build() {
        return "Person{name=" + name + ", age=" + age + "}";
    }
}

// ===================== ANIMAL2 + DOG2 =====================

class Animal2 {
    String name;

    Animal2(String name) {
        this.name = name;
    }

    public Animal2 getInstance() {
        return new Animal2("Generic Animal");
    }

    @Override
    public String toString() {
        return "Animal2[name=" + name + "]";
    }
}

class Dog2 extends Animal2 {

    Dog2(String name) {
        super(name);
    }

    @Override
    public Dog2 getInstance() {
        return new Dog2("Max");
    }

    void fetch() {
        System.out.println(name + " fetches the ball!");
    }

    @Override
    public String toString() {
        return "Dog2[name=" + name + "]";
    }
}

public class R6_CovariantReturnType {
    public static void main(String[] args) {

        System.out.println("========== COVARIANT RETURN TYPE DEMO ==========\n");

        System.out.println("--- 1. Basic Covariant Return Type ---");
        AnimalFactory af = new AnimalFactory();
        Animal a = af.create();
        System.out.println("From AnimalFactory: " + a.name);

        DogFactory df = new DogFactory();
        Dog d = df.create();
        System.out.println("From DogFactory (Covariant): " + d.name);

        System.out.println();

        System.out.println("--- 2. getInstance() Covariant Return ---");
        Animal2 animal2 = new Animal2("Lion");
        Animal2 result1 = animal2.getInstance();
        System.out.println("From Animal2: " + result1);

        Dog2 dog2 = new Dog2("Bruno");
        Dog2 result2 = dog2.getInstance();
        System.out.println("From Dog2 (Covariant): " + result2);
        result2.fetch();

        System.out.println();

        System.out.println("--- 3. Prototype clone() Covariant ---");
        Prototype original = new Prototype("Hello Java");
        Prototype cloned = original.clone();
        cloned.data = "Hello Clone";
        System.out.println("Original: " + original);
        System.out.println("Cloned:   " + cloned);
        System.out.println("Same object? " + (original == cloned));

        System.out.println();

        System.out.println("--- 4. Builder Pattern ---");
        String person = new PersonBuilder()
                .setName("Rohit")
                .setAge(22)
                .build();
        System.out.println("Built: " + person);

        System.out.println("\n=================================================");
    }
}
