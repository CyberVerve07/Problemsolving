package Java8.Lambda;

interface BankAccount {
    default void deposit() {
        checkSecurity(); // Private method ko call kiya
        System.out.println("Money Deposited!");
    }
    default void withdraw() {
        checkSecurity(); // Wahi private method firse reuse kiya
        System.out.println("Money Withdrawn!");
    }

    // PRIVATE METHOD (Helper method)
    // Ye bahar kisi ko nahi dikhega, sirf andar code shortcut ke liye hai
    private void checkSecurity() {
        System.out.println("Checking security...");
    }
}

  class  Test1{

      public static void main(String[] args) {
          BankAccount bankAccount=new BankAccount() {
              @Override
              public void deposit() {
                  BankAccount.super.deposit();
              }
          };
          bankAccount.deposit();
          bankAccount.withdraw();
      }

  }