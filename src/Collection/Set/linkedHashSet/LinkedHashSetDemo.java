package Collections.Set.linkedHashSet;

import java.util.LinkedHashSet;

public class LinkedHashSetDemo {
    public static void main(String[] args) {

        // LinkedHashSet initialization
        LinkedHashSet<String> searchHistory = new LinkedHashSet<>();

        // 1. ADD OPERATION -> Time Complexity: O(1) constant time on average
        searchHistory.add("Java Tutorial");
        searchHistory.add("Spring Boot Guide");
        searchHistory.add("HashMap Internal Working");
        searchHistory.add("Java Tutorial"); // Duplicate item - will be ignored, returns false

        System.out.println("Search History (Insertion Order Maintained):");
        System.out.println(searchHistory);
        // Output: [Java Tutorial, Spring Boot Guide, HashMap Internal Working]
        // Notice that duplicates are rejected, and the insertion order remains intact.
        //It maintains doubly linked list

        // 2. CONTAINS (SEARCH) OPERATION -> Time Complexity: O(1) average time
        boolean found = searchHistory.contains("Spring Boot Guide");
        System.out.println("\nIs 'Spring Boot Guide' present? " + found);

        // 3. REMOVE OPERATION -> Time Complexity: O(1) average time
        searchHistory.remove("Java Tutorial");
        System.out.println("\nAfter removing 'Java Tutorial':");
        System.out.println(searchHistory);

        // 4. ITERATION / TRAVERSAL -> Time Complexity: O(N) where N is the number of elements
        System.out.println("\nIterating through the remaining items in exact order:");
        for (String item : searchHistory) {
            System.out.println("- " + item);
        }

        // 5. SIZE AND CLEAR -> Time Complexity: O(1) for size(), O(N) for clear()
        System.out.println("\nTotal unique items left: " + searchHistory.size());
        searchHistory.clear();
        System.out.println("Is search history empty now? " + searchHistory.isEmpty());
    }
}