package dsa.strings;

import java.util.HashMap;

/**
 * ============================================================
 *  Q2 - FIND FIRST NON-REPEATING CHARACTER
 *   Asked In: Amazon, Flipkart, Microsoft, TCS, Infosys, Zoho
 *   Difficulty: Easy-Medium
 *   Topic: String + HashMap / Frequency Array
 * ============================================================
 *
 *  PROBLEM:
 *  --------
 *  Given a string, find the first character that appears only once.
 *  Return the character or its index. Return -1 if none exists.
 *
 *  Example:
 *    Input:  "leetcode"   â†’ Output: 'l' (index 0)
 *    Input:  "loveleetcode" â†’ Output: 'v' (index 2)
 *    Input:  "aabb"       â†’ Output: -1 (no unique char)
 *
 * ============================================================
 *  APPROACH 1 - BRUTE FORCE (O(nÂ²))
 * ============================================================
 *  Logic:
 *    - For each character, scan entire string to count occurrences
 *    - If count == 1 â†’ return that character
 *  âŒ O(nÂ²) â†’ too slow
 *
 * ============================================================
 *  APPROACH 2 - HASHMAP (O(n) Time, O(1) Space*)
 * ============================================================
 *  * O(1) space because max 26 lowercase English letters
 *
 *  Logic (TWO PASS):
 *    Pass 1: Count frequency of each character using HashMap/array
 *    Pass 2: Traverse string left to right, find first char with freq == 1
 *
 *  DRY RUN:
 *    str = "leetcode"
 *    Pass 1: {l:1, e:3, t:1, c:1, o:1, d:1}
 *    Pass 2:
 *      index 0: 'l' â†’ freq=1 â†’ FOUND! Return 'l'
 *
 *  Another example:
 *    str = "loveleetcode"
 *    Pass 1: {l:2, o:2, v:1, e:4, t:1, c:1, d:1}
 *    Pass 2:
 *      index 0: 'l' â†’ freq=2 â†’ skip
 *      index 1: 'o' â†’ freq=2 â†’ skip
 *      index 2: 'v' â†’ freq=1 â†’ FOUND! Return 'v'
 *
 * ============================================================
 *  APPROACH 3 - FREQUENCY ARRAY (Faster for lowercase letters)
 * ============================================================
 *  Instead of HashMap, use int[26] array for 26 letters.
 *  'a' maps to index 0, 'b' to index 1, etc.
 *  Access: arr[char - 'a']
 *
 * ============================================================
 */
public class Q2_FirstNonRepeatingChar {

    //  APPROACH 2: HashMap - O(n) Time
    public static char firstUniqueCharHashMap(String str) {
        HashMap<Character, Integer> freq = new HashMap<>();

        // Pass 1: Count frequency
        for (char c : str.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Pass 2: Find first char with frequency 1
        for (char c : str.toCharArray()) {
            if (freq.get(c) == 1) {
                return c; // First unique character
            }
        }

        return '\0'; // No unique character found
    }

    //  APPROACH 3: Frequency Array - O(n) Time, O(1) Space (faster!)
    public static int firstUniqueCharIndex(String str) {
        int[] freq = new int[26]; // For 26 lowercase English letters

        // Pass 1: Count frequency
        for (char c : str.toCharArray()) {
            freq[c - 'a']++; // 'a'-'a'=0, 'b'-'a'=1, 'z'-'a'=25
        }

        // Pass 2: Find first character with frequency 1
        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i) - 'a'] == 1) {
                return i; // Return INDEX of first unique char
            }
        }

        return -1; // Not found
    }

    //  BRUTE FORCE - O(nÂ²) Time
    public static char firstUniqueCharBrute(String str) {
        for (int i = 0; i < str.length(); i++) {
            boolean isUnique = true;
            for (int j = 0; j < str.length(); j++) {
                if (i != j && str.charAt(i) == str.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) return str.charAt(i);
        }
        return '\0';
    }

    public static void main(String[] args) {
        System.out.println("=== FIRST NON-REPEATING CHARACTER ===");

        String s1 = "leetcode";
        System.out.println("Input: " + s1);
        System.out.println("First Unique Char  = " + firstUniqueCharHashMap(s1));
        System.out.println("First Unique Index = " + firstUniqueCharIndex(s1));

        System.out.println("\nInput: loveleetcode");
        String s2 = "loveleetcode";
        System.out.println("First Unique Char  = " + firstUniqueCharHashMap(s2));
        System.out.println("First Unique Index = " + firstUniqueCharIndex(s2));

        System.out.println("\nInput: aabb (no unique char)");
        String s3 = "aabb";
        System.out.println("First Unique Index = " + firstUniqueCharIndex(s3)); // -1

        System.out.println("\nInput: z (single char)");
        String s4 = "z";
        System.out.println("First Unique Char  = " + firstUniqueCharHashMap(s4));

        /*
         * KEY INTERVIEW POINTS TO REMEMBER:
         * -----------------------------------
         * 1. TWO PASS approach â†’ always mention this clearly
         * 2. Use int[26] instead of HashMap for lowercase letters â†’ O(1) space
         * 3. 'c' - 'a' gives index (0 to 25) â†’ super useful trick!
         * 4. Handle edge cases: empty string, all same characters
         * 5. Time: O(n), Space: O(1) with frequency array
         * 6. FOLLOW-UP: "All non-repeating chars?" â†’ Easy, just return all with freq==1
         */
    }
}
