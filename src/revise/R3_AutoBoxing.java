package revise;

/*
 * ============================================================
 *  TOPIC: AUTOBOXING & UNBOXING
 * ============================================================
 *
 *  DEFINITION (Interview Answer):
 *  AUTOBOXING: Automatic conversion of a primitive type (int, double,
 *  boolean, etc.) into its corresponding Wrapper class object
 *  (Integer, Double, Boolean, etc.) by the Java compiler.
 *
 *  UNBOXING: The reverse process — automatic conversion of a Wrapper
 *  class object back into its corresponding primitive type.
 *  Both are done AUTOMATICALLY by the Java compiler (since Java 5).
 *
 *  WHY WE USE IT IN JAVA:
 *  1. Java Collections (List, Map, Set) only work with OBJECTS,
 *     not primitives. Autoboxing bridges this gap.
 *  2. Eliminates the need to manually write: Integer.valueOf(5)
 *  3. Allows primitives to use Object methods (.equals(), .compareTo())
 *  4. Makes generic code cleaner and readable.
 *  5. Enables null assignment (primitives can't be null, wrappers can).
 *
 *  KEY POINTS:
 *  - Autoboxing: primitive → Wrapper  (int → Integer)
 *  - Unboxing:   Wrapper  → primitive (Integer → int)
 *  - Done automatically by compiler — generates valueOf() internally.
 *  - Can cause NullPointerException if wrapper object is null during unboxing.
 *  - Performance concern: avoid in tight loops (creates objects on heap).
 *  - Integer cache: Java caches Integer objects from -128 to 127.
 *
 *  PRIMITIVE vs WRAPPER:
 *  int     → Integer
 *  double  → Double
 *  boolean → Boolean
 *  char    → Character
 *  long    → Long
 *  float   → Float
 *  byte    → Byte
 *  short   → Short
 * ============================================================
 */

import java.util.ArrayList;
import java.util.List;

public class R3_AutoBoxing {
    public static void main(String[] args) {

        System.out.println("========== AUTOBOXING & UNBOXING DEMO ==========\n");

        // ---- 1. AUTOBOXING: primitive → Wrapper ----
        System.out.println("--- 1. AUTOBOXING ---");

        int primitiveInt = 42;
        Integer wrappedInt = primitiveInt;  // Autoboxing (compiler does: Integer.valueOf(42))
        System.out.println("Primitive int: " + primitiveInt);
        System.out.println("Wrapped Integer: " + wrappedInt);

        double primitiveDouble = 3.14;
        Double wrappedDouble = primitiveDouble; // Autoboxing
        System.out.println("Wrapped Double: " + wrappedDouble);

        boolean primitiveBool = true;
        Boolean wrappedBool = primitiveBool; // Autoboxing
        System.out.println("Wrapped Boolean: " + wrappedBool);

        System.out.println();

        // ---- 2. UNBOXING: Wrapper → primitive ----
        System.out.println("--- 2. UNBOXING ---");

        Integer wrapperObj = new Integer(100); // Wrapper object
        int unboxed = wrapperObj;              // Unboxing (compiler does: wrapperObj.intValue())
        System.out.println("Unboxed int: " + unboxed);

        // Unboxing in arithmetic
        Integer a = 10;
        Integer b = 20;
        int sum = a + b; // Both a and b are unboxed before addition
        System.out.println("Sum (unboxing in arithmetic): " + sum);

        System.out.println();

        // ---- 3. REAL USE CASE: Collections (only accept Objects) ----
        System.out.println("--- 3. AUTOBOXING IN COLLECTIONS ---");

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);   // Autoboxing: int 1 → Integer
        numbers.add(2);   // Autoboxing: int 2 → Integer
        numbers.add(3);   // Autoboxing: int 3 → Integer

        int first = numbers.get(0); // Unboxing: Integer → int
        System.out.println("First element (unboxed): " + first);
        System.out.println("List: " + numbers);

        System.out.println();

        // ---- 4. INTEGER CACHE TRICK (Important Interview Question!) ----
        System.out.println("--- 4. INTEGER CACHE (-128 to 127) ---");

        Integer x = 100;
        Integer y = 100;
        System.out.println("x == y (100): " + (x == y));   // true (cached)

        Integer p = 200;
        Integer q = 200;
        System.out.println("p == q (200): " + (p == q));   // false (NOT cached)
        System.out.println("p.equals(q) (200): " + p.equals(q)); // true (correct way)

        System.out.println("\nLesson: Always use .equals() to compare Integer objects!");

        System.out.println();

        // ---- 5. NullPointerException RISK during Unboxing ----
        System.out.println("--- 5. NPE RISK during UNBOXING ---");

        Integer nullWrapper = null;
        try {
            int val = nullWrapper; // Unboxing null → NullPointerException!
            System.out.println(val);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException! Cannot unbox null wrapper.");
            System.out.println("Always null-check before unboxing!");
        }

        System.out.println("\n================================================");
    }
}
