package Java8.StreamApi;

public class Demo36 {

    // Find first non-repeating character

    public static void main(String[] args) {

        String input = "Thisissomething";

        Character result = input.chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> input.indexOf(ch) == input.lastIndexOf(ch))
                .findFirst()
                .orElse(null);

        System.out.println(result);
    }
}
//2nd highest sallary
//find the non repeating string
//Find the frequency
// find fiest non repeating character
//