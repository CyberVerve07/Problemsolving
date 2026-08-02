package dsa.strings;

/**
 * ============================================================
 *  Q1 - CHECK IF STRING IS PALINDROME
 *  ðŸ¢ Asked In: TCS, Wipro, Infosys, Accenture, Capgemini, HCL
 *  â­ Difficulty: Easy
 *  ðŸ“Œ Topic: String + Two Pointer
 * ============================================================
 *
 *  PROBLEM:
 *  --------
 *  Given a string, check whether it is a palindrome or not.
 *  A palindrome reads the same forward and backward.
 *
 *  Example:
 *    Input:  "racecar"  â†’ Output: true
 *    Input:  "hello"    â†’ Output: false
 *    Input:  "A man a plan a canal Panama" â†’ Output: true (ignore spaces/case)
 *
 * ============================================================
 *  APPROACH 1 - BRUTE FORCE (Extra String) - O(n) Time, O(n) Space
 * ============================================================
 *  Logic:
 *    - Reverse the string
 *    - Compare with original
 *  âŒ Uses extra space â†’ not preferred
 *
 * ============================================================
 *  APPROACH 2 - TWO POINTER (In-place) - O(n) Time, O(1) Space
 * ============================================================
 *  Logic:
 *    - Use left = 0, right = str.length - 1
 *    - If str[left] != str[right] â†’ NOT a palindrome
 *    - Move left â†’ right â†
 *    - If all match â†’ it IS a palindrome
 *
 *  DRY RUN:
 *    str = "racecar"
 *    left=0, right=6 â†’ r == r âœ…
 *    left=1, right=5 â†’ a == a âœ…
 *    left=2, right=4 â†’ c == c âœ…
 *    left=3, right=3 â†’ left >= right â†’ STOP â†’ PALINDROME âœ…
 *
 * ============================================================
 */
public class Q1_Palindrome {

    // âœ… OPTIMAL - Two Pointer - O(n) Time, O(1) Space
    public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) return true;

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; // Mismatch found â†’ not palindrome
            }
            left++;
            right--;
        }

        return true; // All characters matched
    }

    // âœ… BONUS: Case-insensitive Palindrome (ignore spaces & case)
    // Example: "A man a plan a canal Panama" â†’ true
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

    // âŒ BRUTE FORCE using StringBuilder reverse
    public static boolean isPalindromeBrute(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    // âœ… BONUS: Check if number is Palindrome
    public static boolean isNumberPalindrome(int num) {
        if (num < 0) return false; // Negative numbers are not palindromes
        return isPalindrome(String.valueOf(num));
    }

    public static void main(String[] args) {
        System.out.println("=== PALINDROME CHECK ===");

        System.out.println("racecar   â†’ " + isPalindrome("racecar")); // true
        System.out.println("hello     â†’ " + isPalindrome("hello"));   // false
        System.out.println("madam     â†’ " + isPalindrome("madam"));   // true
        System.out.println("a         â†’ " + isPalindrome("a"));       // true (single char)
        System.out.println("aa        â†’ " + isPalindrome("aa"));      // true

        System.out.println("\n=== CASE INSENSITIVE ===");
        System.out.println("A man a plan a canal Panama â†’ "
                + isPalindromeIgnoreCase("A man a plan a canal Panama")); // true
        System.out.println("race a car â†’ "
                + isPalindromeIgnoreCase("race a car")); // false

        System.out.println("\n=== NUMBER PALINDROME ===");
        System.out.println("121  â†’ " + isNumberPalindrome(121));  // true
        System.out.println("123  â†’ " + isNumberPalindrome(123));  // false
        System.out.println("-121 â†’ " + isNumberPalindrome(-121)); // false

        /*
         * KEY INTERVIEW POINTS TO REMEMBER:
         * -----------------------------------
         * 1. Use Two Pointer for O(1) space
         * 2. Handle edge cases: null, empty, single char, negative numbers
         * 3. FOLLOW-UP: "Ignore spaces and case?" â†’ use replaceAll + toLowerCase
         * 4. FOLLOW-UP: "Check number palindrome?" â†’ convert to String or math approach
         * 5. Time: O(n), Space: O(1) with Two Pointer
         */
    }
}
