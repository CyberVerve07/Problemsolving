package Java8.JavaStreamApiPractice;

public class Demo16 {
    //Find first non-repeating element
    public static void main(String[] args) {
        String input="HelloH";

        Character result = input.chars()
                .mapToObj(c -> (char) c)
                .filter(character -> input.indexOf(character) ==
                        input.lastIndexOf(character))
                .findFirst().orElse(null);
        System.out.println("Find the non repeted element is :"+result);



    }

}
