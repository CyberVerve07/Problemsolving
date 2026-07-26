package oops.inheritance;

/**
 * Employee — Child class extending Person (Single Inheritance demo).
 *
 * INTERVIEW DEFINITION — 'super' keyword:
 * ------------------------------------------
 * Q: What is the 'super' keyword?
 * A: 'super' is a reference variable that refers to the PARENT class object.
 *    Three uses:
 *    1. super()       → Calls PARENT's constructor. Must be FIRST statement in child constructor.
 *    2. super.method() → Calls PARENT's version of an overridden method.
 *    3. super.field    → Accesses PARENT's field (when child has same-named field).
 *
 * Q: What is Constructor Chaining?
 * A: When a child constructor calls the parent constructor using super().
 *    Java ensures that the parent is ALWAYS initialized BEFORE the child.
 *    If super() is not called explicitly, Java auto-inserts super() (no-arg) as first line.
 *
 * INTERVIEW: What is Single Inheritance?
 * → One child class extends ONE parent class.
 * → Employee extends Person → Employee inherits name, age, and displayPerson() from Person.
 * → Employee adds its own fields (employeeId, salary) and methods (displayEmployee).
 *
 * JAVA TYPE: class (child/sub class)
 * OOP PILLAR: Inheritance
 *
 * @author Aditya
 * @version 2.0
 * @see Person
 */
public class Employee extends Person {

    /** Employee-specific fields — private for Encapsulation */
    private String employeeId;
    private double salary;

    /**
     * Child Constructor — uses super() to initialize parent (Person) fields.
     *
     * INTERVIEW: Why is super() the FIRST statement?
     * → Java requires the parent object to be FULLY CONSTRUCTED before the child.
     * → This ensures proper initialization order: Person → Employee.
     * → If not first statement, compiler gives ERROR.
     *
     * @param name       String — employee name (passed to Person via super)
     * @param age        int — employee age (passed to Person via super)
     * @param employeeId String — unique employee ID
     * @param salary     double — employee salary
     */
    public Employee(String name, int age, String employeeId, double salary) {
        super(name, age); // Constructor Chaining — calls Person(name, age)
        this.employeeId = employeeId;
        if (salary >= 0) {
            this.salary = salary;
        } else {
            this.salary = 0;
        }
    }

    // ======================== GETTERS & SETTERS ========================

    /** @return String — the employee ID */
    public String getEmployeeId() {
        return employeeId;
    }

    /** @param employeeId String — the employee ID to set */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /** @return double — the salary */
    public double getSalary() {
        return salary;
    }

    /**
     * @param salary double — the salary to set (must be non-negative)
     */
    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Salary cannot be negative!");
        }
    }

    /**
     * Displays complete employee details — calls parent's displayPerson() first.
     *
     * INTERVIEW: What is method reuse through inheritance?
     * → displayEmployee() calls displayPerson() from Person class (parent).
     * → This avoids code duplication — we REUSE parent's display logic.
     * → Then we ADD employee-specific details (ID, salary).
     */
    public void displayEmployee() {
        displayPerson(); // Calls parent's method — code reuse!
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Salary : " + salary);
    }

    /**
     * Main method — demonstrates Inheritance in action.
     *
     * @param args String[] — command line arguments
     */
    public static void main(String[] args) {
        Employee e = new Employee("Aman", 24, "EMP101", 50000);
        e.displayEmployee();
    }
}
