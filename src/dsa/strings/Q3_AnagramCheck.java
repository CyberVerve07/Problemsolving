package dsa.strings;

import java.util.HashMap;

/**
 * ============================================================
 *  Q3 - CHECK IF TWO STRINGS ARE ANAGRAMS
 *  🏢 Asked In: Amazon, Google, Microsoft, Walmart, Paytm, Zoho
 *  ⭐ Difficulty: Easy
 *  📌 Topic: String + Sorting / Frequency Array
 * ============================================================
 *
 *  PROBLEM:
 *  --------
 *  Given two strings s and t, return true if t is an anagram of s.
 *  Two strings are anagrams if they contain the same characters
 *  with the same frequency (order doesn't matter).
 *
 *  Example:
 *    Input:  s = "anagram", t = "nagaram"  → Output: true
 *    Input:  s = "rat",     t = "car"      → Output: true
 *    Input:  s = "hello",   t = "world"    → Output: false
 *
 * ============================================================
 *  APPROACH 1 - SORTING (O(n log n) Time, O(1) Space)
 * ============================================================
 *  Logic:
 *    - Sort both strings
 *    - If sorted strings are equal → anagrams
 *  ❌ O(n log n) → not optimal but acceptable for small inputs
 *
 * ============================================================
 *  APPROACH 2 - FREQUENCY ARRAY (O(n) Time, O(1) Space)
 * ============================================================
 *  Logic:
 *    Step 1: Check if lengths are equal → if not, return false immediately
 *    Step 2: Create int[26] frequency array
 *    Step 3: For each char in s → increment count
 *             For each char in t → decrement count
 *    Step 4: If all counts are 0 → they are anagrams
 *
 *  DRY RUN:
 *    s = "anagram", t = "nagaram"
 *    freq = [0, 0, 0, ..., 0]  (size 26)
 *    ---
 *    Processing s: a:+3, n:+1, g:+1, r:+1, m:+1
 *    Processing t: n:-1, a:-3, g:-1, r:-1, m:-1
 *    Final freq = [0, 0, 0, ..., 0] → All ZEROS → ANAGRAM ✅
 *
 *  WHY THIS WORKS:
 *    If both strings have same chars with same freq,
 *    incrementing for s and decrementing for t will
 *    always result in all zeros!
 *
 * ============================================================
 */
public class Q3_AnagramCheck {

    //  OPTIMAL: Frequency Array - O(n) Time, O(1) Space
    public static boolean isAnagram(String s, String t) {
        // Edge case: different lengths → cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26]; // For 26 lowercase letters

        // Increment for s, Decrement for t
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++; // Count chars in s
            freq[t.charAt(i) - 'a']--; // Uncount chars in t
        }

        // If all counts are 0 → anagram
        for (int count : freq) {
            if (count != 0) {
                return false; // Some char appears different number of times
            }
        }

        return true;
    }

    // ✅ APPROACH using HashMap (works for Unicode strings too!)
    public static boolean isAnagramHashMap(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> freq = new HashMap<>();

        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!freq.containsKey(c) || freq.get(c) == 0) {
                return false; // Char not in s, or count exhausted
            }
            freq.put(c, freq.get(c) - 1);
        }

        return true;
    }

    //  SORTING Approach - O(n log n)
    public static boolean isAnagramSort(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        java.util.Arrays.sort(sc);
        java.util.Arrays.sort(tc);

        return java.util.Arrays.equals(sc, tc);
    }

    //  BONUS: Group Anagrams Together (Very common follow-up!)
    // Input:  ["eat","tea","tan","ate","nat","bat"]
    // Output: [["eat","tea","ate"],["tan","nat"],["bat"]]
    public static void groupAnagramsDemo() {
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        HashMap<String, java.util.List<String>> groups = new HashMap<>();

        for (String word : words) {
            char[] chars = word.toCharArray();
            java.util.Arrays.sort(chars);
            String key = new String(chars); // Sorted form = key

            groups.computeIfAbsent(key, k -> new java.util.ArrayList<>()).add(word);
        }

        System.out.println("Anagram Groups:");
        for (java.util.List<String> group : groups.values()) {
            System.out.println(group);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== ANAGRAM CHECK ===");

        System.out.println("anagram & nagaram → " + isAnagram("anagram", "nagaram")); // true
        System.out.println("rat & car         → " + isAnagram("rat", "car"));         // true
        System.out.println("hello & world     → " + isAnagram("hello", "world"));     // false
        System.out.println("ab & a            → " + isAnagram("ab", "a"));            // false (diff length)

        System.out.println("\n=== HASHMAP APPROACH ===");
        System.out.println("listen & silent   → " + isAnagramHashMap("listen", "silent")); // true

        System.out.println("\n=== SORTING APPROACH ===");
        System.out.println("triangle & integral → " + isAnagramSort("triangle", "integral")); // true

        System.out.println("\n=== GROUP ANAGRAMS (Bonus) ===");
        groupAnagramsDemo();

        /*
         * KEY INTERVIEW POINTS TO REMEMBER:
         * -----------------------------------
         * 1. FIRST CHECK: Length equality → if different, return false immediately
         * 2. Use int[26] for lowercase letters → O(1) space
         * 3. Use HashMap if input can have Unicode/special chars
         * 4. The "increment for s, decrement for t" trick is elegant!
         * 5. Time: O(n), Space: O(1) with frequency array
         * 6. FOLLOW-UP: "Group anagrams?" → Sort each word → use as HashMap key
         */
    }
}
