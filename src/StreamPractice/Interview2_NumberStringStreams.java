package StreamPractice;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

/**
 * ═══════════════════════════════════════════════════════════════════════
 *   STREAM API — MOST ASKED INTERVIEW QUESTIONS (Numbers & Strings)
 * ═══════════════════════════════════════════════════════════════════════
 *
 *  Ye questions 90% interviews me puche jaate hain:
 *  Q1.  List me duplicate elements nikalo
 *  Q2.  List me unique elements (duplicates remove)
 *  Q3.  String list me anagram groups banao
 *  Q4.  First non-repeating character
 *  Q5.  Character frequency map
 *  Q6.  List of lists ko flat karo (flatMap)
 *  Q7.  Numbers ka product nikalo (reduce)
 *  Q8.  Palindrome strings filter karo
 *  Q9.  Map ko value ke hisaab se sort karo
 *  Q10. String me words ki frequency
 *  Q11. Longest string in list
 *  Q12. Even/Odd numbers partition karo
 */
public class Interview2_NumberStringStreams {

    public static void main(String[] args) {

        separator("Q1: Duplicate Elements nikalo list se");
        /*
         *  Approach:
         *  Set<> track karo jo already dekhe — agar add() false return kare → duplicate
         *  filter(set::add) → seen set me add karo; false aaye matlab already hai → duplicate
         */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 3, 5, 6, 5, 7);

        Set<Integer> seen = new HashSet<>();
        List<Integer> duplicates = numbers.stream()
            .filter(n -> !seen.add(n))   // add() → false agar already present
            .distinct()                   // agar 3 baar aaya to once show karo
            .collect(Collectors.toList());

        System.out.println("  Original:   " + numbers);
        System.out.println("  Duplicates: " + duplicates);


        separator("Q2: Unique Elements (Duplicates Remove)");
        /*
         *  distinct() → Duplicate values hata deta hai
         *  SIMPLE but frequently asked
         */
        List<Integer> unique = numbers.stream()
            .distinct()
            .sorted()
            .collect(Collectors.toList());

        System.out.println("  Original: " + numbers);
        System.out.println("  Unique:   " + unique);


        separator("Q3: Anagram Groups banao");
        /*
         *  Approach:
         *  "eat", "tea", "tan" → sort karo → "aet", "aet", "ant"
         *  Same sorted string → ek group me hain → anagram hain
         *  groupingBy(sorted string) → Map<String, List<String>>
         */
        List<String> words = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat", "listen", "silent", "enlist");

        Map<String, List<String>> anagramGroups = words.stream()
            .collect(Collectors.groupingBy(
                word -> word.chars()          // word ke characters ka IntStream
                            .sorted()         // sort karo
                            .collect(
                                StringBuilder::new,
                                StringBuilder::appendCodePoint,
                                StringBuilder::append
                            ).toString()      // sorted string key bano
            ));

        anagramGroups.values().stream()
            .filter(group -> group.size() > 1)   // sirf actual anagram groups
            .forEach(group -> System.out.println("  Anagram Group: " + group));


        separator("Q4: First Non-Repeating Character in String");
        /*
         *  Approach:
         *  1. LinkedHashMap me character frequency count karo (insertion order maintain)
         *  2. Stream karo, jo pehla character ho frequency == 1, wo answer hai
         *  LinkedHashMap → ORDER MAINTAIN karta hai (important!)
         */
        String str = "aabbcdeef";

