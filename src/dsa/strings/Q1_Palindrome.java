package dsa.strings;

/**
 * ============================================================
 *  Q1 - CHECK IF STRING IS PALINDROME
 *  🏢 Asked In: TCS, Wipro, Infosys, Accenture, Capgemini, HCL
 *  ⭐ Difficulty: Easy
 *  📌 Topic: String + Two Pointer
 * ============================================================
 *
 *  PROBLEM:
 *  --------
 *  Given a string, check whether it is a palindrome or not.
 *  A palindrome reads the same forward and backward.
 *
 *  Example:
 *    Input:  "racecar"  → Output: true
 *    Input:  "hello"    → Output: false
 *    Input:  "A man a plan a canal Panama" → Output: true (ignore spaces/case)
 *
 * ============================================================
 *  APPROACH 1 - BRUTE FORCE (Extra String) - O(n) Time, O(n) Space
 * ============================================================
 *  Logic:
 *    - Reverse the string
 *    - Compare with original
 *  ❌ Uses extra space → not preferred
 *
 * ============================================================
 *  APPROACH 2 - TWO POINTER (In-place) - O(n) Time, O(1) Space
 * ============================================================
 *  Logic:
 *    - Use left = 0, right = str.length - 1
 *    - If str[left] != str[right] → NOT a palindrome
 *    - Move left → right ←
 *    - If all match → it IS a palindrome
 *
 *  DRY RUN:
 *    str = "racecar"
 *    left=0, right=6 → r == r ✅
 *    left=1, right=5 → a == a ✅
 *    left=2, right=4 → c == c ✅
 *    left=3, right=3 → left >= right → STOP → PALINDROME ✅
 *
 * ============================================================
 */
public class Q1_Palindrome {

    // ✅ OPTIMAL - Two Pointer - O(n) Time, O(1) Space
    public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) return true;

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; // Mismatch found → not palindrome
            }
            left++;
            right--;
        }

        return true; // All characters matched
    }

    // ✅ BONUS: Case-insensitive Palindrome (ignore spaces & case)
    // Example: "A man a plan a canal Panama" → true
    public static boolean isPalindromeIgnoreCase(String str) {
        if (str == null || str.isEmpty()) return true;

        // Step 1: Keep only letters and digits, convert to lowercase
        str = str.toLowerCase().replaceAll("[^a-z0-9]", "");

        // Step 2: Two pointer check
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // ❌ BRUTE FORCE using StringBuilder reverse
    public static boolean isPalindromeBrute(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    // ✅ BONUS: Check if number is Palindrome
    public static boolean isNumberPalindrome(int num) {
        if (num < 0) return false; // Negative numbers are not palindromes
        return isPalindrome(String.valueOf(num));
    }

    public static void main(String[] args) {
        System.out.println("=== PALINDROME CHECK ===");

        System.out.println("racecar   → " + isPalindrome("racecar")); // true
        System.out.println("hello     → " + isPalindrome("hello"));   // false
        System.out.println("madam     → " + isPalindrome("madam"));   // true
        System.out.println("a         → " + isPalindrome("a"));       // true (single char)
        System.out.println("aa        → " + isPalindrome("aa"));      // true

        System.out.println("\n=== CASE INSENSITIVE ===");
        System.out.println("A man a plan a canal Panama → "
                + isPalindromeIgnoreCase("A man a plan a canal Panama")); // true
        System.out.println("race a car → "
                + isPalindromeIgnoreCase("race a car")); // false

        System.out.println("\n=== NUMBER PALINDROME ===");
        System.out.println("121  → " + isNumberPalindrome(121));  // true
        System.out.println("123  → " + isNumberPalindrome(123));  // false
        System.out.println("-121 → " + isNumberPalindrome(-121)); // false

        /*
         * KEY INTERVIEW POINTS TO REMEMBER:
         * -----------------------------------
         * 1. Use Two Pointer for O(1) space
         * 2. Handle edge cases: null, empty, single char, negative numbers
         * 3. FOLLOW-UP: "Ignore spaces and case?" → use replaceAll + toLowerCase
         * 4. FOLLOW-UP: "Check number palindrome?" → convert to String or math approach
         * 5. Time: O(n), Space: O(1) with Two Pointer
         */
    }
}
