package dailycode.july28.Exception;

public class Demo {

    public static void main(String[] args) {

        int age = -5;

        if(age < 0) {
            throw new IllegalArgumentException("Invalid Age");
        }

        System.out.println("Valid Age");
    }
}
