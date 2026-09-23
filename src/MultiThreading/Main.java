package MultiThreading;

class Bank {

    static int balance = 1000;

    static void withdraw(int amount) {

        // Static synchronized block used to make the  block the Synchronized
        synchronized (Bank.class) {

            System.out.println(Thread.currentThread().getName() + " entered");

            if (balance >= amount) {
                System.out.println(Thread.currentThread().getName() + "withdrawing" + amount);

                balance -= amount;

                System.out.println("Remaining balance: " + balance);
            } else {
                System.out.println("Insufficient balance");
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> Bank.withdraw(700), "Thread-1");

        Thread t2 = new Thread(() -> Bank.withdraw(700), "Thread-2");
        t1.start();
        t2.start();
    }
}