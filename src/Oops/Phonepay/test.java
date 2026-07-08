package Oops.Phonepay;

public class test {
    public static void main(String[] args) {
        User test=new User();
        test.setUserName("Aditya");
        test.setBalance(0);

        System.out.println("User name is "+test.getUserName());
        System.out.println(" Balance is "+test.getBalance());
    }
}
