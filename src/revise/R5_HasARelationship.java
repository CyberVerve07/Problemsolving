package revise;

/*
 * ============================================================
 *  TOPIC: HAS-A RELATIONSHIP (Composition & Aggregation)
 * ============================================================
 *
 *  DEFINITION (Interview Answer):
 *  HAS-A relationship represents COMPOSITION or AGGREGATION in Java.
 *  When a class contains a reference (object) of another class as
 *  its member/field, it establishes a HAS-A relationship.
 *  It is implemented by declaring an instance variable of another class.
 *  NOT achieved through extends — achieved through OBJECT REFERENCE.
 *
 *  WHY WE USE IT IN JAVA:
 *  1. FLEXIBLE DESIGN — can change implementation without affecting outer class.
 *  2. CODE REUSE — without tight coupling of inheritance.
 *  3. "FAVOR COMPOSITION OVER INHERITANCE" — industry best practice.
 *  4. MULTIPLE BEHAVIORS — a class can HAS-A multiple other objects.
 *  5. BETTER ENCAPSULATION — inner object details are hidden.
 *
 *  HAS-A vs IS-A:
 *  IS-A → use INHERITANCE (extends): "Dog is a Animal"
 *  HAS-A → use COMPOSITION: "Car has a Engine", "Student has a Address"
 *
 *  TWO TYPES OF HAS-A:
 *
 *  1. COMPOSITION (Strong HAS-A):
 *     - Child cannot exist independently of parent.
 *     - If parent is destroyed, child is also destroyed.
 *     - Example: House HAS-A Room. Room can't exist without House.
 *
 *  2. AGGREGATION (Weak HAS-A):
 *     - Child CAN exist independently of parent.
 *     - If parent is destroyed, child still exists.
 *     - Example: Department HAS-A Teacher. Teacher can exist without Department.
 *
 *  KEY POINTS:
 *  - Implemented using object reference as a field.
 *  - Composition creates object INSIDE the class.
 *  - Aggregation receives object from OUTSIDE (constructor/setter).
 *  - Promotes loose coupling and better maintainability.
 * ============================================================
 */

// ===================== COMPOSITION EXAMPLE =====================
// Room cannot exist without House
class Room {
    String type;
    double area;

    Room(String type, double area) {
        this.type = type;
        this.area = area;
    }

    void showInfo() {
        System.out.println("  Room: " + type + " | Area: " + area + " sq.ft");
    }
}

// House HAS-A Room (Composition — Room created inside House)
class House {
    String address;
    // Strong HAS-A: Room objects created INSIDE House
    private Room livingRoom;
    private Room bedroom;
    private Room kitchen;

    House(String address) {
        this.address = address;
        // Room objects belong entirely to this House
        this.livingRoom = new Room("Living Room", 400);
        this.bedroom    = new Room("Bedroom", 250);
        this.kitchen    = new Room("Kitchen", 150);
    }

    void showHouseDetails() {
        System.out.println("House at: " + address);
        System.out.println("Rooms:");
        livingRoom.showInfo();
        bedroom.showInfo();
        kitchen.showInfo();
    }
}

// ===================== AGGREGATION EXAMPLE =====================
// Teacher can exist without Department
class Teacher {
    String name;
    String subject;

    Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    void showInfo() {
        System.out.println("  Teacher: " + name + " | Subject: " + subject);
    }
}

// Department HAS-A Teacher (Aggregation — Teacher passed from outside)
class Department {
    String deptName;
    // Weak HAS-A: Teacher object passed from OUTSIDE (not created inside)
    private Teacher[] teachers;

    Department(String deptName, Teacher[] teachers) {
        this.deptName = deptName;
        this.teachers = teachers; // Teacher exists independently
    }

    void showDeptDetails() {
        System.out.println("Department: " + deptName);
        System.out.println("Teachers:");
        for (Teacher t : teachers) {
            t.showInfo();
        }
    }
}

// ===================== REAL WORLD: Car HAS-A Engine =====================
class Engine {
    int horsepower;
    String type;

    Engine(int horsepower, String type) {
        this.horsepower = horsepower;
        this.type = type;
    }

    void start() {
        System.out.println("Engine started! HP: " + horsepower + " | Type: " + type);
    }
}

class Wheel {
    int size;

    Wheel(int size) {
        this.size = size;
    }

    void rotate() {
        System.out.println("Wheel (size " + size + " inch) is rotating!");
    }
}

// SportsCar HAS-A Engine AND HAS-A Wheel (multiple HAS-A)
class SportsCar {
    String model;
    Engine engine;   // HAS-A Engine
    Wheel[] wheels;  // HAS-A Wheels (4 wheels)

    SportsCar(String model) {
        this.model = model;
        this.engine = new Engine(500, "V8 Turbocharged"); // Composition
        this.wheels = new Wheel[]{new Wheel(20), new Wheel(20), new Wheel(20), new Wheel(20)};
    }

    void drive() {
        System.out.println(model + " is driving!");
        engine.start();
        for (Wheel w : wheels) {
            w.rotate();
        }
    }
}

public class R5_HasARelationship {
    public static void main(String[] args) {

        System.out.println("========== HAS-A RELATIONSHIP DEMO ==========\n");

        // ---- 1. COMPOSITION: House HAS-A Room ----
        System.out.println("--- COMPOSITION: House HAS-A Room ---");
        House myHouse = new House("221B Baker Street, London");
        myHouse.showHouseDetails();
        // Note: Rooms are destroyed when House is destroyed

        System.out.println();

        // ---- 2. AGGREGATION: Department HAS-A Teacher ----
        System.out.println("--- AGGREGATION: Department HAS-A Teacher ---");

        // Teachers exist independently
        Teacher t1 = new Teacher("Dr. Smith", "Data Structures");
        Teacher t2 = new Teacher("Prof. Jane", "Algorithms");
        Teacher t3 = new Teacher("Mr. Kumar", "Java Programming");

        Teacher[] cseTeachers = {t1, t2, t3};
        Department cse = new Department("Computer Science", cseTeachers);
        cse.showDeptDetails();

        // Teachers still exist even if department is removed
        System.out.println("\nDepartment removed, but Teacher still accessible:");
        t1.showInfo(); // t1 is still accessible

        System.out.println();

        // ---- 3. REAL WORLD: SportsCar HAS-A Engine & Wheels ----
        System.out.println("--- SportsCar HAS-A Engine AND Wheels ---");
        SportsCar ferrari = new SportsCar("Ferrari 488");
        ferrari.drive();

        System.out.println();

        // ---- 4. Key Difference Summary ----
        System.out.println("--- SUMMARY ---");
        System.out.println("IS-A  (Inheritance):  Dog IS-A Animal → use extends");
        System.out.println("HAS-A (Composition):  Car HAS-A Engine → use object reference");
        System.out.println("HAS-A (Aggregation):  Dept HAS-A Teacher → Teacher exists independently");

        System.out.println("\n==============================================");
    }
}
