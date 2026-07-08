//package dailycode.july8;
//
//public class Atm {
//
//    //Question 4: ATM
//    //
//    //Create an ATM class using encapsulation.
//    //
//    //Private Variables:
//    //- pin
//    //- balance
//    //
//    //Methods:
//    //- changePin(int newPin)
//    //- deposit(double amount)
//    //- withdraw(double amount)
//    //- getBalance()
//    //
//    //Conditions:
//    //- PIN must be exactly 4 digits.
//    //- Deposit amount > 0.
//    //- Withdraw amount <= balance.
//
//    private int pin;
//    private String balance;
//
//    //Methods
//
//
//    public void changePin(int newPin) {
//
//        if (newPin >= 1000 && newPin <= 9999) {
//            pin = newPin;
//            System.out.println("PIN Changed Successfully");
//        } else {
//            System.out.println("Invalid PIN");
//        }
//    }
//         void deposit(double amount ){
//              if (amount>0){
//                  System.out.println("Deposit not possible: ");
//              }
//
//        }
//
//    void withdraw(double  amount) {
//
//        if (amount >= balance) {
//            System.out.println("Withdraw is Sucessfull:::");
//            balance = balance-amount;
//            System.out.println("Amount is debit from account " + balance);
//            System.out.println("Updated Balance is " + balance);
//        } else {
//            System.out.println("Withdraw is failed ");
//        }
//    }
//          }
//