        Optional<Character> firstNonRepeating = str.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(
                Function.identity(),          // key = character itself
                LinkedHashMap::new,           // ← Order maintain karo!
                Collectors.counting()
            ))
            .entrySet().stream()
            .filter(e -> e.getValue() == 1)   // frequency = 1 → non-repeating
            .map(Map.Entry::getKey)
            .findFirst();

        System.out.println("  String: \"" + str + "\"");
        System.out.println("  First Non-Repeating: " + firstNonRepeating.orElse(null));


        separator("Q5: Character Frequency Map");
        /*
         *  Collectors.groupingBy + counting()
         *  Very common: "character count karo string ka"
         */
        String input = "programming";

        Map<Character, Long> charFreq = input.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()
            ));

        // Sort by frequency descending
        charFreq.entrySet().stream()
            .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
            .forEach(e -> System.out.printf("  '%c' → %d times%n", e.getKey(), e.getValue()));


        separator("Q6: flatMap — List of Lists ko flat karo");
        /*
         *  flatMap → Nested collection ko ek flat stream me convert karo
         *  Most asked: "2D list / list of lists se ek list banao"
         */
        List<List<Integer>> nestedList = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5, 6),
            Arrays.asList(7, 8, 9)
        );

        List<Integer> flatList = nestedList.stream()
            .flatMap(Collection::stream)   // har inner list ko stream me convert karo
            .collect(Collectors.toList());

        System.out.println("  Nested:  " + nestedList);
        System.out.println("  Flat:    " + flatList);

        // Practical: Sentence list → all words
        List<String> sentences = Arrays.asList("Java is great", "Stream API is powerful");
        List<String> allWords = sentences.stream()
            .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
            .distinct()
            .sorted()
            .collect(Collectors.toList());
        System.out.println("  All Words: " + allWords);


        separator("Q7: Product of Numbers (reduce)");
        /*
         *  reduce(identity, BinaryOperator)
         *  identity → Starting value (0 for sum, 1 for product)
         *  BinaryOperator → Dono values combine karo
         */
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);

        int sum = nums.stream()
            .reduce(0, Integer::sum);             // 0 + 1 + 2 + 3 + 4 + 5

        int product = nums.stream()
            .reduce(1, (a, b) -> a * b);          // 1 * 1 * 2 * 3 * 4 * 5

        int max = nums.stream()
            .reduce(Integer.MIN_VALUE, Integer::max);  // Max nikalo

        System.out.println("  Numbers: " + nums);
        System.out.println("  Sum:     " + sum);
        System.out.println("  Product: " + product);
        System.out.println("  Max:     " + max);


        separator("Q8: Palindrome Strings filter karo");
        /*
         *  filter + custom predicate
         *  Palindrome check: string == reverse of string
         */
        List<String> stringList = Arrays.asList("madam", "hello", "racecar", "java", "level", "stream", "radar");

        List<String> palindromes = stringList.stream()
            .filter(w -> w.equals(new StringBuilder(w).reverse().toString()))
            .collect(Collectors.toList());

        System.out.println("  All words:   " + stringList);
        System.out.println("  Palindromes: " + palindromes);


        separator("Q9: Map ko VALUE ke hisaab se Sort karo");
        /*
         *  Map sorting → entrySet().stream() → sorted() → LinkedHashMap me collect
         *  Map.Entry.comparingByValue() → Value se sort
         *  LinkedHashMap → Insertion order maintain karta hai
         */
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Ravi",   85);
        scores.put("Priya",  92);
        scores.put("Amit",   78);
        scores.put("Sneha",  96);
        scores.put("Rahul",  88);

        // Ascending
        System.out.println("  Sorted by Score (ASC):");
        scores.entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .forEach(e -> System.out.printf("    %-8s → %d%n", e.getKey(), e.getValue()));

        // Descending
        System.out.println("  Sorted by Score (DESC):");
        scores.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .forEach(e -> System.out.printf("    %-8s → %d%n", e.getKey(), e.getValue()));


        separator("Q10: Word Frequency in a Sentence");
        /*
         *  String split → stream → groupingBy + counting
         *  Most asked in coding round
         */
        String sentence = "java is great java is easy stream is powerful java";

        Map<String, Long> wordFreq = Arrays.stream(sentence.split(" "))
            .collect(Collectors.groupingBy(
                Function.identity(),     // word itself key hai
                Collectors.counting()
            ));

        // Sort by frequency DESC
        wordFreq.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .forEach(e -> System.out.printf("  %-10s → %d%n", e.getKey(), e.getValue()));


        separator("Q11: Longest String in List");
        /*
         *  Comparator.comparingInt(String::length) → length se compare
         *  max() → longest
         */
        List<String> strList = Arrays.asList("Java", "Python", "JavaScript", "Go", "Kotlin", "C");

        Optional<String> longest = strList.stream()
            .max(Comparator.comparingInt(String::length));

        Optional<String> shortest = strList.stream()
            .min(Comparator.comparingInt(String::length));

        System.out.println("  List:    " + strList);
        System.out.println("  Longest: " + longest.orElse("none"));
        System.out.println("  Shortest:" + shortest.orElse("none"));

        // Sorted by length
        List<String> byLength = strList.stream()
            .sorted(Comparator.comparingInt(String::length))
            .collect(Collectors.toList());
        System.out.println("  By Length ASC: " + byLength);


        separator("Q12: Even/Odd Partition (partitioningBy)");
        /*
         *  partitioningBy → Special collector: 2 groups banata hai
         *  true  group  → Condition satisfy karne wale
         *  false group  → Condition satisfy nahi karne wale
         *  groupingBy se better jab exactly 2 groups chahiye
         */
        List<Integer> numList = IntStream.rangeClosed(1, 10)
            .boxed()
            .collect(Collectors.toList());

        Map<Boolean, List<Integer>> evenOdd = numList.stream()
            .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println("  Numbers: " + numList);
        System.out.println("  Even:    " + evenOdd.get(true));
        System.out.println("  Odd:     " + evenOdd.get(false));

        // Bonus: Prime / Non-Prime partition
        Map<Boolean, List<Integer>> primePartition = IntStream.rangeClosed(2, 20)
            .boxed()
            .collect(Collectors.partitioningBy(Interview2_NumberStringStreams::isPrime));

        System.out.println("  Primes (2-20):     " + primePartition.get(true));
        System.out.println("  Non-Primes (2-20): " + primePartition.get(false));
    }

    // ─── Helper: Prime Check ──────────────────────────────────────────────
    static boolean isPrime(int n) {
        if (n < 2) return false;
        return IntStream.rangeClosed(2, (int) Math.sqrt(n))
                        .noneMatch(i -> n % i == 0);
    }

    private static void separator(String title) {
        System.out.println("\n┌─────────────────────────────────────────────────────────────┐");
        System.out.printf( "│  %-60s│%n", title);
        System.out.println("└─────────────────────────────────────────────────────────────┘");
    }
}

