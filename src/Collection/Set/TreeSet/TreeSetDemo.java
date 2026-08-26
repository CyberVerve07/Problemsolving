package Collection.Set.TreeSet;

import java.util.TreeSet;

public class TreeSetDemo {

    public static void main(String[] args) {

        /*
         * ============================================================
         * 1. Creating TreeSet
         * ============================================================
         *
         * TreeSet:
         * - Stores UNIQUE elements
         * - Maintains elements in SORTED order
         * - Internally uses a self-balancing Red-Black Tree
         * - Default sorting is NATURAL ORDERING
         */
        TreeSet<Integer> numbers = new TreeSet<>();
        /*
         * ============================================================
         * 2. Adding elements
         * ============================================================
         */

        numbers.add(50);
        numbers.add(20);
        numbers.add(80);
        numbers.add(10);
        numbers.add(40);
        numbers.add(70);

        /*
         * TreeSet automatically sorts the elements.
         *
         * We inserted:
         * 50, 20, 80, 10, 40, 70
         *
         * But TreeSet stores:
         * 10, 20, 40, 50, 70, 80
         */

        System.out.println("TreeSet: " + numbers);


        /*
         * ============================================================
         * 3. Duplicate elements
         * ============================================================
         */

        numbers.add(40);
        numbers.add(50);

        /*
         * 40 and 50 already exist.
         *
         * TreeSet does NOT allow duplicates.
         *
         * Internally, TreeSet compares the new element
         * with existing elements.
         *
         * If comparison result == 0
         * → element is considered equivalent
         * → it is NOT inserted.
         */

        System.out.println("After duplicates: " + numbers);


        /*
         * ============================================================
         * 4. contains()
         * ============================================================
         *
         * Checks whether an element exists.
         *
         * TreeSet uses tree searching.
         *
         * Time Complexity:
         * O(log n)
         */

        System.out.println("Contains 40? " + numbers.contains(40));
        System.out.println("Contains 100? " + numbers.contains(100));


        /*
         * ============================================================
         * 5. first() and last()
         * ============================================================
         *
         * first() → smallest element
         * last()  → largest element
         */

        System.out.println("First: " + numbers.first());
        System.out.println("Last: " + numbers.last());


        /*
         * ============================================================
         * 6. higher()
         * ============================================================
         *
         * Returns the SMALLEST element strictly GREATER than given value.
         *
         * Tree:
         * 10, 20, 40, 50, 70, 80
         *
         * higher(40) → 50
         */

        System.out.println("Higher than 40: " + numbers.higher(40));


        /*
         * ============================================================
         * 7. lower()
         * ============================================================
         *
         * Returns the LARGEST element strictly SMALLER than given value.
         *
         * lower(40) → 20
         */

        System.out.println("Lower than 40: " + numbers.lower(40));


        /*
         * ============================================================
         * 8. ceiling()
         * ============================================================
         *
         * Returns the SMALLEST element >= given value.
         *
         * ceiling(45) → 50
         *
         * Because 50 is the smallest element
         * greater than or equal to 45.
         */

        System.out.println("Ceiling of 45: " + numbers.ceiling(45));


        /*
         * ============================================================
         * 9. floor()
         * ============================================================
         *
         * Returns the LARGEST element <= given value.
         *
         * floor(45) → 40
         */

        System.out.println("Floor of 45: " + numbers.floor(45));


        /*
         * ============================================================
         * 10. pollFirst()
         * ============================================================
         *
         * Returns AND removes the smallest element.
         */

        System.out.println("Removed first: " + numbers.pollFirst());

        System.out.println("After pollFirst: " + numbers);


        /*
         * ============================================================
         * 11. pollLast()
         * ============================================================
         *
         * Returns AND removes the largest element.
         */

        System.out.println("Removed last: " + numbers.pollLast());

        System.out.println("After pollLast: " + numbers);


        /*
         * ============================================================
         * 12. headSet()
         * ============================================================
         *
         * Returns elements strictly LESS than given value.
         *
         * If set contains:
         * 20, 40, 50, 70
         *
         * headSet(50)
         *
         * → 20, 40
         */

        System.out.println("HeadSet < 50: " + numbers.headSet(50));


        /*
         * ============================================================
         * 13. tailSet()
         * ============================================================
         *
         * Returns elements GREATER THAN OR EQUAL TO given value.
         *
         * tailSet(40)
         *
         * → 40, 50, 70
         */

        System.out.println("TailSet >= 40: " + numbers.tailSet(40));


        /*
         * ============================================================
         * 14. subSet()
         * ============================================================
         *
         * By default:
         *
         * subSet(from, to)
         *
         * includes from
         * excludes to
         *
         * subSet(20, 70)
         *
         * → 20, 40, 50
         */

        System.out.println("SubSet [20, 70): "
                + numbers.subSet(20, 70));


        /*
         * ============================================================
         * 15. descendingSet()
         * ============================================================
         *
         * Returns elements in reverse sorted order.
         *
         * Original:
         * 20, 40, 50, 70
         *
         * Descending:
         * 70, 50, 40, 20
         */

        System.out.println("Descending: " + numbers.descendingSet());


        /*
         * ============================================================
         * 16. size()
         * ============================================================
         */

        System.out.println("Size: " + numbers.size());


        /*
         * ============================================================
         * IMPORTANT COMPLEXITY
         * ============================================================
         *
         * add()       → O(log n)
         * remove()    → O(log n)
         * contains()  → O(log n)
         *
         * Why?
         *
         * Because TreeSet is backed by a self-balancing
         * Red-Black Tree.
         */
    }
}