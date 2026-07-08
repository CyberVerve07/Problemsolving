package dailycode.july06;
public class Code06 {
    public static void main(String[] args) {
        String str = "Hello";
        String reversed = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
// Reverse a String::
        System.out.println("Reversed: " + reversed);
    }
}
