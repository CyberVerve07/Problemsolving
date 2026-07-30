//package revise;
//
///*
// * ============================================================
// *  TOPIC: COVARIANT RETURN TYPE
// * ============================================================
// *
// *  DEFINITION (Interview Answer):
// *  Covariant Return Type allows an overriding method in a child class
// *  to return a MORE SPECIFIC (subtype) type than the return type
// *  declared in the parent class's method.
// *  Introduced in Java 5.
// *
// *  WHY WE USE IT IN JAVA:
// *  1. CLEANER API — callers get specific type back without casting.
// *  2. BETTER TYPE SAFETY — more precise return type at compile time.
// *  3. FOLLOWS "PRINCIPLE OF SUBSTITUTABILITY" — child returns subtype
// *     which is still a valid parent type.
// *  4. Used heavily in Builder Pattern, Factory Pattern, Cloning.
// *  5. Eliminates explicit downcasting for the caller.
// *
// *  KEY POINTS:
// *  - Only RETURN TYPE can be covariant (not parameter types).
// *  - Child method must return SAME or SUBTYPE of parent's return type.
// *  - A child class returning a more general type would be COMPILE ERROR.
// *  - Works with both class types and interface types.
// *  - The method name, parameters must remain SAME (it's still overriding).
// *
// *  RULE:
// *  Parent returns Animal → Child CAN return Dog (Dog IS-A Animal ✓)
// *  Parent returns Dog    → Child CANNOT return Animal (Animal is NOT Dog ✗)
// *
// *  REAL WORLD USE:
// *  - clone() method: Object.clone() returns Object,
// *    but subclass can override to return specific type.
// *  - Builder pattern: each chained method returns the specific Builder.
// * ============================================================
// */
//
//// ===================== BASIC EXAMPLE =====================
//
//class AnimalFactory {
//    // Parent method returns general type: Animal
//    public Animal create() {
//        System.out.println("Creating generic Animal...");
//        return new Animal("Generic Animal");
//    }
//}
//
//class DogFactory extends AnimalFactory {
//    // COVARIANT RETURN TYPE: returns Dog (subtype of Animal) — VALID!
//    // Caller gets Dog directly — NO casting needed!
//    @Override
//    public Dog create() {
//        System.out.println("Creating specific Dog...");
//        return new Dog("Buddy");
//    }
//}
//
//// ===================== CLONE EXAMPLE (Classic Use) =====================
//
//class Prototype implements Cloneable {
//    String data;
//
//    Prototype(String data) {
//        this.data = data;
//    }
//
//    // Object.clone() returns Object type
//    // We override and return Prototype (covariant) — no casting needed
//    @Override
//    public Prototype clone() {
//        try {
//            return (Prototype) super.clone();
//        } catch (CloneNotSupportedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "Prototype[data=" + data + "]";
//    }
//}
//
//// ===================== BUILDER PATTERN (Covariant in practice) =====================
//
//class PersonBuilder {
//    String name;
//    int age;
//
//    // Returns PersonBuilder — allows method chaining
//    public PersonBuilder setName(String name) {
//        this.name = name;
//        return this;
//    }
//
//    public PersonBuilder setAge(int age) {
//        this.age = age;
//        return this;
//    }
//
//    public String build() {
//        return "Person{name=" + name + ", age=" + age + "}";
//    }
//}
//
//// ===================== ANIMAL + DOG (reused from before) =====================
//// (Minimal versions to avoid duplicate class error in package)
//
//class Animal2 {
//    String name;
//
//    Animal2(String name) {
//        this.name = name;
//    }
//
//    // Parent method — returns Animal2
//    public Animal2 getInstance() {
//        return new Animal2("Generic Animal");
//    }
//
//    @Override
//    public String toString() {
//        return "Animal2[name=" + name + "]";
//    }
//}
//
//class Dog2 extends Animal2 {
//
//    Dog2(String name) {
//        super(name);
//    }
//
//    // COVARIANT: overrides getInstance(), but returns Dog2 (subtype of Animal2)
//    @Override
//    public Dog2 getInstance() { // Return type is Dog2, not Animal2 — COVARIANT!
//        return new Dog2("Max");
//    }
//
//    void fetch() {
//        System.out.println(name + " fetches the ball!");
//    }
//
//    @Override
//    public String toString() {
//        return "Dog2[name=" + name + "]";
//    }
//}
//
//public class R6_CovariantReturnType {
//    public static void main(String[] args) {
//
//        System.out.println("========== COVARIANT RETURN TYPE DEMO ==========\n");
//
//        // ---- 1. Basic Covariant Return Type ----
//        System.out.println("--- 1. Basic Covariant Return Type ---");
//
//        AnimalFactory af = new AnimalFactory();
//        Animal a = af.create();       // returns Animal
//        System.out.println("From AnimalFactory: " + a.name);
//
//        DogFactory df = new DogFactory();
//        Dog d = df.create();          // returns Dog directly — NO casting needed!
//        System.out.println("From DogFactory (Covariant): " + d.name);
//        // Without covariant, we'd need: Dog d = (Dog) df.create(); — ugly!
//
//        System.out.println();
//
//        // ---- 2. Animal2 / Dog2 example ----
//        System.out.println("--- 2. getInstance() Covariant Return ---");
//
//        Animal2 animal2 = new Animal2("Lion");
//        Animal2 result1 = animal2.getInstance();
//        System.out.println("From Animal2: " + result1);
//
//        Dog2 dog2 = new Dog2("Bruno");
//        Dog2 result2 = dog2.getInstance(); // Returns Dog2 directly, no cast!
//        System.out.println("From Dog2 (Covariant): " + result2);
//        result2.fetch(); // Can directly call Dog-specific method!
//
//        System.out.println();
//
//        // ---- 3. Clone with Covariant Return ----
//        System.out.println("--- 3. Prototype clone() Covariant ---");
//
//        Prototype original = new Prototype("Hello Java");
//        Prototype cloned = original.clone(); // Returns Prototype directly (not Object)
//        cloned.data = "Hello Clone";
//        System.out.println("Original: " + original);
//        System.out.println("Cloned:   " + cloned);
//        System.out.println("Same object? " + (original == cloned)); // false
//
//        System.out.println();
//
//        // ---- 4. Builder Pattern (Covariant in chaining) ----
//        System.out.println("--- 4. Builder Pattern ---");
//        String person = new PersonBuilder()
//                .setName("Rohit")
//                .setAge(22)
//                .build();
//        System.out.println("Built: " + person);
//
//        System.out.println();
//
//        // ---- 5. Key Rule ----
//        System.out.println("--- RULE ---");
//        System.out.println("Parent returns: Animal → Child can return: Dog (Dog IS-A Animal) ✓");
//        System.out.println("Parent returns: Dog    → Child CANNOT return: Animal ✗ (Compile Error)");
//
//        System.out.println("\n=================================================");
//    }
//}
