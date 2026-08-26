package Collection.Linkedlist;

import java.util.LinkedList;

/**
 * ============================================================
 *  CODE 1 - JAVA COLLECTIONS LINKEDLIST (BASIC OPERATIONS)
 *  🏢 Asked In: TCS, Infosys, Wipro, Accenture, Cognizant
 *  ⭐ Topic: java.util.LinkedList Internal Working & APIs
 * ============================================================
 *
 *  INTERNAL ARCHITECTURE:
 *  - Java's java.util.LinkedList is a DOUBLY LINKED LIST.
 *  - Node structure: Node<E> { E item; Node<E> next; Node<E> prev; }
 *
 * ============================================================
 *  TIME & SPACE COMPLEXITY ANALYSIS
 * ============================================================
 *  | Operation                     | Time Complexity | Space Complexity |
 *  |-------------------------------|-----------------|------------------|
 *  | addFirst() / addLast()        | O(1)            | O(1)             |
 *  | removeFirst() / removeLast()  | O(1)            | O(1)             |
 *  | getFirst() / getLast()        | O(1)            | O(1)             |
 *  | get(index) / set(index, val)  | O(N)            | O(1)             |
 *  | contains(obj)                 | O(N)            | O(1)             |
 * ============================================================
 */
public class Code1_LinkedListOperations {

    public static void main(String[] args) {
        // Create a Doubly LinkedList of Strings
        LinkedList<String> list = new LinkedList<>();

        System.out.println("=== 1. ADDING ELEMENTS ===");
        list.add("Java");           // Adds at end: O(1)
        list.addFirst("C++");       // Adds at head: O(1)
        list.addLast("Python");     // Adds at tail: O(1)
        list.add(2, "JavaScript");  // Adds at index 2: O(N) traversal
        System.out.println("List: " + list);

        System.out.println("\n=== 2. ACCESSING ELEMENTS ===");
        System.out.println("First Element [O(1)] : " + list.getFirst());
        System.out.println("Last Element  [O(1)] : " + list.getLast());
        System.out.println("At Index 2    [O(N)] : " + list.get(2));

        System.out.println("\n=== 3. REMOVING ELEMENTS ===");
        String removedFirst = list.removeFirst(); // O(1)
        String removedLast  = list.removeLast();  // O(1)
        System.out.println("Removed Head: " + removedFirst + " | Removed Tail: " + removedLast);
        System.out.println("Updated List: " + list);

        System.out.println("\n=== 4. SEARCH & SIZE ===");
        System.out.println("Contains 'Java'? " + list.contains("Java")); // O(N)
        System.out.println("List Size: " + list.size());                 // O(1)
    }
}
