package august.augest22;//         Write a program to print all duplicate elements:
//Expected:
//Constraint: Use List + another collection. Don't use Streams.
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class DuplicateFinder {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 10, 30, 20, 40, 10);

        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (Integer num : numbers) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }

        for (Integer dup : duplicates) {
            System.out.print(dup + " ");
        }
    }
}
