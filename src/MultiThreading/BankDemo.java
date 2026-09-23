package MultiThreading;

class BankAccount {

    private int balance = 1000;

    public void withdraw(int amount) {

        synchronized (this) { // Synchronized  block is the better. to done synchronization in java

            if (balance >= amount) {

                System.out.println(Thread.currentThread().getName()
                        + " is withdrawing " + amount);

                balance = balance - amount;

                System.out.println(Thread.currentThread().getName()
                        + " remaining balance: " + balance);
            } else {
                System.out.println("Insufficient balance");
            }
        }
    }

        public int getBalance () {
            return balance;
        }
    }

    public class BankDemo {

        public static void main(String[] args) {

            BankAccount account = new BankAccount();

            Thread t1 = new Thread(() -> {
                account.withdraw(700);
            }, "Thread-1");

            Thread t2 = new Thread(() -> {
                account.withdraw(700);
            }, "Thread-2");

            t1.start();
            t2.start();
        }
    }

//At a time, only one thread can acquire the required monitor lock and execute
// the synchronized code guarded by that lock.
//we are controlling the order of access to shared resources.
//Only one thread at a time can execute the synchronized critical section protected by the same lock.
//Synchronization block is mostly suitable for done the Synchronization in java