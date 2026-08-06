package august.augest6.CustomExcetion;

public class Test {

    public static void main(String[] args) {

        try {

            Bank.withdraw(940994094, 50000);

        } catch (InsufficientBalanceException e) {

            System.out.println("Custom Exception : " + e.getMessage());

        } catch (IllegalArgumentException e) {

            System.out.println("Validation Error : " + e.getMessage());

        }

    }
}