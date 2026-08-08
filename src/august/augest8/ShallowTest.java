package august.augest8;

class EmployeeShallow implements Cloneable {
    String name;
    Department department; // Nested mutable object

    public EmployeeShallow(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // Default Object.clone() performs a shallow copy automatically.
        return super.clone();
    }
}

public class ShallowTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Department dept = new Department("Engineering");
        EmployeeShallow emp1 = new EmployeeShallow("Aditya", dept);

        // Creating a shallow clone
        EmployeeShallow emp2 = (EmployeeShallow) emp1.clone();

        // CRITICAL FAILURE POINT:
        // Modifying the department name in the CLONED object.
        emp2.department.deptName = "HR";

        // Output proves both objects share the same Department reference.
        // Changing emp2 ruined emp1's data.
        System.out.println("Emp1 Dept: " + emp1.department.deptName); // Prints: HR
        System.out.println("Emp2 Dept: " + emp2.department.deptName); // Prints: HR
    }
}
