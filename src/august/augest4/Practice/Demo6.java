package august.augest4.Practice;

public class Demo6 {

    void vote(int age) {

        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or above");

        }

        System.out.println("Eligible");

    }

    public static void main(String[] args) {
        System.out.println();
    }
}



