package July3;

import Transport.Scooty;

import java.util.Scanner;

public class code6 {

         public String accountHolder;
         public double balance;
         code6(String accountHolder,double balance ) {
             this.accountHolder = accountHolder;
             this.balance = balance;
         }
          void  deposited(double amount ) {
              if (amount > 0) {
                  System.out.println("Your deposited money  will be Sucesful:");
              } else {
                  System.out.println("Amount is too low for deposite :");

                  balance = amount + balance;
                  System.out.println(balance);

              }

          }

         void  withdral (int amount) {
             if (amount > balance) {
                 System.out.println("Amount will withdrawal sucessfully: ");
                 balance = amount-balance;
                 System.out.println("Remaining balcance is " + balance);
             } else {
                 System.out.println("Your Account Balance is low the widhral amount you enter ");
             }
         }

              void display( int pin){
                 System.out.println("Enter the 4 digit  pin to view your balance:");
                  Scanner sc=new Scanner(System.in);
                   pin= sc.nextInt();
                 for (int i=1;i<=3;i++){
                     System.out.println("Enter pin second time ");
                     System.out.println("Enter 3rd time ");

                     if (pin==1289){
                         System.out.println("Your balance is "+balance);
                     }
                     else {

                         System.out.println("Incorrect pin ");

                     }

                 }

             }
 }


