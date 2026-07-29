package dsa.strings;

/**
 * ============================================================
 *  Q5 - LONGEST SUBSTRING WITHOUT REPEATING CHARACTERS
 *  🏢 Asked In: Amazon, Google, Microsoft, Uber, Flipkart, Adobe
 *  ⭐ Difficulty: Medium
 *  📌 Topic: Sliding Window + HashSet / Array
 * ============================================================
 *
 *  PROBLEM:
 *  --------
 *  Given a string s, find the length of the LONGEST SUBSTRING
 *  without repeating characters.
 *
 *  Example:
 *    Input:  "abcabcbb"  → Output: 3  ("abc")
 *    Input:  "bbbbb"     → Output: 1  ("b")
 *    Input:  "pwwkew"    → Output: 3  ("wke")
 *    Input:  "abcdef"    → Output: 6  (whole string)
 *
 * ============================================================
 *  APPROACH 1 - BRUTE FORCE (O(n³) Time)
 * ============================================================
 *  Logic:
 *    - Check every possible substring
 *    - For each substring, check if all chars are unique
 *    - Track maximum length
 *  ❌ O(n³) → way too slow, will get TLE
 *
 * ============================================================
 *  APPROACH 2 - SLIDING WINDOW with HashSet (O(n) Time, O(n) Space)
 * ============================================================
 *
 *  🔑 KEY CONCEPT - SLIDING WINDOW:
 *  ----------------------------------
 *  Imagine a window [left ... right] sliding over the string.
 *  - EXPAND window by moving right →
 *  - SHRINK window by moving left → when duplicate found
 *
 *  Logic:
 *    - Use a HashSet to store characters in current window
 *    - left = 0, right = 0
 *    - Move right: if s[right] NOT in set → add it, update maxLen
 *    - If s[right] IS in set → remove s[left] from set, left++
 *    - Continue until right reaches end
 *
 *  DRY RUN:
 *    s = "abcabcbb"
 *    ---
 *    r=0: 'a' not in {} → add → {a}, len=1, max=1
 *    r=1: 'b' not in {a} → add → {a,b}, len=2, max=2
 *    r=2: 'c' not in {a,b} → add → {a,b,c}, len=3, max=3
 *    r=3: 'a' IS in {a,b,c} → remove s[left]='a', left=1 → {b,c}
 *         'a' still NOT in {b,c} → add 'a' → {b,c,a}, len=3, max=3
 *    r=4: 'b' IS in {b,c,a} → remove s[left]='b', left=2 → {c,a}
 *         'b' NOT in {c,a} → add → {c,a,b}, len=3, max=3
 *    r=5: 'c' IS in {c,a,b} → remove s[left]='c', left=3 → {a,b}
 *         'c' NOT in {a,b} → add → {a,b,c}, len=3, max=3
 *    r=6: 'b' IS in {a,b,c} → remove 'a' left=4 → {b,c}
 *         'b' still in {b,c} → remove 'b' left=5 → {c}
 *         'b' NOT in {c} → add → {c,b}, len=2, max=3
 *    r=7: 'b' IS in {c,b} → remove 'c' left=6 → {b}
 *         'b' IS in {b} → remove 'b' left=7 → {}
 *         'b' NOT in {} → add → {b}, len=1, max=3
 *    Final max = 3 ✅
 *
 * ============================================================
 *  APPROACH 3 - OPTIMIZED SLIDING WINDOW (O(n) - Faster!)
 * ============================================================
 *  Instead of removing one by one, use HashMap to store
 *  LAST SEEN INDEX of each character.
 *  Jump left directly to (lastSeen[char] + 1) instead of moving one by one!
 *
 * ============================================================
 */
public class Q5_LongestSubstringNoRepeat {

    // ✅ APPROACH 2: HashSet Sliding Window - O(n) Time, O(n) Space
    public static int lengthOfLongestSubstring(String s) {
        java.util.HashSet<Character> set = new java.util.HashSet<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // Shrink window from left until no duplicate
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add current char and update max
            set.add(c);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    // ✅ APPROACH 3: HashMap Sliding Window (Optimized - O(n), fewer iterations)
    public static int lengthOfLongestSubstringOptimized(String s) {
        java.util.HashMap<Character, Integer> lastSeen = new java.util.HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If char was seen before AND it's within current window
            if (lastSeen.containsKey(c) && lastSeen.get(c) >= left) {
                // Jump left to just after the last occurrence of this char
                left = lastSeen.get(c) + 1;
            }

            // Update last seen index
            lastSeen.put(c, right);

            // Update max length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    // ✅ BONUS: Also return the actual substring
    public static String longestSubstring(String s) {
        java.util.HashMap<Character, Integer> lastSeen = new java.util.HashMap<>();
        int left = 0, maxLen = 0, maxStart = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (lastSeen.containsKey(c) && lastSeen.get(c) >= left) {
                left = lastSeen.get(c) + 1;
            }

            lastSeen.put(c, right);

            if (right - left + 1 > maxLen) {
                maxLen = right - left + 1;
                maxStart = left; // Track where max window started
            }
        }

        return s.substring(maxStart, maxStart + maxLen);
    }

    public static void main(String[] args) {
        System.out.println("=== LONGEST SUBSTRING WITHOUT REPEATING CHARS ===");

        String[] inputs = {"abcabcbb", "bbbbb", "pwwkew", "abcdef", ""};

        for (String s : inputs) {
            System.out.printf("Input: %-15s | HashSet: %d | HashMap: %d | Substr: \"%s\"%n",
                "\"" + s + "\"",
                lengthOfLongestSubstring(s),
                lengthOfLongestSubstringOptimized(s),
                s.isEmpty() ? "" : longestSubstring(s));
        }

        System.out.println("\n=== EDGE CASES ===");
        System.out.println("Single char 'a' → " + lengthOfLongestSubstring("a"));
        System.out.println("Two same 'aa'   → " + lengthOfLongestSubstring("aa"));
        System.out.println("Two diff 'ab'   → " + lengthOfLongestSubstring("ab"));

        /*
         * KEY INTERVIEW POINTS TO REMEMBER:
         * -----------------------------------
         * 1. MAGIC WORDS: "Sliding Window Technique" → say this upfront!
         * 2. HashSet approach: while loop to shrink → O(n) but 2n iterations max
         * 3. HashMap approach: directly jump left → O(n) with 1 pass → BETTER
         * 4. Window size = right - left + 1
         * 5. Time: O(n), Space: O(min(n, alphabet_size))
         * 6. This problem is a CLASSIC sliding window pattern:
         *    → Expand right when valid
         *    → Shrink left when invalid
         *    → MANY problems use this same pattern!
         * 7. FOLLOW-UP: "K distinct characters?" → same approach, modify condition
         */
    }
}
