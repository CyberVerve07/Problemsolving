package revise;

/*
 * ============================================================
 *  TOPIC: DOWNCASTING
 * ============================================================
 *
 *  DEFINITION (Interview Answer):
 *  Downcasting is the process of converting a parent class reference
 *  back to a child class reference EXPLICITLY.
 *  It is the REVERSE of Upcasting.
 *  You must use an explicit cast: (ChildClass) parentRef
 *
 *  WHY WE USE IT IN JAVA:
 *  1. To ACCESS child-specific methods after upcasting.
 *  2. Needed when you stored a child object in a parent reference
 *     and now need child's unique functionality back.
 *  3. Used in real scenarios like: List<Object>, event handling,
 *     frameworks (Spring, Hibernate), deserialization, etc.
 *
 *  KEY POINTS:
 *  - Requires EXPLICIT CAST â€” compiler won't do it automatically.
 *  - Can throw ClassCastException at RUNTIME if object is not
 *    actually an instance of the child class.
 *  - ALWAYS use instanceof check before downcasting to be SAFE.
 *  - Only possible when the original object IS the child type.
 *
 *  REAL WORLD ANALOGY:
 *  You had a Dog stored as Animal. Now you want Dog-specific behavior.
 *  You downcast: Dog d = (Dog) animal;
 * ============================================================
 */

class Shape {
    void draw() {
        System.out.println("Drawing a Shape");
    }
}

class Circle extends Shape {
    double radius = 5.0;

    @Override
    void draw() {
        System.out.println("Drawing a Circle");
    }

    // Child-specific method
    double getArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a Rectangle");
    }

    // Child-specific method
    void getDimensions() {
        System.out.println("Rectangle: 10 x 5");
    }
}

public class R2_DownCasting {
    public static void main(String[] args) {

        System.out.println("========== DOWNCASTING DEMO ==========\n");

        // Step 1: Upcasting â€” storing Circle as Shape
        Shape shape = new Circle(); // Upcasting (implicit)
        shape.draw(); // "Drawing a Circle" â€” polymorphism

        // shape.getArea(); // COMPILE ERROR â€” Shape doesn't know getArea()

        System.out.println();

        // Step 2: DOWNCASTING â€” getting Circle back from Shape
        // SAFE DOWNCASTING â€” always use instanceof first!
        if (shape instanceof Circle) {
            Circle c = (Circle) shape; // Explicit downcast
            System.out.println("After Downcasting:");
            c.draw();                  // "Drawing a Circle"
            System.out.println("Area of Circle: " + c.getArea()); // Child method
            System.out.println("Radius: " + c.radius);
        }

        System.out.println();

        // Step 3: UNSAFE Downcasting (ClassCastException risk!)
        Shape shape2 = new Rectangle(); // Upcasting Rectangle
        try {
            Circle c2 = (Circle) shape2; // WRONG! shape2 is Rectangle, not Circle
            c2.draw();
        } catch (ClassCastException e) {
            System.out.println("ClassCastException caught: " + e.getMessage());
            System.out.println("Lesson: Always use instanceof before downcasting!");
        }

        System.out.println();

        // Step 4: Modern Java 16+ â€” Pattern Matching instanceof (cleaner syntax)
        Shape s = new Circle();
        if (s instanceof Circle circle) { // Pattern matching â€” auto downcast
            System.out.println("Pattern Matching (Java 16+): Area = " + circle.getArea());
        }

        System.out.println("\n=====================================");
    }
}
