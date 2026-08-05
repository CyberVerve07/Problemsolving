package august.augest4.Practice;

public class Demo1 {

    public static void main(String[] args) {

        System.out.println("Program Started");

        try {

            String name = null;

            System.out.println(name.length());

        } catch (NullPointerException e) {

            System.out.println("Exception Handled Successfully");
            System.out.println(e.getMessage());

        }

        System.out.println("Program Ended");
    }
}