package dsa.strings;

/**
 * ============================================================
 *  Q4 - REVERSE WORDS IN A STRING
 *  🏢 Asked In: Amazon, Microsoft, Facebook, TCS, Wipro, Goldman Sachs
 *  ⭐ Difficulty: Easy-Medium
 *  📌 Topic: String Manipulation / Split / Two Pointer
 * ============================================================
 *
 *  PROBLEM A: Reverse the entire String
 *  ----------------------------------------
 *    Input:  "hello"
 *    Output: "olleh"
 *
 *  PROBLEM B: Reverse Words in a String (The REAL interview question!)
 *  -------------------------------------------------------------------
 *    Input:  "the sky is blue"
 *    Output: "blue is sky the"
 *
 *    Input:  "  hello world  "  (with extra spaces)
 *    Output: "world hello"     (trim extra spaces!)
 *
 * ============================================================
 *  APPROACH 1 - Using split() and StringBuilder - O(n) Time
 * ============================================================
 *  Logic:
 *    Step 1: Trim the string to remove leading/trailing spaces
 *    Step 2: Split by one or more spaces using regex "\\s+"
 *    Step 3: Traverse words from end to start
 *    Step 4: Append each word to result
 *
 *  DRY RUN:
 *    str = "  hello world  "
 *    After trim: "hello world"
 *    After split by "\\s+": ["hello", "world"]
 *    Traverse from end: "world" + " " + "hello"
 *    Result: "world hello" ✅
 *
 * ============================================================
 *  APPROACH 2 - Two Pointer (In-place, no split()) - O(n) Time
 * ============================================================
 *  Logic (the clever approach!):
 *    Step 1: Convert to char array
 *    Step 2: Reverse the ENTIRE string  → "eulb si yks eht"
 *    Step 3: Reverse EACH WORD          → "blue is sky the" ✅
 *
 *  WHY THIS WORKS?
 *    After reversing whole string, all words are in right order
 *    but each word is individually reversed.
 *    Reversing each word individually puts them back correctly!
 *
 *  DRY RUN:
 *    Input: "the sky is blue"
 *    Step 2: Reverse all  → "eulb si yks eht"
 *    Step 3: Reverse words individually:
 *            "eulb" → "blue"
 *            "si"   → "is"
 *            "yks"  → "sky"
 *            "eht"  → "the"
 *    Result: "blue is sky the" ✅
 *
 * ============================================================
 */
public class Q4_ReverseWords {

    // ✅ APPROACH 1: Split & Rebuild - Easy to code in interview
    public static String reverseWords(String str) {
        // Trim spaces and split by one or more whitespace
        String[] words = str.trim().split("\\s+");

        StringBuilder result = new StringBuilder();

        // Traverse from end to start
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) result.append(" ");
        }

        return result.toString();
    }

    // ✅ APPROACH 2: Reverse Entire + Reverse Each Word (No extra space)
    public static String reverseWordsInPlace(String str) {
        char[] chars = str.trim().toCharArray();
        int n = chars.length;

        // Step 1: Reverse the entire string
        reverseSection(chars, 0, n - 1);

        // Step 2: Reverse each word individually
        int start = 0;
        for (int i = 0; i <= n; i++) {
            // When we hit a space or end of string → reverse the word we just passed
            if (i == n || chars[i] == ' ') {
                reverseSection(chars, start, i - 1);
                start = i + 1; // Next word starts after the space
            }
        }

        return new String(chars);
    }

    // Helper: Reverse chars from index l to r
    private static void reverseSection(char[] chars, int l, int r) {
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
    }

    // ✅ BONUS: Reverse only the String characters (not words)
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // ✅ BONUS: Rotate String by K positions
    // "abcdef", k=2 → "efabcd"
    public static String rotateString(String str, int k) {
        int n = str.length();
        k = k % n; // Handle k > n
        return str.substring(n - k) + str.substring(0, n - k);
    }

    public static void main(String[] args) {
        System.out.println("=== REVERSE WORDS IN STRING ===");

        String s1 = "the sky is blue";
        System.out.println("Input:    \"" + s1 + "\"");
        System.out.println("Approach1: \"" + reverseWords(s1) + "\"");
        System.out.println("Approach2: \"" + reverseWordsInPlace(s1) + "\"");

        // Extra spaces test
        System.out.println("\n=== WITH EXTRA SPACES ===");
        String s2 = "  hello world  ";
        System.out.println("Input:    \"" + s2 + "\"");
        System.out.println("Approach1: \"" + reverseWords(s2) + "\"");

        // Single word
        System.out.println("\n=== SINGLE WORD ===");
        String s3 = "Java";
        System.out.println("Input:    \"" + s3 + "\"");
        System.out.println("Reversed:  \"" + reverseWords(s3) + "\"");

        // Reverse String
        System.out.println("\n=== REVERSE STRING CHARACTERS ===");
        System.out.println("hello → " + reverseString("hello"));

        // Rotate String
        System.out.println("\n=== ROTATE STRING ===");
        System.out.println("abcdef, k=2 → " + rotateString("abcdef", 2));

        /*
         * KEY INTERVIEW POINTS TO REMEMBER:
         * -----------------------------------
         * 1. "\\s+" matches one or more spaces → handles multiple spaces!
         * 2. ALWAYS call trim() first to handle leading/trailing spaces
         * 3. The "Reverse all, then reverse each word" trick is elegant!
         * 4. Mention BOTH approaches and trade-offs
         * 5. Time: O(n), Space: O(n) for Approach 1
         * 6. Time: O(n), Space: O(1) for Approach 2 (in-place on char array)
         * 7. StringBuilder is preferred over String concatenation (+) → O(n²) issue
         */
    }
}
