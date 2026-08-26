package Collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * The java.util package contains the Java Collections Framework, providing built-in data structures.
 *
 * Collection Framework Overview:
 * - A set of classes and interfaces to easily store, manipulate, and implement data.
 *
 * List Interface Characteristics:
 * - Maintains insertion order.
 * - Allows duplicate elements.
 * - Provides index-based access.
 * - Implementations include ArrayList and LinkedList.
 * - Common methods: add(), remove(), sort(), set(), get().
 */
public class Demo9 {
    public static void main(String[] args) {

        // Initialize an ArrayList to store employee names
        List<String> employeeNames = new ArrayList<>();

        employeeNames.add("Aditya");
        employeeNames.add("Kartik");
        employeeNames.add("Ashish");
        employeeNames.add("Ashish"); // Duplicate
        employeeNames.add("Aditya"); // Duplicate
        employeeNames.add("Harsh");
        employeeNames.set(2,"Prachi");  //existing element replace karta hai.

        System.out.println("Initial List: " + employeeNames);

        // Correctly removing duplicates by object reference to avoid index-shifting bugs
        employeeNames.remove("Ashish"); // Removes the first occurrence of "Ashish"
        employeeNames.remove("Aditya"); // Removes the first occurrence of "Aditya"

        // Reading an element and actively using the return value
        String thirdEmployee = employeeNames.get(2);
        System.out.println("Employee at index 2: " + thirdEmployee);

        System.out.println("List after duplicate removal: " + employeeNames);

    }
}
//List is a interface in java Collection framework that represent the Order of elements and
// List allows to represent the duplicate elements in
//List is an interface in the Java Collection Framework that represents an ordered collection of elements.
// It allows duplicate elements and provides index-based access
// Common implementations include ArrayList, LinkedList, and Vector.
