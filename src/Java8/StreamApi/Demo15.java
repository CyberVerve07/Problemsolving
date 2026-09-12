package Java8.StreamApi;

public class Demo15 {

    static void main() {
//Remove the duplicate elements in the string :
        String input = "programming";
        input.chars()  //Converting the String characters into  a stream
                .mapToObj(c -> (char) c)  //chars() integer values deta hai, isliye unhe char mein convert kar rahe hain.
                .filter(c -> input.indexOf(c) != input.lastIndexOf(c))
                .distinct()
                .forEach(System.out::println);
    }
}