package oops.phonepay;

public class Test {
    public static void main(String[] args) {
        User Test=new User();
        Test.setUserName("Aditya");
        Test.setBalance(0);

        System.out.println("User name is "+Test.getUserName());
        System.out.println(" Balance is "+Test.getBalance());
    }
}
