package august.augest4.Practice;

public class Demo7 {

    public static void main(String[] args) {

        try {

            int x = 10 / 0;

        } catch (Exception e) {

            System.out.println("Parent");

    //    } catch (ArithmeticException e) {

            System.out.println("Child");

        }
    }
}
