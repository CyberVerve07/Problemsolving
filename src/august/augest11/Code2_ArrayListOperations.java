package august.augest11;

import java.util.ArrayList;
import java.util.List;

/**
 * ----------------------------------------------------------------------------------
 * 📌 CODE 2: ArrayList Core Operations & Memory Shifting Mechanics
 * ----------------------------------------------------------------------------------
 *
 * 🔍 CORE OPERATIONS COVERED:
 * 1. `get(int index)`       : Direct index lookup using elementData[index].
 * 2. `set(int index, E e)`  : Replace existing element at specified index.
 * 3. `add(int index, E e)`  : Insert element at specific position (shifts right).
 * 4. `remove(int index)`    : Delete element at index (shifts left).
 * 5. `remove(Object o)`     : Linear search to find object + delete & shift left.
 *
 * ----------------------------------------------------------------------------------
 * ⏱️ TIME & SPACE COMPLEXITY ANALYSIS:
 * ----------------------------------------------------------------------------------
 * | Operation            | Time Complexity | Reason / Mechanics                           |
 * |----------------------|-----------------|----------------------------------------------|
 * | `get(index)`         | O(1)            | Direct memory offset calculation             |
 * | `set(index, val)`    | O(1)            | Direct element assignment at array index     |
 * | `add(index, val)`    | O(N)            | Requires shifting elements to the RIGHT     |
 * | `remove(index)`      | O(N)            | Requires shifting elements to the LEFT      |
 * | `remove(Object o)`   | O(N)            | O(N) search + O(N) shifting = O(N)           |
 *
 * Space Complexity: O(1) auxiliary space for operations.
 * ----------------------------------------------------------------------------------
 *
 * @author Aditya
 * @date 11th August
 */
public class Code2_ArrayListOperations {

    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println("   DEMO 2: ARRAYLIST OPERATIONS & SHIFTING MECHANICS       ");
        System.out.println("==========================================================\n");

        List<String> frameworkList = new ArrayList<>();
        frameworkList.add("Spring Boot");
        frameworkList.add("Hibernate");
        frameworkList.add("React");
        frameworkList.add("Docker");
        frameworkList.add("Kubernetes");

        System.out.println("Initial Framework List: " + frameworkList);
        System.out.println("Current Size: " + frameworkList.size() + "\n");

        // 1. Direct Access: get(index) -> O(1) Time
        String secondItem = frameworkList.get(1);
        System.out.println("1. get(1) [O(1) Time] -> Found: " + secondItem);

        // 2. Direct Update: set(index, element) -> O(1) Time
        String oldVal = frameworkList.set(2, "VueJS");
        System.out.println("2. set(2, 'VueJS') [O(1) Time] -> Replaced '" + oldVal + "' with 'VueJS'");
        System.out.println("   Updated List: " + frameworkList);

        // 3. Positional Insertion: add(index, element) -> O(N) Time (Shifts right)
        System.out.println("\n3. Inserting 'Kafka' at index 1: add(1, 'Kafka') [O(N) Time]...");
        System.out.println("   --> Elements from index 1 onward are shifted RIGHT using System.arraycopy()");
        frameworkList.add(1, "Kafka");
        System.out.println("   List after insertion: " + frameworkList);

        // 4. Positional Deletion: remove(index) -> O(N) Time (Shifts left)
        System.out.println("\n4. Removing element at index 3: remove(3) [O(N) Time]...");
        System.out.println("   --> Elements after index 3 are shifted LEFT to fill the gap");
        String removedItem = frameworkList.remove(3);
        System.out.println("   Removed Item: " + removedItem);
        System.out.println("   List after removal: " + frameworkList);

        // 5. Value-based Deletion: remove(Object) -> O(N) Time
        System.out.println("\n5. Removing 'Docker' by Object: remove('Docker') [O(N) Time]...");
        boolean isRemoved = frameworkList.remove("Docker");
        System.out.println("   Is Docker removed? " + isRemoved);
        System.out.println("   Final List: " + frameworkList);

        printComplexityTable();
    }

    private static void printComplexityTable() {
        System.out.println("\n----------------------------------------------------------");
        System.out.println("📊 TIME & SPACE COMPLEXITY TABLE FOR CORE OPERATIONS");
        System.out.println("----------------------------------------------------------");
        System.out.println("• get(index)       : O(1)  (Random access by index calculation)");
        System.out.println("• set(index, val)  : O(1)  (Direct assignment)");
        System.out.println("• add(index, val)  : O(N)  (Elements shift right)");
        System.out.println("• remove(index)    : O(N)  (Elements shift left)");
        System.out.println("• remove(Object)   : O(N)  (Linear search + left shift)");
        System.out.println("• Auxiliary Space  : O(1)  (In-place modification)");
        System.out.println("----------------------------------------------------------");
    }
}
