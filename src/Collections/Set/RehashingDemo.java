package Collections.Set;

import java.util.HashSet;

public class RehashingDemo {
    public static void main(String[] args) {
        // Initial capacity: 16, Load Factor: 0.75
        // Rehash trigger threshold: 16 * 0.75 = 12 elements
        HashSet<Integer> set = new HashSet<>(16, 0.75f);

        System.out.println("Inserting elements...");
        for (int i = 1; i <= 20; i++) {
            long startTime = System.nanoTime();
            set.add(i);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.printf("Element %2d added in %5d ns", i, duration);

            // Highlight the exact moment rehashing occurs
            if (i == 13) {
                System.out.println(" <-- [REHASH TRIGGERED! Capacity doubles to 32]");
            } else {
                System.out.println();
            }
        }
    }
    //Rehashing is expensive process

}


