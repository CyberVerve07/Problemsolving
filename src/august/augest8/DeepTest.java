package august.augest8;
class EmployeeDeep implements Cloneable {
    String name;
    Department department;

    public EmployeeDeep(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 1. Perform the initial shallow copy
        EmployeeDeep clonedEmp = (EmployeeDeep) super.clone();

        // 2. EXPLICITLY deep copy the nested object.
        // We are allocating a new reference to the cloned object's department.
        clonedEmp.department = (Department) this.department.clone();

        return clonedEmp;
    }
}

public class DeepTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Department dept = new Department("Engineering");
        EmployeeDeep emp1 = new EmployeeDeep("Aditya", dept);

        // Creating a deep clone
        EmployeeDeep emp2 = (EmployeeDeep) emp1.clone();

        // Modifying the department name in the CLONED object.
        emp2.department.deptName = "HR";

        // Output proves complete isolation.
        // emp1 remains intact. emp2 has its own modified state.
        System.out.println("Emp1 Dept: " + emp1.department.deptName); // Prints: Engineering
        System.out.println("Emp2 Dept: " + emp2.department.deptName); // Prints: HR
    }
}

//FeatureShallow CopyDeep CopyExecutionsuper.clone()super.clone() + explicit cloning of nested objectsNested
// ObjectsCopied by reference (Shared memory address)Copied by value (New memory address in heap)Mutation RiskHigh.
// Modifying nested data in clone mutates original.Zero.
// Objects are entirely decoupled.PerformanceFast, minimal memory overhead.Slower, requires more heap allocation.