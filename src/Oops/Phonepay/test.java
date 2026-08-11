package oops.phonepay;

public class Test {
    public static void main(String[] args) {
        User test = new User();
        test.setUserName("Aditya");
        test.setBalance(1000.0);

        System.out.println("User name is " + test.getUserName());
        System.out.println("Balance is " + test.getBalance());
    }
}
